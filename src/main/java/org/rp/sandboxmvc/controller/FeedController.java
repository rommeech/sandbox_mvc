package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.helper.MessageProvider;
import org.rp.sandboxmvc.helper.Status;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.ModelException;
import org.rp.sandboxmvc.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller(value = "feedController")
@RequestMapping(value = "/feeds")
public class FeedController extends AbstractController {

    private static Logger logger = LogManager.getLogger(FeedController.class);

    @Autowired
    private FeedService feedService;

    @Autowired
    private MessageProvider messageProvider;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView feedList() {
        ModelAndView model = new ModelAndView();
        model.addObject("feeds", feedService.getFeeds());
        model.addObject("total", feedService.countFeeds());
        model.setViewName("feed_list");
        return model;
    }

    @RequestMapping(value = "/delete/{id}/", method = RequestMethod.GET)
    public ModelAndView feedDelete(@PathVariable Long id) {
        // TODO: call all delete methods as REST service

        Feed feed = getById(id);

        if (feed == null) {
            show404("feedDelete: feed not found, id=" + id);
        }

        feedService.delete(id);
        messageProvider.addInfoMessage("Feed successfully deleted");
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/feeds/");
        return model;
    }

    @RequestMapping(value = "/read/{id}/", method = RequestMethod.GET)
    public ModelAndView feedRead(@PathVariable Long id) {
        Feed feed = getById(id);

        if (feed == null) {
            show404("feedRead: feed not found, id=" + id);
        }

        try {
            feedService.readFeed(feed);
            messageProvider.addInfoMessage("Feed " + feed.getId() + " " + feed.getFeedUrl() + " read successfully");
        } catch (Exception  e) {
            messageProvider.addErrorMessage("Cannot read feed, error " + e);
            throw new ControllerException("Cannot read feed", e);
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/feeds/");
        return model;
    }

    @RequestMapping(value = "/edit/{id}/", method = RequestMethod.GET)
    public ModelAndView feedEdit(@PathVariable Long id) {
        Feed feed = getById(id);

        if (feed == null) {
            show404("feedEdit: feed not found, id=" + id);
        }

        ModelAndView modelAndView = getEditModel();
        modelAndView.addObject("feed", feed);

        return modelAndView;
    }

    @RequestMapping(value = "/new/", method = RequestMethod.GET)
    public ModelAndView feedNew() {
        ModelAndView modelAndView = getEditModel();
        Feed newFeed;
        try {
            newFeed = feedService.newFeed();
        } catch (ModelException e) {
            throw new ControllerException("Cannot create new empty feed object", e);
        }
        modelAndView.addObject("feed", newFeed);
        return modelAndView;
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView feedSave(@ModelAttribute("feed") @Valid Feed feed, BindingResult result) {

        ModelAndView model = new ModelAndView();

        if (result.hasErrors()) {
            logger.error(result.getAllErrors());
            messageProvider.addWarningMessage("Please fill the form properly");
            return getEditModel();
        }

        if (feed.getId() == null || feed.getId().equals(0L)) {
            feedService.insert(feed);
            messageProvider.addInfoMessage("New feed successfully added");
        }
        else if (isFeedIdValid(feed.getId())) {
            feedService.update(feed);
            messageProvider.addInfoMessage("Feed successfully saved");
        }
        else {
            messageProvider.addErrorMessage("Cannot save, something wrong with this feed, maybe already deleted in another session");
        }

        model.setViewName("redirect:/feeds/");
        return model;
    }

    private boolean isFeedIdValid(Long id) {
        return getById(id) != null;
    }

    private Feed getById(Long id) {
        return feedService.getById(id);
    }

    private void show404(String errorMsg) {
        logger.error(errorMsg);
        throw new NotFoundException();
    }

    private ModelAndView getEditModel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("statuses", Status.values());
        modelAndView.setViewName("feed_edit");
        return modelAndView;
    }

}

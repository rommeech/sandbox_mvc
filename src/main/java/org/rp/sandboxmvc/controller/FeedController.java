package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.helper.MessageProvider;
import org.rp.sandboxmvc.model.Status;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.service.FeedService;
import org.rp.sandboxmvc.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;

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
        // TODO: Invalid service method, here should
        // TODO: call all delete methods as REST service
        feedService.delete(id);
        messageProvider.addInfoMessage("Feed successfully deleted");
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/feeds/");
        return model;
    }

    @RequestMapping(value = "/read/{id}/", method = RequestMethod.GET)
    public ModelAndView feedRead(@PathVariable Long id) {
        Feed feed = getByIdOrShow404(id);

        try {
            feedService.readPosts(feed);
            messageProvider.addInfoMessage("Feed " + feed.getId() + " " + feed.getFeedUrl() + " read successfully");
        } catch (ServiceException e) {
            messageProvider.addErrorMessage("Cannot read feed: " + e.getStackTrace());
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/feeds/");
        return model;
    }

    @RequestMapping(value = "/edit/{id}/", method = RequestMethod.GET)
    public ModelAndView feedEdit(@PathVariable Long id) {
        Feed feed = getByIdOrShow404(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feed", feed);
        modelAndView.addObject("statusList", Arrays.asList(Status.values()));
        modelAndView.setViewName("feed_edit");
        return modelAndView;
    }

    @RequestMapping(value = "/new/", method = RequestMethod.GET)
    public ModelAndView feedNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feed", new Feed());
        modelAndView.addObject("statusList", Arrays.asList(Status.values()));
        modelAndView.setViewName("feed_edit");
        return modelAndView;
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView feedSave(@ModelAttribute("feed") @Valid Feed feed, BindingResult result) {

        ModelAndView model = new ModelAndView();

        if (result.hasErrors()) {
            logger.error(result.getAllErrors());
            messageProvider.addWarningMessage("Please fill the form properly");
            return model;
        }

        if (feed.getId() == null || feed.getId().equals(0L)) {
            feedService.insert(feed);
            messageProvider.addInfoMessage("New feed successfully added");
        }
        else {
            feedService.update(feed);
            messageProvider.addInfoMessage("Feed successfully saved");
        }

        model.setViewName("redirect:/feeds/");
        return model;
    }

    private Feed getByIdOrShow404(Long id) {
        Feed feed = feedService.getById(id);
        if (feed == null) {
            logger.error("Feed not found, invalid id=" + id);
            throw new NotFoundException();
        }
        return feed;
    }
}

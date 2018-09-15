package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.helper.MessageProvider;
import org.rp.sandboxmvc.model.Status;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/feeds")
public class FeedController extends AbstractController {

    private static Logger logger = LogManager.getLogger(FeedController.class);

    @Autowired
    private FeedService feedService;

    @Autowired
    private MessageProvider messageProvider;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String feedList(Model model, SearchCriteria searchCriteria) {
        model.addAttribute("feeds", feedService.getFeeds(searchCriteria));
        model.addAttribute("total", feedService.countFeeds(searchCriteria));
        model.addAttribute("searchCriteria", searchCriteria);
        return "feed_list";
    }

    @RequestMapping(value = "/delete/{id}/", method = RequestMethod.GET)
    public String feedDelete(@PathVariable Long id) {
        feedService.delete(id);
        messageProvider.addInfoMessage("Feed successfully deleted");
        return "redirect:/feeds/";
    }


    @RequestMapping(value = "/edit/{id}/", method = RequestMethod.GET)
    public ModelAndView feedEdit(@PathVariable Long id) {

        Feed feed = feedService.getById(id);
        if (feed == null) {
            throw new NotFoundException();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feed", feed);
        modelAndView.addObject("statusList", Status.values());
        modelAndView.setViewName("feed_edit");
        return modelAndView;
    }

    @RequestMapping(value = "/new/", method = RequestMethod.GET)
    public ModelAndView feedNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feed", new Feed());
        modelAndView.setViewName("feed_edit");
        return modelAndView;
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public String feedSave(Model model, @ModelAttribute("feed") @Valid Feed feed, BindingResult result) {

        if (result.hasErrors()) {
            logger.error(result.getAllErrors());
            model.addAttribute("errorMsg", this.getErrors(result));
            messageProvider.addWarningMessage("Please fill the form properly");
            return "feed_edit";
        }

        if (feed.getId() == null || feed.getId().equals(0L)) {
            messageProvider.addInfoMessage("New feed successfully added");
            feedService.insert(feed);
        }
        else {
            messageProvider.addInfoMessage("Feed successfully saved");
            feedService.update(feed);
        }

        return "redirect:/feeds/";
    }

}

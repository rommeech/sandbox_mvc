package org.rp.sandboxmvc.controller;

import org.rp.sandboxmvc.model.feed.Feed;
import org.rp.sandboxmvc.service.feed.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/feeds")
public class FeedController {

    @Autowired
    FeedService feedService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView feedsList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feedsList", feedService.getAll());
        modelAndView.setViewName("feed/FeedsList");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public ModelAndView feedsForm(@PathVariable Long id) {

        Feed feed = feedService.getById(id);
        if (feed == null) {
            throw new NotFoundException();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("feed", feed);
        modelAndView.setViewName("feed/FeedsForm");
        return modelAndView;
    }

}

package org.rp.sandboxmvc.controller;

import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.service.tg.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bots/")
public class BotController {

    private final BotService botService;

    @Autowired
    public BotController(BotService botService) {
        this.botService = botService;
    }

    @RequestMapping(value = {"/", "/list/"}, method = RequestMethod.GET)
    public ModelAndView botList(SearchCriteria searchCriteria) {
        ModelAndView model = new ModelAndView();
        model.addObject("bots", botService.getBots(searchCriteria));
        model.addObject("total", botService.countBots(searchCriteria));
        model.addObject("searchCriteria", searchCriteria);
        model.setViewName("tg/bot_list");
        return model;
    }

}

package org.rp.sandboxmvc.controller;

import org.rp.sandboxmvc.service.tg.BotService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bots/")
public class BotController {

    private final BotService botService;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    /*public ModelAndView botList() {
        ModelAndView model = new ModelAndView();
        model.addObject("bots", botService())
        model.setViewName("tg/bot_list");
    }*/

}

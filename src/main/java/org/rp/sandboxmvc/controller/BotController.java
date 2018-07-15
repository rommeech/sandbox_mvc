package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.model.tg.Bot;
import org.rp.sandboxmvc.service.tg.BotService;
import org.rp.sandboxmvc.validator.BotValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/bots/")
public class BotController extends AbstractController {

    private final BotService botService;
    private static final Logger logger = LogManager.getLogger(BotController.class);

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

    @RequestMapping(value = "/edit/{id}/", method = RequestMethod.GET)
    public ModelAndView botEdit(@PathVariable Long id) {
        Bot bot = botService.getById(id);

        if (bot == null) {
            logger.error("Bot not found, unknown id=" + id);
            throw new NotFoundException("Bot not found, unknown id=" + id);
        }

        ModelAndView model = new ModelAndView();
        model.addObject("bot", bot);
        model.setViewName("tg/bot_edit");
        return model;
    }

    @RequestMapping(value = "/new/", method = RequestMethod.GET)
    public ModelAndView botNew() {
        ModelAndView model = new ModelAndView();
        model.addObject("bot", new Bot());
        model.setViewName("tg/bot_edit");
        return model;
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView botSave(@ModelAttribute("bot") @Valid Bot bot, BindingResult result) {

        ModelAndView model = new ModelAndView();

        BotValidator botValidator = new BotValidator(botService);
        botValidator.validate(bot, result);

        if (result.hasErrors()) {
            logger.error("Cannot save bot, validation errors: " + result.toString());
            model.setViewName("tg/bot_edit");
        }
        else {
            if (bot.getId() == null || bot.getId() == 0L) {
                botService.insert(bot);
            }
            else {
                botService.update(bot);
            }
            model.setViewName("redirect:/bots/?success=true");
        }

        return model;
    }

    @RequestMapping(value = "/delete/{id}/", method = RequestMethod.GET)
    public ModelAndView botDelete(@PathVariable Long id) {
        Bot bot = botService.getById(id);

        if (bot == null) {
            logger.error("Bot not found, unknown id=" + id);
            throw new NotFoundException("Bot not found, unknown id=" + id);
        }

        botService.delete(id);

        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/bots/?success=true");
        return model;
    }

}

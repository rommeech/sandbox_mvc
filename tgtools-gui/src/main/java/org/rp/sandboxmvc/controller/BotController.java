package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.helper.MessageProvider;
import org.rp.sandboxmvc.model.Bot;
import org.rp.sandboxmvc.service.BotService;
import org.rp.sandboxmvc.service.ServiceException;
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

    private static final Logger logger = LogManager.getLogger(BotController.class);

    @Autowired
    private BotService botService;

    @Autowired
    private MessageProvider messageProvider;


    @RequestMapping(value = {"/", "/list/"}, method = RequestMethod.GET)
    public ModelAndView botList() {
        ModelAndView model = new ModelAndView();
        model.addObject("bots", botService.getBots());
        model.addObject("total", botService.countBots());
        model.setViewName("bot_list");
        return model;
    }

    @RequestMapping(value = "/edit/{id}/", method = RequestMethod.GET)
    public ModelAndView botEdit(@PathVariable Long id) {
        Bot bot = botService.getById(id);

        if (bot == null) {
            logger.error("[botEdit] Bot not found, unknown id=" + id);
            throw new NotFoundException("Bot not found, unknown id=" + id);
        }

        ModelAndView model = new ModelAndView();
        model.addObject("bot", bot);
        model.setViewName("bot_edit");
        return model;
    }

    @RequestMapping(value = "/new/", method = RequestMethod.GET)
    public ModelAndView botNew() {
        ModelAndView model = new ModelAndView();
        model.addObject("bot", new Bot());
        model.setViewName("bot_edit");
        return model;
    }

    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public ModelAndView botSave(@ModelAttribute("bot") @Valid Bot bot, BindingResult result) {

        ModelAndView model = new ModelAndView();

        BotValidator botValidator = new BotValidator(botService);
        botValidator.validate(bot, result);

        if (result.hasErrors()) {
            logger.error("Cannot save bot, validation errors: " + result.toString());
            messageProvider.addWarningMessage("Please fill the form properly");
            model.setViewName("bot_edit");
        }
        else {
            if (bot.getId() == null || bot.getId() == 0L) {
                botService.insert(bot);
                messageProvider.addInfoMessage("Successfully added");
            }
            else {
                botService.update(bot);
                messageProvider.addInfoMessage("Successfully updated");
            }
            model.setViewName("redirect:/bots/");
        }

        return model;
    }

    @RequestMapping(value = "/delete/{id}/", method = RequestMethod.GET)
    public ModelAndView botDelete(@PathVariable Long id) {
        Bot bot = botService.getById(id);

        if (bot == null) {
            logger.error("[botDelete] Bot not found, unknown id=" + id);
            throw new NotFoundException("Bot not found, unknown id=" + id);
        }

        botService.delete(bot);

        ModelAndView model = new ModelAndView();
        messageProvider.addInfoMessage("Successfully deleted");
        model.setViewName("redirect:/bots/");
        return model;
    }

    @RequestMapping(value = "/getme/{id}/")
    public ModelAndView botGetMe(@PathVariable Long id) {
        Bot bot = botService.getById(id);

        if (bot == null) {
            logger.error("[botGetMe] Bot not found, unknown id=" + id);
            throw new NotFoundException("Bot not found, unknown id=" + id);
        }

        try {
            botService.doGetMeRequest(bot);
            messageProvider.addInfoMessage("GetMe request successfully processed");
        } catch (ServiceException e) {
            logger.error("[botGetMe] " + e.getStackTrace());
            messageProvider.addErrorMessage("Problem with GetMe request, check logs");
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/bots/");
        return model;
    }

}

package org.rp.sandboxmvc.validator;

import org.rp.sandboxmvc.model.tg.Bot;
import org.rp.sandboxmvc.service.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class BotValidator implements Validator {

    private final BotService botService;

    @Autowired
    public BotValidator(BotService botService) {
        this.botService = botService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Bot.class.equals(clazz);
    }


    /*
        It is a very bad implementation of unique checking (see BotService as well), because it is NOT thread safe.
        For now it is more than enough, but for for high-load live is dangerous.
     */
    @Override
    public void validate(Object target, Errors errors) {

        Bot bot = (Bot) target;

        if (bot.getName() == null || bot.getName().isEmpty()) {
            errors.rejectValue("name", "bot.validator.error.name.empty");
        }

        if (bot.getToken() == null || bot.getToken().isEmpty()) {
            errors.rejectValue("token", "bot.validator.error.token.empty");
        }
        else if (!botService.isTokenUnique(bot.getToken(), bot.getId())) {
            errors.rejectValue("token", "bot.validator.error.token.exists");
        }

        if (bot.getUsername() == null || bot.getUsername().isEmpty()) {
            errors.rejectValue("username", "bot.validator.error.username.empty");
        }
        else if (!botService.isUsernameUnique(bot.getUsername(), bot.getId())) {
            errors.rejectValue("username", "bot.validator.error.username.exists");
        }
    }
}

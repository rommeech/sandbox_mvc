package org.rp.sandboxmvc.validator;

import org.rp.sandboxmvc.model.Bot;
import org.rp.sandboxmvc.service.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ChannelValidator implements Validator {

    private final BotService botService;

    @Autowired
    public ChannelValidator(BotService botService) {
        this.botService = botService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Bot.class.equals(clazz);
    }

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

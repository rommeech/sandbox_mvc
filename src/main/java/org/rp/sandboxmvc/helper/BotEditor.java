package org.rp.sandboxmvc.helper;

import org.rp.sandboxmvc.model.Bot;
import org.rp.sandboxmvc.service.BotService;

import java.beans.PropertyEditorSupport;

public class BotEditor extends PropertyEditorSupport {

    private final BotService botService;

    public BotEditor(BotService botService) {
        this.botService = botService;
    }

    @Override
    public String getAsText() {
        Bot bot = (Bot) this.getValue();
        return bot != null ? bot.getId().toString() : null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Bot bot = botService.getById(Long.parseLong(text));
        this.setValue(bot);
    }
}

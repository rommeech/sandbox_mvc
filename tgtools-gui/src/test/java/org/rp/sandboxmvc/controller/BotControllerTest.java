package org.rp.sandboxmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.rp.sandboxmvc.model.Bot;
import org.rp.sandboxmvc.service.BotService;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BotControllerTest {

    private final List<Bot> bots = new ArrayList<>();

    /*@Before
    public void setUp() throws Exception {
        Bot bot = new Bot();
        bot.setId(1L);
        bot.setAbout("About");
        bot.setToken(UUID.randomUUID().toString());
        bot.setUserId(2);
        bot.setUsername(UUID.randomUUID().toString());
        bots.add(bot);
    }

    @Test
    public void testBotList() {
       BotService botService = mock(BotService.class);

       BotController botController = new BotController();
       ReflectionTestUtils.setField(botController, "botService", botService);

        ExtendedModelMap uiModel = new ExtendedModelMap();
        //uiModel.addAttribute("bots", )

    }*/

    @Test
    public void dummy() {
        assertTrue(true);
    }


}
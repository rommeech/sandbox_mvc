package org.rp.sandboxmvc.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.service.TelegramService;
import org.rp.telegram.botapi.request.RequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import static org.rp.sandboxmvc.helper.TimeInterval.MINUTE;
import static org.rp.sandboxmvc.helper.TimeInterval.SECOND;

@Transactional
@Component
public class TelegramJob {

    private static final Logger logger = LogManager.getLogger(TelegramJob.class);

    @Autowired
    TelegramService telegramApiService;

    @Scheduled(initialDelay = 10_000_000 * SECOND, fixedDelay = 1 * MINUTE)
    public void sendTelegramPosts() throws RequestException {

        telegramApiService.sendPostsToChannels();

    }


}

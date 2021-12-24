package org.rp.sandboxmvc.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.service.TelegramService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import static org.rp.sandboxmvc.helper.TimeInterval.MINUTE;
import static org.rp.sandboxmvc.helper.TimeInterval.SECOND;

// TODO: microservice?

@Component
@Transactional
public class TelegramSenderJob {

    private static final Logger LOGGER = LogManager.getLogger(TelegramSenderJob.class);

    public static final int JOB_INITIAL_DELAY = 5 * SECOND;
    public static final int JOB_FIXED_DELAY = 1 * MINUTE;

    private final TelegramService telegramService;

    public TelegramSenderJob(TelegramService telegramApiService) {
        this.telegramService = telegramApiService;
    }

    @Scheduled(initialDelay = JOB_INITIAL_DELAY, fixedDelay = JOB_FIXED_DELAY)
    public void sendTelegramPosts() {
        LOGGER.info("TelegramSenderJob started");

        telegramService.sendMessagesToChannels();

        LOGGER.info("TelegramSenderJob finished");
    }


}

package org.rp.sandboxmvc.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.service.FeedReaderService;
import org.rp.sandboxmvc.service.ServiceException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import static org.rp.sandboxmvc.helper.TimeInterval.MINUTE;
import static org.rp.sandboxmvc.helper.TimeInterval.SECOND;

// TODO: micro-service

@Component
@Transactional
public class FeedReaderJob {

    private static final Logger LOGGER = LogManager.getLogger(FeedReaderJob.class);

    public static final int JOB_INITIAL_DELAY = 5 * SECOND;
    public static final int JOB_FIXED_DELAY = 15 * MINUTE;

    private final FeedReaderService feedReaderService;

    public FeedReaderJob(FeedReaderService feedReaderService) {
        this.feedReaderService = feedReaderService;
    }

    @Scheduled(initialDelay = JOB_INITIAL_DELAY, fixedDelay = JOB_FIXED_DELAY)
    public void executeReadFeeds() {
        LOGGER.info("RssReaderJob started");

        try {
            feedReaderService.readFeeds();
        } catch (ServiceException e) {
            LOGGER.error("RssReaderJob error", e);
        }

        LOGGER.info("RssReaderJob finished");
    }

}

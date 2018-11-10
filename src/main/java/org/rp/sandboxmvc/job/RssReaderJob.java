package org.rp.sandboxmvc.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.service.FeedReaderService;
import org.rp.sandboxmvc.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public class RssReaderJob {

    private static final Logger logger = LogManager.getLogger(RssReaderJob.class);

    private static final int SECOND = 1_000;
    private static final int MINUTE = 60 * SECOND;
    private static final int HOUR   = 60 * MINUTE;

    @Autowired
    private FeedReaderService feedReaderService;

    @Scheduled(initialDelay = 10 * SECOND, fixedDelay = 3 * MINUTE)
    public void readRss() {
        logger.info("Rss reader job started");

        try {
            feedReaderService.readFeeds();
        } catch (ServiceException e) {
            logger.fatal("RssReaderJob error " + e);
            e.printStackTrace();
        }

        logger.info("Rss reader job finished");
    }


}

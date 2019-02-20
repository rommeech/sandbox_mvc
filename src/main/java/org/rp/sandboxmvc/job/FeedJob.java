package org.rp.sandboxmvc.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.service.FeedReaderService;
import org.rp.sandboxmvc.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import static org.rp.sandboxmvc.helper.TimeInterval.MINUTE;
import static org.rp.sandboxmvc.helper.TimeInterval.SECOND;


@Transactional
@Component
public class FeedJob {

    private static final Logger logger = LogManager.getLogger(FeedJob.class);

    @Autowired
    private FeedReaderService feedReaderService;

    @Scheduled(initialDelay = 5_000_000 * SECOND, fixedDelay = 3 * MINUTE)
    public void executeReadFeeds() {
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

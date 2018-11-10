package org.rp.sandboxmvc.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public class TelegramJob {

    private static final Logger logger = LogManager.getLogger(TelegramJob.class);


}

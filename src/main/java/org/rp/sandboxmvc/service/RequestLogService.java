package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.dao.RequestLogDao;
import org.rp.sandboxmvc.model.RequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestLogService extends AbstractService {

    @Autowired
    private static RequestLogDao requestLogDao;

    @Transactional
    public void insert(RequestLog model) {
        requestLogDao.insert(model);
    }

    @Transactional
    public void update(RequestLog model) {
        requestLogDao.update(model);
    }


}

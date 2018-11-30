package org.rp.sandboxmvc.service;

import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.dao.RequestLogDao;
import org.rp.sandboxmvc.model.RequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestLogService extends AbstractService {

    private static final Logger logger = LogManager.getLogger(RequestLogService.class);

    @Autowired
    private RequestLogDao requestLogDao;

    @Transactional
    public void insert(RequestLog model) {
        requestLogDao.insert(model);
    }

    @Transactional
    public void update(RequestLog model) {
        requestLogDao.update(model);
    }

    @Transactional
    public void logRequest(String apiMethodName, Double duration, Request request, Response response, String responseBody) {
        RequestLog requestLog = new RequestLog.Builder()
                .apiMethod(apiMethodName)
                .requestMethod(request.method())
                .requestUrl(request.url().toString())
                .duration(duration)
                .responseHttpCode(response.code())
                .responseHttpMessage(response.message())
                .responseBody(responseBody)
                .build();
        if (request.body() != null) {
            requestLog.setRequestBody(request.body().toString());
            requestLog.setRequestContentType(request.body().contentType().toString());
        }

        logger.info("logRequest: " + requestLog);
        insert(requestLog);
    }
}

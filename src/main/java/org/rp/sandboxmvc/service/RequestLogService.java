package org.rp.sandboxmvc.service;

import okhttp3.Request;
import okhttp3.Response;
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


    public void logRequest(String apiMethodName, Double duration, Request request, Response response) {
        RequestLog requestLog = new RequestLog.Builder()
                .publication(null)
                .apiMethod(apiMethodName)
                .requestMethod(request.method())
                .requestUrl(request.url().toString())
                .requestBody(request.body().toString())
                .duration(duration)
                .responseHttpCode(response.code())
                .responseHttpMessage(response.message())
                .responseBody(response.body().toString())
                .build();
        this.insert(requestLog);
    }
}

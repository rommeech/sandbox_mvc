package org.rp.testapp;

import org.rp.sandboxmvc.dao.RequestLogDao;
import org.rp.sandboxmvc.model.RequestLog;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CreateRequestLogApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring-app.xml");
        context.refresh();

        RequestLog requestLog = new RequestLog.Builder()
                .apiMethod("TEST")
                .requestMethod("GET")
                .requestUrl("URL")
                .duration(1D)
                .responseHttpCode(100)
                .build();

        RequestLogDao requestLogDao = (RequestLogDao) context.getBean("RequestLogDao");

        requestLogDao.insert(requestLog);
    }

}

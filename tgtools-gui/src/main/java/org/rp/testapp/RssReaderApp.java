package org.rp.testapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// TODO: remove to integrationstest package!

public class RssReaderApp {

    public static void main(String[] args) {

        AbstractApplicationContext context = new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/spring-config.xml");
        context.refresh();

        System.out.println(System.getProperty("java.class.path"));

    }

}

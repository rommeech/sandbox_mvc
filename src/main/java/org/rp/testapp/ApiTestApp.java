package org.rp.testapp;

import org.rp.telegram.botapi.http.HttpException;
import org.rp.telegram.botapi.request.GetMeRequest;

import java.io.IOException;

public class ApiTestApp {

    public static void main(String[] args) {

        GetMeRequest request = new GetMeRequest();
        try {
            request.doRequest("468561122:AAHdWFuL5s0meYG9fcJOR6VkEiH1iu7cpU8");
        } catch (HttpException | IOException e) {
            e.printStackTrace();
        }

    }

}

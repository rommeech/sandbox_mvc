package org.rp.testapp;

import org.rp.telegram.botapi.http.HttpException;
import org.rp.telegram.botapi.request.GetMeRequest;

import java.io.IOException;

public class ApiTestApp {

    public static void main(String[] args) {

        GetMeRequest request = new GetMeRequest();
        try {
            request.doRequest("...");
        } catch (HttpException | IOException e) {
            e.printStackTrace();
        }

    }

}

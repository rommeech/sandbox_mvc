package org.rp.testapp;

import org.rp.telegram.botapi.http.HttpException;
import org.rp.telegram.botapi.request.GetMeRequest;
import org.rp.telegram.botapi.response.UserResponse;

import java.io.IOException;

public class ApiTestApp {

    public static void main(String[] args) throws IOException, HttpException {

        GetMeRequest request = new GetMeRequest();
        UserResponse response = request.doRequest(args[0]);
        System.out.println(response);
    }

}

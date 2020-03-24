package org.rp.testapp;

import org.rp.tg.botapi.request.GetMeRequest;
import org.rp.tg.botapi.request.RequestException;
import org.rp.tg.botapi.response.UserResponse;

public class ApiTestApp {

    public static void main(String[] args) throws RequestException {

        GetMeRequest request = new GetMeRequest();
        UserResponse response = request.doRequest(args[0]);
        System.out.println(response);
    }

}

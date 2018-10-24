package org.rp.testapp;

import org.rp.telegram.botapi.request.GetMeRequest;
import org.rp.telegram.botapi.request.RequestException;
import org.rp.telegram.botapi.response.UserResponse;

public class ApiTestApp {

    public static void main(String[] args) throws RequestException {

        GetMeRequest request = new GetMeRequest();
        UserResponse response = request.doRequest(args[0]);
        System.out.println(response);
    }

}

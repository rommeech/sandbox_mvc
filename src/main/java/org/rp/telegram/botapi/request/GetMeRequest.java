package org.rp.telegram.botapi.request;

import org.rp.telegram.botapi.helper.ApiMethod;
import org.rp.telegram.botapi.http.HttpClient;
import org.rp.telegram.botapi.http.HttpException;
import org.rp.telegram.botapi.http.HttpMethod;
import org.rp.telegram.botapi.response.UserResponse;

import java.io.IOException;

public class GetMeRequest extends AbstractApiRequest {

    @Override
    public UserResponse doRequest(String token) throws HttpException, IOException {

        HttpClient request = new HttpClient.Builder()
                .httpMethod(HttpMethod.GET)
                .apiMethod(ApiMethod.GET_ME)
                .request(this)
                .responseClass(UserResponse.class)
                .token(token)
                .build();

        UserResponse response = (UserResponse) request.doRequest();
        return response;
    }

}

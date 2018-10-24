package org.rp.telegram.botapi.request;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.telegram.botapi.helper.ApiMethod;
import org.rp.telegram.botapi.http.HttpClient;
import org.rp.telegram.botapi.http.HttpException;
import org.rp.telegram.botapi.http.HttpMethod;
import org.rp.telegram.botapi.response.UserResponse;

public class GetMeRequest extends AbstractApiRequest {

    private final static Logger logger = LogManager.getLogger(GetMeRequest.class);

    @Override
    public UserResponse doRequest(String token) throws RequestException {

        HttpClient request = new HttpClient.Builder()
                .httpMethod(HttpMethod.GET)
                .apiMethod(ApiMethod.GET_ME)
                .request(this)
                .responseClass(UserResponse.class)
                .token(token)
                .build();

        UserResponse response;
        try {
            response = (UserResponse) request.doRequest();
        } catch (HttpException e) {
            logger.error("GetMeRequest error: " + e);
            throw new RequestException("GetMeRequest error", e);
        }
        return response;
    }

}

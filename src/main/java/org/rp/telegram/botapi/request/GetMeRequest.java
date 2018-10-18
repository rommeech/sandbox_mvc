package org.rp.telegram.botapi.request;

import org.rp.telegram.botapi.http.ApiHttpRequest;
import org.rp.telegram.botapi.http.HttpException;
import org.rp.telegram.botapi.http.HttpMethod;

public class GetMeRequest extends AbstractApiRequest {

    @Override
    public String getApiMethodName() {
        return "getMe";
    }

    @Override
    public void doRequest(String token) throws HttpException {

        ApiHttpRequest request = new ApiHttpRequest.Builder()
                .httpMethod(HttpMethod.GET)
                .request(this)
                .token(token)
                .build();
        request.doRequest();

    }


}

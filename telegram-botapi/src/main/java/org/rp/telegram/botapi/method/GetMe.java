package org.rp.telegram.botapi.method;

import com.fasterxml.jackson.core.type.TypeReference;
import org.rp.telegram.botapi.BotApiMethod;
import org.rp.telegram.botapi.client.AbstractApiHttpRequest;
import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.exception.HttpException;
import org.rp.telegram.botapi.exception.JsonException;
import org.rp.telegram.botapi.type.User;
import org.rp.telegram.botapi.util.MethodName;
import org.rp.telegram.botapi.util.ResponseModel;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 20.03.20
 * Time: 20:08
 */

// TODO: unittests
// TODO: javadoc

public class GetMe extends AbstractApiHttpRequest implements BotApiMethod {

    private static final long serialVersionUID = -3294279648405728973L;

    @Override
    public ResponseModel<User> doRequest() throws BotApiException {

        String responseBody;
        try {
            responseBody = this.httpClientInstance().queryStringRequest(
                    buildApiUrl(MethodName.GET_ME.apiMethodName()));
        } catch (IOException e) {
            throw new HttpException("Server communication error", e);
        }

        ResponseModel<User> responseModel;
        try {
            responseModel = (ResponseModel<User>) this.jsonMapperInstance().unmarshal(
                    responseBody, new TypeReference<ResponseModel<User>>(){});
        } catch (IOException e) {
            throw new JsonException("Cannot unmarshal JSON", e);
        }

        return responseModel;
    }

    public static class Builder extends AbstractClientBuilder<GetMe, Builder> {

        @Override
        protected GetMe getApiMethod() {
            return new GetMe();
        }

        @Override
        protected Builder getApiMethodBuilder() {
            return this;
        }
    }

}

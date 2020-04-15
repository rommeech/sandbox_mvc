package org.rp.telegram.botapi.method;

import com.fasterxml.jackson.core.type.TypeReference;
import org.rp.telegram.botapi.BotApiMethod;
import org.rp.telegram.botapi.client.AbstractApiHttpRequest;
import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.exception.HttpException;
import org.rp.telegram.botapi.exception.JsonException;
import org.rp.telegram.botapi.requestmodel.SendMessageRequestModel;
import org.rp.telegram.botapi.type.Message;
import org.rp.telegram.botapi.util.MethodName;
import org.rp.telegram.botapi.util.ResponseModel;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 24.03.20
 * Time: 12:10
 */

// TODO: unittests
// TODO: javadoc

public class SendMessage extends AbstractApiHttpRequest<SendMessageRequestModel> implements BotApiMethod {

    private static final long serialVersionUID = 1072199871908684249L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public ResponseModel<Message> doRequest() throws BotApiException {

        String responseBody;
        try {
            responseBody = this.httpClientInstance().applicationJsonRequest(
                    buildApiUrl(MethodName.SEND_MESSAGE.apiMethodName()),
                    this.jsonMapperInstance().marshal(this.getRequestModel())
            );
        } catch (IOException e) {
            throw new HttpException("Server communication error", e);
        }

        ResponseModel<Message> responseModel;
        try {
            responseModel = (ResponseModel<Message>) this.jsonMapperInstance().unmarshal(
                    responseBody, new TypeReference<ResponseModel<Message>>(){});
        } catch (IOException e) {
            throw new JsonException("Cannot unmarshal JSON", e);
        }

        return responseModel;
    }

    public static class Builder extends AbstractClientBuilder<SendMessage, SendMessage.Builder> {

        private SendMessage sendMessage;

        @Override
        protected SendMessage getApiMethod() {
            if (sendMessage == null) {
                sendMessage = new SendMessage();
            }
            return sendMessage;
        }

        @Override
        protected Builder getApiMethodBuilder() {
            return this;
        }

    }
}

package org.rp.telegram.botapi;

import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.method.GetMe;
import org.rp.telegram.botapi.method.SendMessage;
import org.rp.telegram.botapi.requestmodel.SendMessageRequestModel;
import org.rp.telegram.botapi.type.Message;
import org.rp.telegram.botapi.type.User;
import org.rp.telegram.botapi.util.Const;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 20.03.20
 * Time: 19:55
 */

// TODO: unittests
// TODO: javadoc

public class TelegramBotApi implements BotApiClient {

    @Override
    public String getApiVersion() {
        return Const.API_VERSION;
    }

    @Override
    public User getMe(String token) throws BotApiException {
        return new GetMe.Builder()
                .token(token)
                .build()
                .doRequest()
                .getResult();
    }

    @Override
    public Message sendMessage(String token, SendMessageRequestModel requestModel) throws BotApiException {
        return new SendMessage.Builder()
                .requestModel(requestModel)
                .token(token)
                .build()
                .doRequest()
                .getResult();
    }

}

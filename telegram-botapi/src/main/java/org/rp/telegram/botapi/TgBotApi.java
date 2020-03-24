package org.rp.telegram.botapi;

import org.rp.telegram.botapi.BotApiClient;
import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.method.GetMe;
import org.rp.telegram.botapi.type.User;
import org.rp.telegram.botapi.util.Const;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 20.03.20
 * Time: 19:55
 */
public class TgBotApi implements BotApiClient {

    @Override
    public String getApiVersion() {
        return Const.API_VERSION;
    }

    @Override
    public User getMe(String token) throws BotApiException {
        return new GetMe
                .Builder()
                .token(token)
                .build()
                .doRequest()
                .getResult();
    }

}

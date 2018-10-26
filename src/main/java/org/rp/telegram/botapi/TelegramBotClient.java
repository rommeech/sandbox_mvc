package org.rp.telegram.botapi;

import org.rp.telegram.botapi.request.GetMeRequest;

public class TelegramBotClient {

    public TelegramBotClient() {
    }

    public GetMeRequest getMe() {
        return new GetMeRequest();
    }
}

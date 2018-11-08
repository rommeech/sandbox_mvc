package org.rp.testapp;

// TODO: Add "sdk" to package

public class GetMeTestApp {

    public static void main(String[] args) {

        String token = args[0];

        /*TelegramBotClient tgClient = new TelegramBotClient();
        User user = tgClient.getMe().token(token).doRequest();*/

        /*

        TelegramBotClient tgClient = new TelegramBotClient();
        GetMeRequest request = new GetMeClient().Builder.build;
        User user = tgClient.doRequest(request);

        vs

        TelegramBotClient tgClient = new TelegramBotClient();
        User user = tgClient.getMe().token(token).doRequest();
        getMe return GetMeClient (contains getMeRequest and doRequest function)

        */

    }

}

package org.rp.telegram.botapi.http.impl;

import okhttp3.Request;
import okhttp3.Response;
import org.rp.telegram.botapi.http.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 20.03.20
 * Time: 20:38
 */
public class OkHttpClient implements HttpClient {

    private static final okhttp3.OkHttpClient okClient = new okhttp3.OkHttpClient();
    private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpClient.class);

    @Override
    public String queryStringGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        LOGGER.info("Request: GET " + url);

        try (Response response = okClient.newCall(request).execute()) {
            String responseBody = response.body().string();

            LOGGER.info("Response: " + response.code() + " " + response.message() + " " + responseBody);

            return responseBody;
        }
    }
}

package org.rp.telegram.botapi.http.impl;

import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.telegram.botapi.http.HttpClient;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 20.03.20
 * Time: 20:38
 */

// TODO: unittests
// TODO: documentation

public class OkHttpClient implements HttpClient {

    private static final okhttp3.OkHttpClient okClient = new okhttp3.OkHttpClient();
    private static final Logger LOGGER = LogManager.getLogger(OkHttpClient.class);
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public String queryStringRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        LOGGER.info("queryStringRequest: " + url);
        try (Response response = okClient.newCall(request).execute()) {
            String responseBody = response.body().string();
            LOGGER.info("queryStringResponse: " + response.code() + " " + response.message() + " " + responseBody);
            return responseBody;
        }
    }

    @Override
    public String applicationXFormRequest(String url, Object object) throws IOException {
        return null;
    }

    @Override
    public String applicationJsonRequest(String url, String jsonString) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE_JSON, jsonString))
                .build();
        LOGGER.info("applicationJsonRequest: " + url + " " + jsonString);
        try (Response response = okClient.newCall(request).execute()) {
            String responseBody = response.body().string();
            LOGGER.info("applicationJsonResponse: " + response.code() + " " + response.message() + " " + responseBody);
            return responseBody;
        }
    }

    @Override
    public String multipartFormDataRequest(String url, Map<String, Object> formData, String fileParameterName, File file) throws IOException {

        /* MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(fileParameterName, file.getName(), RequestBody.create(file) file);
        for (Map.Entry<String, Object> entry : formData.entrySet()) {
            builder.addFormDataPart(entry.getKey(), entry.getValue().toString());
        }*/

        return null;

    }
}

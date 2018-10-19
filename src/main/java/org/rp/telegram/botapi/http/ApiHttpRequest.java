package org.rp.telegram.botapi.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.rp.telegram.botapi.entity.AbstractEntity;
import org.rp.telegram.botapi.request.AbstractApiRequest;

import java.io.IOException;

/*
There are four ways of passing parameters in Bot API requests, but we support only thee at the moment:
 - URL query string - when httpMethod=GET
 - application/x-www-form-urlencoded - does not support at the moment, extra parameter will be used in future
 - application/json (except for uploading files) - default, when httpMethod=POST
 - multipart/form-data (use to upload files) - for some requests httpMethod will be set automatically to POST
 */

public class ApiHttpRequest {

    private static final String API_URL = "https://api.telegram.org/";
    private static OkHttpClient client;
    private static ObjectMapper mapper;

    // TODO: do we really need this?
    static {
        client = new OkHttpClient();
        mapper = new ObjectMapper();
    }

    private String url;
    private String token;
    private HttpMethod httpMethod;
    private AbstractApiRequest request;
    private Class<? extends AbstractEntity> responseClass;

    private ApiHttpRequest(Builder builder) {
        this.url = builder.url;
        this.token = builder.token;
        this.httpMethod = builder.httpMethod;
        this.request = builder.request;
        this.responseClass = builder.responseClass;
    }

    /* public static void sendGetRequest(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        System.out.println("[RESPONSE]");
        System.out.println(response.code() + " " + response.message());
        System.out.println(response.headers());
        System.out.println(response.body().string());
    }
    */

    public void doRequest() throws HttpException, IOException {
        checkRequestParameters();
        if (httpMethod == HttpMethod.GET) {
            doGetRequest();
        }
        // TODO: for some API methods should perform multipart/form-data POST request
        // TODO: on demand should be possible to perform application/x-www-form-urlencoded request
        else {
            doJsonRequest();
        }
    }

    private void doGetRequest() throws IOException {
        String url = buildRequestUrl();
        Request request = new Request.Builder().url(url).build();
        Response response  = client.newCall(request).execute();
        String jsonResponse = response.body().string();

        System.out.println("[RESPONSE]");
        System.out.println(response.code() + " " + response.message());
        System.out.println(response.headers());
        System.out.println(jsonResponse);

        ApiHttpResponse apiHttpResponse = mapper.readValue(jsonResponse, ApiHttpResponse.class);
        System.out.println(apiHttpResponse);

    }

    private String buildRequestUrl() {
        return String.format("%sbot%s/%s", this.url, this.token, this.request.getApiMethodName());
    }

    // private void doPostRequest() {}
    // private void doMultipartPostRequest() {}

    private void doJsonRequest() {

    }



    private void checkRequestParameters() throws HttpException {
        if (this.url == null) {
            throw new HttpException("ApiHttpRequestException: URL cannot be null");
        }
        if (httpMethod == null) {
            throw new HttpException("ApiHttpRequestException: HTTP method cannot be null");
        }
        if (token == null) {
            throw new HttpException("ApiHttpRequestException: token method cannot be null");
        }
        if (request == null) {
            throw new HttpException("ApiHttpRequestException: Request object method cannot be null");
        }
    }

    public static class Builder {
        private String url;
        private String token;
        private HttpMethod httpMethod;
        private AbstractApiRequest request;
        private Class<? extends AbstractEntity> responseClass;

        public Builder() {
            url = API_URL;
            httpMethod = HttpMethod.POST;
        }

        public Builder(ApiHttpRequest httpApiRequest) {
            this.url = httpApiRequest.url;
            this.token = httpApiRequest.token;
            this.httpMethod = httpApiRequest.httpMethod;
            this.request = httpApiRequest.request;
            this.responseClass = httpApiRequest.responseClass;
        }

        public ApiHttpRequest.Builder url(String url) {
            this.url = url;
            return this;
        }

        public ApiHttpRequest.Builder token(String token) {
            this.token = token;
            return this;
        }

        public ApiHttpRequest.Builder httpMethod(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public ApiHttpRequest.Builder request(AbstractApiRequest request) {
            this.request = request;
            return this;
        }

        public ApiHttpRequest.Builder responseClass(Class<? extends AbstractEntity> responseClass) {
            this.responseClass = responseClass;
            return this;
        }

        public ApiHttpRequest build() {
            return new ApiHttpRequest(this);
        }

    }

}

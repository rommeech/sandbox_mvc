package org.rp.telegram.botapi.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.rp.telegram.botapi.request.AbstractApiRequest;
import org.rp.telegram.botapi.response.AbstractApiResponse;

import java.io.IOException;

/*
There are four ways of passing parameters in Bot API requests, but we support only thee at the moment:
 - URL query string - when httpMethod=GET
 - application/x-www-form-urlencoded - does not support at the moment, extra parameter will be used in future
 - application/json (except for uploading files) - default, when httpMethod=POST
 - multipart/form-data (use to upload files) - for some requests httpMethod will be set automatically to POST
 */

public class HttpClient {

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
    private Class<? extends AbstractApiResponse> responseClass;

    private HttpClient(Builder builder) {
        this.url = builder.url;
        this.token = builder.token;
        this.httpMethod = builder.httpMethod;
        this.request = builder.request;
        this.responseClass = builder.responseClass;
    }

    /* public static void sendGetRequest(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = http.newCall(request).execute();
        System.out.println("[RESPONSE]");
        System.out.println(response.code() + " " + response.message());
        System.out.println(response.headers());
        System.out.println(response.body().string());
    }
    */

    public AbstractApiResponse doRequest() throws HttpException, IOException {
        checkRequestParameters();

        if (httpMethod == HttpMethod.GET) {
            return doGetRequest();
        }
        // TODO: for some API methods should perform multipart/form-data POST request
        // TODO: on demand should be possible to perform application/x-www-form-urlencoded request
        else {
            return doJsonRequest();
        }
    }

    private AbstractApiResponse doGetRequest() throws IOException {
        String url = buildRequestUrl();
        Request request = new Request.Builder().url(url).build();
        Response response  = client.newCall(request).execute();
        String jsonResponse = response.body().string();

        System.out.println("[RESPONSE]");
        System.out.println(response.code() + " " + response.message());
        System.out.println(response.headers());
        System.out.println(jsonResponse);

        AbstractApiResponse apiResponse = mapper.readValue(jsonResponse, responseClass);
        System.out.println(apiResponse);

        return apiResponse;
    }

    private String buildRequestUrl() {
        return String.format("%sbot%s/%s", this.url, this.token, this.request.getApiMethodName());
    }

    // private void doPostRequest() {}
    // private void doMultipartPostRequest() {}

    private AbstractApiResponse doJsonRequest() {
        return null;
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
        if (responseClass == null) {
            throw new HttpException("ApiHttpRequestException: Response class d cannot be null");
        }
    }

    public static class Builder {
        private String url;
        private String token;
        private HttpMethod httpMethod;
        private AbstractApiRequest request;
        private Class<? extends AbstractApiResponse> responseClass;

        public Builder() {
            url = API_URL;
            httpMethod = HttpMethod.POST;
        }

        public Builder(HttpClient httpApiRequest) {
            this.url = httpApiRequest.url;
            this.token = httpApiRequest.token;
            this.httpMethod = httpApiRequest.httpMethod;
            this.request = httpApiRequest.request;
            this.responseClass = httpApiRequest.responseClass;
        }

        public HttpClient.Builder url(String url) {
            this.url = url;
            return this;
        }

        public HttpClient.Builder token(String token) {
            this.token = token;
            return this;
        }

        public HttpClient.Builder httpMethod(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public HttpClient.Builder request(AbstractApiRequest request) {
            this.request = request;
            return this;
        }

        public HttpClient.Builder responseClass(Class<? extends AbstractApiResponse> responseClass) {
            this.responseClass = responseClass;
            return this;
        }

        public HttpClient build() {
            return new HttpClient(this);
        }

    }

}

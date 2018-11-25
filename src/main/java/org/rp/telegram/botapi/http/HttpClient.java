package org.rp.telegram.botapi.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.telegram.botapi.helper.ApiMethod;
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

    private static final Logger logger = LogManager.getLogger(HttpClient.class);

    private static final String API_URL = "https://api.telegram.org/";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient httpClient;
    private static ObjectMapper jsonMapper;

    // TODO: do we really need this in static?
    static {
        logger.info("Init static objects");
        httpClient = new OkHttpClient();
        jsonMapper = new ObjectMapper();
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private String url;
    private String token;
    private HttpMethod httpMethod;
    private ApiMethod apiMethod;
    private AbstractApiRequest request;
    private Class<? extends AbstractApiResponse> responseClass;

    private Request httpRequest;
    private Response httpResponse;
    private Double httpRequestDuration;

    private HttpClient(Builder builder) {
        this.url = builder.url;
        this.token = builder.token;
        this.httpMethod = builder.httpMethod;
        this.request = builder.request;
        this.responseClass = builder.responseClass;
        this.apiMethod = builder.apiMethod;
    }

    public AbstractApiResponse doRequest() throws HttpException {
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

    // TODO: add parameters
    private AbstractApiResponse doGetRequest() throws HttpException {
        String url = buildRequestUrl();
        logger.info("DoGetRequest: GET " + url);
        Request request = new Request.Builder().url(url).build();
        Response response = sendHttpRequest(request);
        AbstractApiResponse apiResponse = parseResponse(response);
        logApiResponse("DoGetResponse", apiResponse);
        return apiResponse;
    }

    // private void doPostRequest() {}
    // private void doMultipartPostRequest() {}

    private AbstractApiResponse doJsonRequest() throws HttpException {

        String url = buildRequestUrl();
        String json;
        try {
            json = jsonMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new HttpException(e);
        }

        logger.info("DoJsonRequest: POST " + url + " " + json);

        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = sendHttpRequest(request);
        AbstractApiResponse apiResponse = parseResponse(response);

        logApiResponse("DoJsonResponse", apiResponse);

        return apiResponse;
    }

    private void logApiResponse(String caller, AbstractApiResponse apiResponse) {
        String output = String.format(
                "%s: %s %s %s",
                caller,
                apiResponse.getHttpCode(),
                apiResponse.getHttpMessage(),
                apiResponse.getHttpContent()
        );
        if (apiResponse.getOk()) {
            logger.info(output);
        }
        else {
            logger.error(output);
        }
    }

    private AbstractApiResponse parseResponse(Response response) throws HttpException {
        String responseBody = getResponseBody(response);
        AbstractApiResponse apiResponse = parseResponseText(responseBody);
        apiResponse.setHttpCode(response.code());
        apiResponse.setHttpMessage(response.message());
        apiResponse.setHttpContent(responseBody);
        return apiResponse;
    }

    private String getResponseBody(Response response) throws HttpException {
        try {
            return response.body().string();
        } catch (IOException e) {
            throw new HttpException(e);
        }
    }

    private Response sendHttpRequest(Request request) throws HttpException {
        Response response;
        long startTime = System.currentTimeMillis();
        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            logger.error("doGetRequest error: " + e);
            throw new HttpException(e);
        }
        this.httpRequestDuration = (System.currentTimeMillis() - startTime) / 1000D;
        this.httpRequest = request;
        this.httpResponse = response;
        return response;
    }

    private AbstractApiResponse parseResponseText(String jsonText) throws HttpException {
        AbstractApiResponse apiResponse;
        try {
            apiResponse = jsonMapper.readValue(jsonText, responseClass);
        } catch (IOException e) {
            logger.error("parseResponseText error: " + e);
            throw new HttpException(e);
        }

        logger.info("Response object: " + apiResponse);

        return apiResponse;
    }

    private String buildRequestUrl() {
        return String.format("%sbot%s/%s", this.url, this.token, this.apiMethod.getMethodName());
    }

    private void checkRequestParameters() throws HttpException {
        if (this.url == null) {
            throw new HttpException("Wrong parameter: URL cannot be null");
        }
        if (httpMethod == null) {
            throw new HttpException("Wrong parameter: HTTP method cannot be null");
        }
        if (token == null) {
            throw new HttpException("Wrong parameter: token method cannot be null");
        }
        if (request == null) {
            throw new HttpException("Wrong parameter: Request object method cannot be null");
        }
        if (responseClass == null) {
            throw new HttpException("Wrong parameter: Response class cannot be null");
        }
        if (apiMethod == null) {
            throw new HttpException("Wrong parameter: API method cannot be null");
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public ApiMethod getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(ApiMethod apiMethod) {
        this.apiMethod = apiMethod;
    }

    public AbstractApiRequest getRequest() {
        return request;
    }

    public void setRequest(AbstractApiRequest request) {
        this.request = request;
    }

    public Class<? extends AbstractApiResponse> getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class<? extends AbstractApiResponse> responseClass) {
        this.responseClass = responseClass;
    }

    public Request getHttpRequest() {
        return httpRequest;
    }

    public Response getHttpResponse() {
        return httpResponse;
    }

    public Double getHttpRequestDuration() {
        return httpRequestDuration;
    }

    public static class Builder {
        private String url;
        private String token;
        private HttpMethod httpMethod;
        private AbstractApiRequest request;
        private ApiMethod apiMethod;
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
            this.apiMethod = httpApiRequest.apiMethod;
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

        public HttpClient.Builder apiMethod(ApiMethod apiMethod) {
            this.apiMethod = apiMethod;
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

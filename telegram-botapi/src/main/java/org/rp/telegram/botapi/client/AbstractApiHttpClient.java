package org.rp.telegram.botapi.client;

import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.http.HttpClient;
import org.rp.telegram.botapi.http.impl.OkHttpClient;
import org.rp.telegram.botapi.json.JsonMapper;
import org.rp.telegram.botapi.json.impl.JacksonJsonMapper;

import static org.rp.telegram.botapi.util.Const.API_URL;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 20.03.20
 * Time: 20:34
 */

/**
 * Abstract Telegram Bot API HTTP Client
 */
public abstract class AbstractApiHttpClient {

    private static HttpClient httpClient;
    private static JsonMapper jsonMapper;
    private static String apiUrl = API_URL;
    private static String token;

    /**
     * Returns HTTP client. When no client injected - returns default okhttp3 implementation
     *
     * @return   HttpClient instance
     */
    public HttpClient httpClientInstance() {
        if (httpClient == null) {
            httpClient = defaultHttpClient();
        }
        return httpClient;
    }

    /**
     * Returns JSON serialization/deserialization mapper. When no mapper injected - returns
     * default Jackson implementation
     *
     * @return   JSON mapper instance
     */
    public JsonMapper jsonMapperInstance() {
        if (jsonMapper == null) {
            jsonMapper = defaultJsonMapper();
        }
        return jsonMapper;
    }

    /**
     * Inject HttpClient object.
     *
     * @param   httpClient   HttpClient implementation
     */
    void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Inject JsonMapper object.
     *
     * @param   jsonMapper   JsonMapper implementation
     */
    void setJsonMapper(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    /**
     * Can configure Telegram API endpoint.
     *
     * @param   url   Base API URL
     */
    void setApiUrl(String url) {
        this.apiUrl = url;
    }

    /**
     * Sets bot's unique authentication token.
     *
     * @param   token   Authentication token
     */
    void setToken(String token) {
        this.token = token;
    }

    /**
     * Build URL of API's method
     *
     * @param    method   Bot API's method
     * @return            URL
     * @throws   BotApiException
     */
    protected String buildApiUrl(String method) throws BotApiException {
        if (token == null) {
            throw new BotApiException("No token configured!");
        }
        return buildApiUrl(token, method);
    }

    /**
     * Build URL of API's method
     *
     * @param    token    Authentication token
     * @param    method   Bot API's method
     * @return
     */
    protected String buildApiUrl(String token, String method) {
        return apiUrl.replaceAll("/+$", "") + "/bot" + token + "/" + method;
    }

    /**
     * Returns default Jackson implementation instance
     *
     * @return   JsonMapper instance
     */
    private JsonMapper defaultJsonMapper() {
        return new JacksonJsonMapper();
    }

    /**
     * Returns default okhttp3 implementation instance
     *
     * @return   HttpClient instance
     */
    private HttpClient defaultHttpClient() {
        return new OkHttpClient();
    }

    /**
     * Abstract Builder for AbstractApiHttpClient implementation
     *
     * @param   <T>   AbstractApiHttpClient
     * @param   <B>   AbstractClientBuilder
     */
    protected static abstract class AbstractClientBuilder<T extends AbstractApiHttpClient, B extends AbstractClientBuilder> {

        protected T apiMethod;
        protected B apiMethodBuilder;
        protected abstract T getApiMethod();
        protected abstract B getApiMethodBuilder();

        protected AbstractClientBuilder() {
            apiMethod = getApiMethod();
            apiMethodBuilder = getApiMethodBuilder();
        }

        public B httpClient(HttpClient httpClient) {
            apiMethod.setHttpClient(httpClient);
            return apiMethodBuilder;
        }

        public B jsonMapper(JsonMapper jsonMapper) {
            apiMethod.setJsonMapper(jsonMapper);
            return apiMethodBuilder;
        }

        public B apiUrl(String url) {
            apiMethod.setApiUrl(url);
            return apiMethodBuilder;
        }

        public B token(String token) {
            apiMethod.setToken(token);
            return apiMethodBuilder;
        }

        public T build() {
            return apiMethod;
        }
    }

}

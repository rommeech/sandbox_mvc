package org.rp.sandboxmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "RequestLog")
@Table(name = "request_log")
public class RequestLog extends AbstractModel<Long> {
    private static final long serialVersionUID = 4355766629611168233L;

    /*@ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;*/

    @Column(name = "api_method")
    private String apiMethod;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "request_url")
    private String requestUrl;

    @Column(name = "request_content_type")
    private String requestContentType;

    @Column(name = "request_body")
    private String requestBody;

    @Column(name = "duration")
    private Double duration;

    @Column(name = "response_http_code")
    private int responseHttpCode;

    @Column(name = "response_http_message")
    private String responseHttpMessage;

    @Column(name = "response_body")
    private String responseBody;

    public RequestLog() {
    }

    public RequestLog(Builder builder) {
        //this.publication = builder.publication;
        this.apiMethod = builder.apiMethod;
        this.requestMethod = builder.requestMethod;
        this.requestUrl = builder.requestUrl;
        this.requestContentType = builder.requestContentType;
        this.requestBody = builder.requestBody;
        this.duration = builder.duration;
        this.responseHttpCode = builder.responseHttpCode;
        this.responseHttpMessage = builder.responseHttpMessage;
        this.responseBody = builder.responseBody;
    }

    /*public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
    */

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestContentType() {
        return requestContentType;
    }

    public void setRequestContentType(String requestContentType) {
        this.requestContentType = requestContentType;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public int getResponseHttpCode() {
        return responseHttpCode;
    }

    public void setResponseHttpCode(int responseHttpCode) {
        this.responseHttpCode = responseHttpCode;
    }

    public String getResponseHttpMessage() {
        return responseHttpMessage;
    }

    public void setResponseHttpMessage(String responseHttpMessage) {
        this.responseHttpMessage = responseHttpMessage;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestLog)) return false;
        if (!super.equals(o)) return false;
        RequestLog that = (RequestLog) o;
        return responseHttpCode == that.responseHttpCode &&
                //Objects.equals(publication, that.publication) &&
                Objects.equals(apiMethod, that.apiMethod) &&
                Objects.equals(requestMethod, that.requestMethod) &&
                Objects.equals(requestUrl, that.requestUrl) &&
                Objects.equals(requestContentType, that.requestContentType) &&
                Objects.equals(requestBody, that.requestBody) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(responseHttpMessage, that.responseHttpMessage) &&
                Objects.equals(responseBody, that.responseBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), apiMethod, requestMethod, requestUrl, requestContentType,
                requestBody, duration, responseHttpCode, responseHttpMessage, responseBody);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RequestLog{");
        //sb.append("publication=").append(publication);
        sb.append("apiMethod='").append(apiMethod).append('\'');
        sb.append(", requestMethod='").append(requestMethod).append('\'');
        sb.append(", requestUrl='").append(requestUrl).append('\'');
        sb.append(", requestContentType='").append(requestContentType).append('\'');
        sb.append(", requestBody='").append(requestBody).append('\'');
        sb.append(", duration=").append(duration);
        sb.append(", responseHttpCode=").append(responseHttpCode);
        sb.append(", responseHttpMessage='").append(responseHttpMessage).append('\'');
        sb.append(", responseBody='").append(responseBody).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        //private Publication publication;
        private String apiMethod;
        private String requestMethod;
        private String requestUrl;
        private String requestContentType;
        private String requestBody;
        private Double duration;
        private int responseHttpCode;
        private String responseHttpMessage;
        private String responseBody;

        public Builder() {

        }

        /*public RequestLog.Builder publication(Publication publication) {
            this.publication = publication;
            return this;
        }*/

        public RequestLog.Builder apiMethod(String apiMethod) {
            this.apiMethod = apiMethod;
            return this;
        }

        public RequestLog.Builder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        public RequestLog.Builder requestUrl(String requestUrl) {
            this.requestUrl = requestUrl;
            return this;
        }

        public RequestLog.Builder requestContentType(String requestContentType) {
            this.requestContentType = requestContentType;
            return this;
        }

        public RequestLog.Builder requestBody(String requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public RequestLog.Builder duration(Double duration) {
            this.duration = duration;
            return this;
        }

        public RequestLog.Builder responseHttpCode(int responseHttpCode) {
            this.responseHttpCode = responseHttpCode;
            return this;
        }

        public RequestLog.Builder responseHttpMessage(String responseHttpMessage) {
            this.responseHttpMessage = responseHttpMessage;
            return this;
        }

        public RequestLog.Builder responseBody(String responseBody) {
            this.responseBody = responseBody;
            return this;
        }

        public RequestLog build() {
            return new RequestLog(this);
        }

    }
}

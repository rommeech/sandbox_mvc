package org.rp.sandboxmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "RequestLog")
@Table(name = "request_log")
public class RequestLog extends AbstractModel<Long> {
    private static final long serialVersionUID = 4355766629611168233L;

    @ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;

    @NotNull
    @Column(name = "service_provider")
    private String serviceProvider;

    @NotNull
    @Column(name = "service_type")
    private String serviceType;

    @NotNull
    @Column(name = "request_method")
    private String requestMethod;

    @NotNull
    @Column(name = "request_url")
    private String requestUrl;

    @NotNull
    @Column(name = "request_content_type")
    private String requestContentType;

    @NotNull
    @Column(name = "request_body")
    private String requestBody;

    @Column(name = "duration")
    private Float duration;

    @Column(name = "response_http_code")
    private int responseHttpCode;

    @Column(name = "response_http_message")
    private String responseHttpMessage;

    @Column(name = "response_body")
    private String responseBody;

    public RequestLog() {
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
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
                Objects.equals(publication, that.publication) &&
                Objects.equals(serviceProvider, that.serviceProvider) &&
                Objects.equals(serviceType, that.serviceType) &&
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
        return Objects.hash(super.hashCode(), publication, serviceProvider, serviceType, requestMethod, requestUrl,
                requestContentType, requestBody, duration, responseHttpCode, responseHttpMessage, responseBody);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RequestLog{");
        sb.append("publication=").append(publication);
        sb.append(", serviceProvider='").append(serviceProvider).append('\'');
        sb.append(", serviceType='").append(serviceType).append('\'');
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
}

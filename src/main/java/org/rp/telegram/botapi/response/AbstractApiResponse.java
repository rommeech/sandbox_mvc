package org.rp.telegram.botapi.response;

import org.rp.telegram.botapi.entity.AbstractEntity;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractApiResponse<T extends AbstractEntity> implements Serializable {
    private static final long serialVersionUID = -5416870816262578210L;

    private Boolean ok;
    private String description;
    private T result;
    private Integer errorCode;
    private Map<String, Object> parameters;
    private int httpCode;
    private String httpMessage;
    private String httpContent;

    public AbstractApiResponse() {
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMessage() {
        return httpMessage;
    }

    public void setHttpMessage(String httpMessage) {
        this.httpMessage = httpMessage;
    }

    public String getHttpContent() {
        return httpContent;
    }

    public void setHttpContent(String httpContent) {
        this.httpContent = httpContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractApiResponse)) return false;
        AbstractApiResponse that = (AbstractApiResponse) o;
        return httpCode == that.httpCode &&
                Objects.equals(ok, that.ok) &&
                Objects.equals(description, that.description) &&
                Objects.equals(result, that.result) &&
                Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(parameters, that.parameters) &&
                Objects.equals(httpMessage, that.httpMessage) &&
                Objects.equals(httpContent, that.httpContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ok, description, result, errorCode, parameters, httpCode, httpMessage, httpContent);
    }

    @Override
    public String toString() {
        return "AbstractApiResponse{" +
                "ok=" + ok +
                ", description='" + description + '\'' +
                ", result=" + result +
                ", errorCode=" + errorCode +
                ", parameters=" + parameters +
                ", httpCode=" + httpCode +
                ", httpMessage='" + httpMessage + '\'' +
                ", httpContent='" + httpContent + '\'' +
                '}';
    }
}

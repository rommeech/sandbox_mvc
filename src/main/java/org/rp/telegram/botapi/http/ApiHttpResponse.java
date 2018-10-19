package org.rp.telegram.botapi.http;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class ApiHttpResponse implements Serializable {
    private static final long serialVersionUID = -5416870816262578210L;

    private Boolean ok;
    private String description;
    private Map<String, Object> result;
    private Integer errorCode;
    private Map<String, Object> parameters;

    public ApiHttpResponse() {
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

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiHttpResponse)) return false;
        ApiHttpResponse that = (ApiHttpResponse) o;
        return Objects.equals(ok, that.ok) &&
                Objects.equals(description, that.description) &&
                Objects.equals(result, that.result) &&
                Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ok, description, result, errorCode, parameters);
    }

    @Override
    public String toString() {
        return "ApiHttpResponse{" +
                "ok=" + ok +
                ", description='" + description + '\'' +
                ", result=" + result +
                ", errorCode=" + errorCode +
                ", parameters=" + parameters +
                '}';
    }
}

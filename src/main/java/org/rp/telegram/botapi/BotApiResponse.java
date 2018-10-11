package org.rp.telegram.botapi;

import org.rp.telegram.botapi.entity.ResponseParameters;

import java.io.Serializable;
import java.util.Objects;

public class BotApiResponse implements Serializable {
    private static final long serialVersionUID = 6914036374719917628L;

    private boolean ok;
    private String description;
    private String result;
    private Integer errorCode;
    private ResponseParameters responseParameters;
    private int httpCode;
    private String httpMessage;
    private String httpContent;

    public BotApiResponse() {
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseParameters getResponseParameters() {
        return responseParameters;
    }

    public void setResponseParameters(ResponseParameters responseParameters) {
        this.responseParameters = responseParameters;
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
        if (!(o instanceof BotApiResponse)) return false;
        BotApiResponse that = (BotApiResponse) o;
        return ok == that.ok &&
                httpCode == that.httpCode &&
                Objects.equals(description, that.description) &&
                Objects.equals(result, that.result) &&
                Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(responseParameters, that.responseParameters) &&
                Objects.equals(httpMessage, that.httpMessage) &&
                Objects.equals(httpContent, that.httpContent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ok, description, result, errorCode, responseParameters, httpCode, httpMessage, httpContent);
    }

    @Override
    public String toString() {
        return "BotApiResponse{" +
                "ok=" + ok +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                ", errorCode=" + errorCode +
                ", responseParameters=" + responseParameters +
                ", httpCode=" + httpCode +
                ", httpMessage='" + httpMessage + '\'' +
                ", httpContent='" + httpContent + '\'' +
                '}';
    }
}

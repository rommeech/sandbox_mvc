package org.rp.telegram.botapi.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rp.telegram.botapi.type.ResponseParameters;
import org.rp.telegram.botapi.BotApiResultType;

import java.io.Serializable;
import java.util.Objects;

/**
 * If ‘ok’ equals true, the request was successful and the result of the query can be found in the ‘result’ field.
 * In case of an unsuccessful request, ‘ok’ equals false and the error is explained in the ‘description’.
 * An Integer ‘error_code’ field is also returned, but its contents are subject to change in the future.
 * Some errors may also have an optional field ‘parameters’ of the type ResponseParameters, which can help
 * to automatically handle the error.
 * All methods in the Bot API are case-insensitive.
 * All queries must be made using UTF-8.
 *
 * See also: https://core.telegram.org/bots/api#making-requests
 *
 * @author     rp
 * @version    4.6
 */

public final class ResponseModel<T extends BotApiResultType> implements Serializable {

    private static final long serialVersionUID = 5104711082282809692L;

    private Boolean ok;
    private String description;
    private T result;
    private Integer errorCode;
    private ResponseParameters parameters;

    /**
     * Default constructor.
     */
    public ResponseModel() {
    }

    /**
     * Returns true in case of successful request.
     *
     * @return   request result
     */
    @JsonProperty(value = "ok")
    public Boolean getOk() {
        return ok;
    }

    /**
     * An optional String field ‘description’ with a human-readable description of the result.
     *
     * @return   description of the result
     */
    @JsonProperty(value = "description")
    public String getDescription() {
        return description;
    }

    /**
     * Result of the query in case of successful request.
     *
     * @return   result object
     */
    @JsonProperty(value = "result")
    public T getResult() {
        return result;
    }

    /**
     * Error code in case of unsuccessful request.
     *
     * @return   code value
     */
    @JsonProperty(value = "error_code")
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * Additional parameters in case of some unsuccessful requests.
     *
     * @return   response parameters
     */
    @JsonProperty(value = "parameters")
    public ResponseParameters getParameters() {
        return parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseModel that = (ResponseModel) o;
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
        return "ResponseModel{" +
                "ok=" + ok +
                ", description='" + description + '\'' +
                ", result=" + result +
                ", errorCode=" + errorCode +
                ", parameters=" + parameters +
                '}';
    }
}

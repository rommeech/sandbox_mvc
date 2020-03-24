package org.rp.telegram.botapi.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.rp.telegram.botapi.BotApiResultType;

import java.util.Objects;

/**
 * Contains information about why a request was unsuccessful.
 *
 * See also: https://core.telegram.org/bots/api#responseparameters
 *
 * @author     rp
 * @version    4.6
 */
public class ResponseParameters implements BotApiResultType {

    private static final long serialVersionUID = 4377713734236387423L;
    private Long migrateToCharId;
    private Long retryAfter;

    /**
     * Default constructor
     */
    public ResponseParameters() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Optional. The group has been migrated to a supergroup with the specified identifier.
     *
     * @return   supergroup identifier
     */
    public Long getMigrateToCharId() {
        return migrateToCharId;
    }

    /**
     * @param   migrateToCharId   supergroup identifier
     */
    @JsonProperty(value = "migrate_to_chat_id")
    public void setMigrateToCharId(Long migrateToCharId) {
        this.migrateToCharId = migrateToCharId;
    }

    /**
     * Optional. In case of exceeding flood control, the number of seconds left to wait before
     * the request can be repeated.
     *
     * @return   number of seconds
     */
    public Long getRetryAfter() {
        return retryAfter;
    }

    /**
     * @param   retryAfter   number of seconds
     */
    @JsonProperty(value = "retry_after")
    public void setRetryAfter(Long retryAfter) {
        this.retryAfter = retryAfter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseParameters)) return false;
        ResponseParameters that = (ResponseParameters) o;
        return Objects.equals(migrateToCharId, that.migrateToCharId) &&
                Objects.equals(retryAfter, that.retryAfter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(migrateToCharId, retryAfter);
    }

    @Override
    public String toString() {
        return "ResponseParameters{" +
                "migrateToCharId=" + migrateToCharId +
                ", retryAfter=" + retryAfter +
                '}';
    }
}

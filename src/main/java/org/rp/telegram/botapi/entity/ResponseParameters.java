package org.rp.telegram.botapi.entity;

import java.io.Serializable;
import java.util.Objects;

public class ResponseParameters implements Serializable {
    private static final long serialVersionUID = 4377713734236387423L;

    private Long migrateToCharId;
    private Integer retryAfter;

    public ResponseParameters() {
    }

    public Long getMigrateToCharId() {
        return migrateToCharId;
    }

    public void setMigrateToCharId(Long migrateToCharId) {
        this.migrateToCharId = migrateToCharId;
    }

    public Integer getRetryAfter() {
        return retryAfter;
    }

    public void setRetryAfter(Integer retryAfter) {
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

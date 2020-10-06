package org.rp.telegram.botapi.util;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 24.03.20
 * Time: 13:04
 */

// TODO: javadoc

public enum ChatType {

    @JsonProperty("private")
    PRIVATE,

    @JsonProperty("group")
    GROUP,

    @JsonProperty("supergroup")
    SUPERGROUP,

    @JsonProperty("channel")
    CHANNEL;

}

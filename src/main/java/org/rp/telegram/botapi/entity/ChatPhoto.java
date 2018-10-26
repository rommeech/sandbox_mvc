package org.rp.telegram.botapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * This object represents a chat photo.
 * https://core.telegram.org/bots/api#chatphoto
 *
 * @author        Roman Parshin, roman.dev@gmail.com
 * @version       1.0
 * @since         1.0
 * @apiVersion    4.1
 */

public class ChatPhoto extends AbstractEntity {
    private static final long serialVersionUID = -8930014189201515968L;

    @JsonProperty(value = "small_file_id")
    private String smallFileId;

    @JsonProperty(value = "big_file_id")
    private String bigFileId;

    /**
     * This object represents a chat photo.
     */
    public ChatPhoto() {
    }

    /**
     * Unique file identifier of small (160x160) chat photo. This file_id can be used only for photo download.
     * @return    small photo file identifier
     */
    public String getSmallFileId() {
        return smallFileId;
    }

    /**
     * Unique file identifier of small (160x160) chat photo. This file_id can be used only for photo download.
     * @param    smallFileId    small photo file identifier
     */
    public void setSmallFileId(String smallFileId) {
        this.smallFileId = smallFileId;
    }

    /**
     * Unique file identifier of big (640x640) chat photo. This file_id can be used only for photo download.
     * @return    big photo file identifier
     */
    public String getBigFileId() {
        return bigFileId;
    }

    /**
     * Unique file identifier of big (640x640) chat photo. This file_id can be used only for photo download.
     * @param    bigFileId    big photo file identifier
     */
    public void setBigFileId(String bigFileId) {
        this.bigFileId = bigFileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatPhoto)) return false;
        ChatPhoto chatPhoto = (ChatPhoto) o;
        return Objects.equals(smallFileId, chatPhoto.smallFileId) &&
                Objects.equals(bigFileId, chatPhoto.bigFileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smallFileId, bigFileId);
    }

    // TODO: refactor all toString methods using StringBuilder

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChatPhoto{");
        sb.append("smallFileId='").append(smallFileId).append('\'');
        sb.append(", bigFileId='").append(bigFileId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

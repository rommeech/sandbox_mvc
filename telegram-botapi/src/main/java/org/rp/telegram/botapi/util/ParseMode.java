package org.rp.telegram.botapi.util;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 26.03.20
 * Time: 15:54
 */
public enum ParseMode {

    MARKDOWN("Markdown"),
    MARKDOWNV2("MarkdownV2"),
    HTML("HTML");

    private String value;

    ParseMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParseMode{" +
                "value='" + value + '\'' +
                '}';
    }
}

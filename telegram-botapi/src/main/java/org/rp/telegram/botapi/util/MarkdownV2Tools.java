package org.rp.telegram.botapi.util;

import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 30.04.20
 * Time: 13:49
 */
public class MarkdownV2Tools {

    private static final Pattern REGEX_LINEBREAK = Pattern.compile("<\\s*br\\s*/?\\s*>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_PARAGRAPH_START = Pattern.compile("<\\s*p\\b.*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_BOLD_START = Pattern.compile("<\\s*(?:b|strong)\\b.*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_BOLD_END = Pattern.compile("<\\s*/\\s*(?:b|strong)\\s*>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_ITALIC_START = Pattern.compile("<\\s*(?:i|em)\\b.*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_ITALIC_END = Pattern.compile("<\\s*/\\s*(?:i|em)\\s*>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_UNDERLINE_START = Pattern.compile("<\\s*(?:u|ins)\\b.*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_UNDERLINE_END = Pattern.compile("<\\s*/\\s*(?:u|ins)\\s*>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_STRIKE_START = Pattern.compile("<\\s*(?:s|strike|del)\\b.*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_STRIKE_END = Pattern.compile("<\\s*/\\s*(?:s|strike|del)\\s*>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_CODE_START = Pattern.compile("<\\s*code\\b.*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_CODE_END = Pattern.compile("<\\s*/\\s*code\\s*>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_PRE_START = Pattern.compile("<\\s*pre\\b.*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_PRE_END = Pattern.compile("<\\s*/\\s*pre\\s*>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_LINK = Pattern.compile("<\\s*a.*?href=['\"](.*?)['\"]>(.*?)<\\s*/\\s*a\\s*>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_LI_START = Pattern.compile("\\s*<\\s*li\\b.*?>", Pattern.CASE_INSENSITIVE);
    private static final Pattern REGEX_OTHER_TAGS = Pattern.compile("<.+?>");

    private static final Pattern REGEX_URL_ESCAPE = Pattern.compile("([_])");

    public static String html2markdown(String html) {

        String markdown = html;

        // paragraph
        markdown = REGEX_PARAGRAPH_START.matcher(markdown).replaceAll("\n");

        // line break
        markdown = REGEX_LINEBREAK.matcher(markdown).replaceAll("\n");

        // bold
        markdown = REGEX_BOLD_START.matcher(markdown).replaceAll("*");
        markdown = REGEX_BOLD_END.matcher(markdown).replaceAll("*");

        // italic
        markdown = REGEX_ITALIC_START.matcher(markdown).replaceAll("_");
        markdown = REGEX_ITALIC_END.matcher(markdown).replaceAll("_");

        // underline
        markdown = REGEX_UNDERLINE_START.matcher(markdown).replaceAll("__");
        markdown = REGEX_UNDERLINE_END.matcher(markdown).replaceAll("__");

        // strikethrough
        markdown = REGEX_STRIKE_START.matcher(markdown).replaceAll("~");
        markdown = REGEX_STRIKE_END.matcher(markdown).replaceAll("~");

        // link
        markdown = REGEX_LINK.matcher(markdown).replaceAll("[$2]($1)");
        markdown = REGEX_URL_ESCAPE.matcher(markdown).replaceAll("\\\\$1");

        // inline fixed-width
        markdown = REGEX_PRE_START.matcher(markdown).replaceAll("`");
        markdown = REGEX_PRE_END.matcher(markdown).replaceAll("`");

        // fixed-width code block
        markdown = REGEX_CODE_START.matcher(markdown).replaceAll("```\n");
        markdown = REGEX_CODE_END.matcher(markdown).replaceAll("\n```");

        // list element
        // TODO: ordered / unordered list
        markdown = REGEX_LI_START.matcher(markdown).replaceAll("\n* ");

        // other tags
        markdown = REGEX_OTHER_TAGS.matcher(markdown).replaceAll("");

        return markdown.trim();

    }

}

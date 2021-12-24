package org.rp.telegram.botapi.util;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 30.04.20
 * Time: 13:55
 */
public class MarkdownV2ToolsTest {



    @Test
    public void html2markdownSimpleTest() {
        assertEquals("Simple html2markdown test", "test", MarkdownV2Tools.html2markdown("<p>test</p>"));
    }

    // paragraph tests
    @Test
    public void html2markdownParagraph() {
        assertEquals("Paragraph",
                "one\ntwo\nthree\nfour\nfive",
                MarkdownV2Tools.html2markdown(
                        "<p align=\"center\">one</p><p>two< / p  ><P ID='ABC' CLASS='CDE'>three</P><p >four< p >five"));
    }

    // line break
    @Test
    public void html2markdownLineBreakTest() {
        assertEquals(
                "Line break",
                "one\ntwo\nthree\nfour\nfive\nsix\nseven",
                MarkdownV2Tools.html2markdown("one<br>two<br/>three<br >four<br />five<  br   /  >six<BR>seven< br >")
        );
    }

    // bold
    @Test
    public void html2markdownBoldTest() {
        assertEquals(
                "Bold (b)",
                "*one* two t*hre*e *four* f*iv*e six *se*ven",
                MarkdownV2Tools.html2markdown(
                        "<b>one</b> two t<b class=\"bold\">hre</b>e <B>four</B> f< b  >iv< /b >e six < b id='bid' class='bold'>se</ b>ven")
        );

        assertEquals(
                "Bold (strong)",
                "*one* two t*hre*e *four* f*iv*e six *se*ven",
                MarkdownV2Tools.html2markdown(
                        "<strong>one</strong> two t<strong class=\"bold\">hre</strong>e <STRONG>four</STRONG> f< strong  >iv< /strong >e six < strong id='bid' class='bold'>se</ strong>ven")
        );
    }

    // italic
    @Ignore
    @Test
    public void html2markdownItalicTest() {
        assertEquals(
                "Italic (i)",
                "_one_ two t_hre_e _four_ f_iv_e six _se_ven",
                MarkdownV2Tools.html2markdown(
                        "<i>one</i> two t<i class=\"class\">hre</i>e <I>four</I> f< i  >iv< /i >e six < i id='bid' class='class'>se</ i>ven")
        );

        assertEquals(
                "Italic (em)",
                "_one_ two t_hre_e _four_ f_iv_e six _se_ven",
                MarkdownV2Tools.html2markdown(
                        "<em>one</em> two t<em class=\"class\">hre</em>e <EM>four</EM> f< em  >iv< /em >e six < em id='bid' class='class'>se</ em>ven")
        );
    }

    // italic
    @Ignore
    @Test
    public void html2markdownUnderlineTest() {
        assertEquals(
                "Underline (u)",
                "__one__ two t__hre__e __four__ f__iv__e six __se__ven",
                MarkdownV2Tools.html2markdown(
                        "<u>one</u> two t<u class=\"class\">hre</u>e <U>four</U> f< u  >iv< /u >e six < u id='bid' class='class'>se</ u>ven")
        );

        assertEquals(
                "Underline (ins)",
                "__one__ two t__hre__e __four__ f__iv__e six __se__ven",
                MarkdownV2Tools.html2markdown(
                        "<ins>one</ins> two t<ins class=\"class\">hre</ins>e <INS>four</INS> f< ins  >iv< /ins >e six < ins id='bid' class='class'>se</ ins>ven")
            );
    }

    // Strike
    @Test
    public void html2markdownStrikeTest() {
        assertEquals(
                "Strike (s)",
                "~one~ two t~hre~e ~four~ f~iv~e six ~se~ven",
                MarkdownV2Tools.html2markdown(
                        "<s>one</s> two t<s class=\"class\">hre</s>e <S>four</S> f< s  >iv< /s >e six < s id='bid' class='class'>se</ s>ven")
        );

        assertEquals(
                "Strike (strike)",
                "~one~ two t~hre~e ~four~ f~iv~e six ~se~ven",
                MarkdownV2Tools.html2markdown(
                        "<strike>one</strike> two t<strike class=\"class\">hre</strike>e <STRIKE>four</STRIKE> f< strike  >iv< /strike >e six < strike id='bid' class='class'>se</ strike>ven")
        );

        assertEquals(
                "Strike (del)",
                "~one~ two t~hre~e ~four~ f~iv~e six ~se~ven",
                MarkdownV2Tools.html2markdown(
                        "<del>one</del> two t<del class=\"class\">hre</del>e <DEL>four</DEL> f< del  >iv< /del >e six < del id='bid' class='class'>se</ del>ven")
        );
    }

    // inline fixed-width
    @Test
    public void html2markdownCodeTest() {
        assertEquals(
                "Inline fixed-width",
                "```\none\n``` two t```\nhre\n```e ```\nfour\n``` f```\niv\n```e six ```\nse\n```ven",
                MarkdownV2Tools.html2markdown(
                        "<code>one</code> two t<code class=\"class\">hre</code>e <CODE>four</CODE> f< code  >iv< /code >e six < code id='bid' class='class'>se</ code>ven")
        );
    }

    // fixed-width code block
    @Test
    public void html2markdownPreTest() {
        assertEquals(
                "Fixed-width code block",
                "`one` two t`hre`e `four` f`iv`e six `se`ven",
                MarkdownV2Tools.html2markdown(
                        "<pre>one</pre> two t<pre class=\"class\">hre</pre>e <PRE>four</PRE> f< pre  >iv< /pre >e six < pre id='bid' class='class'>se</ pre>ven")
        );
    }

    // link
    @Test
    public void html2markdownLinkTest() {
        assertEquals(
                "Fixed-width code block",
                "[one](https://test.url/)",
                MarkdownV2Tools.html2markdown(
                        "<a href=\"https://test.url/\">one</a>")
        );
    }

    // list element
    @Test
    public void html2markdownLiTest() {
        assertEquals(
                "List element",
                "* one two t\n* hree\n* four f\n* ive six\n* seven",
                MarkdownV2Tools.html2markdown(
                        "<ul><li>one</li> two t<li class=\"class\">hre</li>e <LI>four</LI> f< li  >iv< /li >e six < li id='bid' class='class'>seven</ul>")
        );
    }

    // list element
    @Test
    public void html2markdownOtherTagsTest() {
        assertEquals(
                "Other tags",
                "one two three four five six seven",
                MarkdownV2Tools.html2markdown(
                        "<body><div>one</div> two t<span class=\"class\">hre</span>e <H1>four</H1> f< table  >iv< /table >e six < img src=\"/img/foo.bar\" id='bid' class='class'>seven<body>")
        );
    }

}
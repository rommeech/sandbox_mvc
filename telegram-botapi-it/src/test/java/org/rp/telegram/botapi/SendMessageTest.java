package org.rp.telegram.botapi;

import org.junit.Test;
import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.requestmodel.SendMessageRequestModel;
import org.rp.telegram.botapi.type.Message;
import org.rp.telegram.botapi.util.MarkdownV2Tools;
import org.rp.telegram.botapi.util.ParseMode;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 10.04.20
 * Time: 21:02
 */
public class SendMessageTest {

    //public static final String HTML = "<p><a href=\"https://www.heise.de/newsticker/meldung/Digitale-Medien-Wie-die-Digitalisierung-das-Gedaechtnis-der-Nation-veraendert-4687855.html?" +
    //        "wt_mc=rss.red.ho.ho.atom.beitrag.beitrag\"><img src=\"https://www.heise.de/scale/geometry/450/q80//imgs/18/2/8/6/6/1/6/1/shutterstock_181877726-cebe3d01cced7ecb.jpeg\" class=\"webfeedsFeaturedVisual\" alt=\"\" /></a></p><p>Digitale Medien gehören bei der Deutschen Nationalbibliothek in Leipzig zum Alltag. Auch Artikel im Netz werden gesammelt. Löst das ein Platzproblem?</p>";

    //public static final String HTML = "<p>Der dritte Teil zur Podcast-Serie rund um Reifegrademodelle beschäftigt sich mit dem Tuckman-Phasenmodell, das Entwicklungsschritte für Gruppen beleuchtet.</p>";
    //public static final String HTML = "<table> <tr><td> <a href=\"https://www.reddit.com/r/duesseldorf/comments/dwr21x/around_100_exhibitors_showcase_works_at_the_third/\"> <img src=\"https://b.thumbs.redditmedia.com/PvHeJjgHgmwjJUFAWQR6cJIbT0LKA6KA_LXV900GJYA.jpg\" alt=\"Around 100 exhibitors showcase works at the third edition of Art Düsseldorf, Germany\" title=\"Around 100 exhibitors showcase works at the third edition of Art Düsseldorf, Germany\" /> </a> </td><td> &#32; submitted by &#32; <a href=\"https://www.reddit.com/user/jiggyputtar\"> /u/jiggyputtar </a> <br/> <span><a href=\"https://www.stirworld.com/see-features-around-100-exhibitors-showcase-works-at-the-third-edition-of-art-dusseldorf-germany\">[link]</a></span> &#32; <span><a href=\"https://www.reddit.com/r/duesseldorf/comments/dwr21x/around_100_exhibitors_showcase_works_at_the_third/\">[comments]</a></span> </td></tr></table>";
    public static final String HTML = "<!-- SC_OFF --><div class=\"md\"><p>Weiß jemand ob Musikübungsräumen existiert in Düsseldorf? Ich wollte mit meinen Freunden Musik spielen. Ich spiele der Schlagzeug aber ich habe kein in meine Wohnung und wollte nicht ein kaufen. ~20 Euro pro Stunde für ein Schlagzeug und Verstärkern für Gitarren würde perfekt sein.</p> </div><!-- SC_ON --> &#32; submitted by &#32; <a href=\"https://www.reddit.com/user/ThePageMan\"> /u/ThePageMan </a> <br/> <span><a href=\"https://www.reddit.com/r/duesseldorf/comments/e4h205/musikübungsraum/\">[link]</a></span> &#32; <span><a href=\"https://www.reddit.com/r/duesseldorf/comments/e4h205/musikübungsraum/\">[comments]</a></span>";

    @Test
    public void sendMessageTest() throws BotApiException {
        TelegramBotApi tgBotApi = new TelegramBotApi();
        SendMessageRequestModel requestModel = new SendMessageRequestModel.Builder()
                .chatId("-1001146069923")
                .parseMode(ParseMode.MARKDOWN)
                .text(MarkdownV2Tools.html2markdown(HTML))
                //.text("[test](https://www.heise.de/newsticker/meldung/Digitale-Medien-Wie-die-Digitalisierung-das-Gedaechtnis-der-Nation-veraendert-4687855.html?wt_mc=rss.red.ho.ho.atom.beitrag.beitrag)\nDigitale Medien gehören bei der Deutschen Nationalbibliothek in Leipzig zum Alltag. Auch Artikel im Netz werden gesammelt. Löst das ein Platzproblem?")
                .build();
        Message message = tgBotApi.sendMessage("1073585381:AAHJ8XG593OkCwwdGTPPKR2Xt04wz0434q4", requestModel);
        System.out.printf("message: " + message);
    }

}

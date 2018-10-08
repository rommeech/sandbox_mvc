package org.rp.sandboxmvc.converter;

import com.rometools.rome.feed.synd.SyndEntry;
import org.rp.sandboxmvc.model.Post;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class SyndEntryToPostConverter implements Converter<SyndEntry, Post> {

    @Override
    public Post convert(SyndEntry syndEntry) {
        Post post = new Post();
        post.setAuthor(syndEntry.getAuthor());
        post.setContent(syndEntry.getContents().get(0).getValue());
        post.setPostUrl(syndEntry.getLink());
        post.setPostXid(syndEntry.getUri());

        if (! syndEntry.getAuthors().isEmpty()) {
            post.setAuthorUrl(syndEntry.getAuthors().get(0).getUri());
        }

        if (syndEntry.getPublishedDate() != null) {
            post.setPubDate(new Timestamp(syndEntry.getPublishedDate().getTime()));
        }

        post.setTitle(syndEntry.getTitle());
        return post;
    }

}

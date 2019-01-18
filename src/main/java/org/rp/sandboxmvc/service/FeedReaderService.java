package org.rp.sandboxmvc.service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.converter.SyndEntryToPostConverter;
import org.rp.sandboxmvc.dao.FeedDao;
import org.rp.sandboxmvc.dao.PostDao;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

@Service
public class FeedReaderService {

    private static final Logger logger = LogManager.getLogger(FeedReaderService.class);

    @Autowired
    private FeedDao feedDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private SyndEntryToPostConverter syndEntryToPostConverter;

    public void readFeeds() throws ServiceException {
        List<Feed> feeds = feedDao.getFeedsReadyForReading();
        for (Feed feed : feeds) {
            readFeed(feed);
        }
    }

    @Transactional
    public void readFeed(Feed feed) throws ServiceException {
        SyndFeed syndFeed = getSyndFeed(feed);
        updateFeed(feed, syndFeed);
        savePosts(feed, syndFeed);
        setNextJobTime(feed);
    }

    private void setNextJobTime(Feed feed) {
        feed.setNextJob(new Timestamp(feed.getJobInterval() + System.currentTimeMillis()));
        feedDao.update(feed);
    }

    private void savePosts(Feed feed, SyndFeed syndFeed) {
        for(SyndEntry entry : syndFeed.getEntries()) {
            if (!isSyndEntryAlreadySaved(feed, entry)) {
                savePostFromSyndEntry(feed, entry);
            }
            else {
                logger.info(String.format("Feed=%s: Post %s %s already saved",
                        feed.getId(), entry.getUri(), entry.getTitle()));
            }
        }
    }

    // TODO: Save source code of entry
    private void savePostFromSyndEntry(Feed feed, SyndEntry entry) {
        Post post = syndEntryToPostConverter.convert(entry);
        post.setFeed(feed);
        postDao.insert(post);
        logger.info(String.format("Feed=%s: Post %s %s %s successfully saved",
                feed.getId(), post.getId(), post.getPostXid(), post.getTitle()));
    }

    private boolean isSyndEntryAlreadySaved(Feed feed, SyndEntry entry) {
        Post post = postDao.getPostByFeedAndXid(feed, entry.getUri());
        return post != null;
    }

    private void updateFeed(Feed feed, SyndFeed syndFeed) {
        feed.setAuthor(syndFeed.getAuthor());
        if (syndFeed.getIcon() != null) {
            feed.setIconUrl(syndFeed.getIcon().getUrl());
        }
        if (syndFeed.getImage() != null) {
            feed.setLogoUrl(syndFeed.getImage().getUrl());
        }
        feed.setTitle(syndFeed.getTitle());
        feed.setDescription(syndFeed.getDescription());
        feedDao.update(feed);
    }

    private SyndFeed getSyndFeed(Feed feed) throws ServiceException {

        URL feedUrl;
        try {
            feedUrl = new URL(feed.getFeedUrl());
        } catch (MalformedURLException e) {
            throw new ServiceException(e);
        }

        SyndFeed syndFeed;
        SyndFeedInput feedInput = new SyndFeedInput();
        try {
            syndFeed = feedInput.build(new XmlReader(feedUrl));
        } catch (FeedException | IOException e) {
            throw new ServiceException(e);
        }

        return syndFeed;
    }

}

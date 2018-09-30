package org.rp.sandboxmvc.service;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.rp.sandboxmvc.dao.FeedDao;
import org.rp.sandboxmvc.model.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class FeedReaderService {

    @Autowired
    private FeedDao feedDao;

    public void readAllFeeds() throws ServiceException {
        List<Feed> feeds = feedDao.getAllFeeds();
        for (Feed feed : feeds) {
            readFeed(feed);
        }
    }

    private void readFeed(Feed feed) throws ServiceException {

        SyndFeed syndFeed = getSyndFeed(feed);
        System.out.println(syndFeed);

    }

    private SyndFeed getSyndFeed(Feed feed) throws ServiceException {

        URL feedUrl = null;
        try {
            feedUrl = new URL(feed.getFeedUrl());
        } catch (MalformedURLException e) {
            throw new ServiceException(e);
        }

        SyndFeed syndFeed = null;
        SyndFeedInput feedInput = new SyndFeedInput();
        try {
            syndFeed = feedInput.build(new XmlReader(feedUrl));
        } catch (FeedException | IOException e) {
            throw new ServiceException(e);
        }

        return syndFeed;
    }

}

package org.rp.sandboxmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.ModelException;
import org.rp.sandboxmvc.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-config-test.xml"
})
public class FeedControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private FeedService feedServiceMock;

    // Mock data
    private List<Feed> feedList;
    private Long countFeeds;

    // Config
    private static final String ERROR404_VIEW_NAME = "error/404";
    private static final String ERROR404_VIEW_JSP = "/WEB-INF/pages/error/404.jsp";

    private static final String LIST_URL = "/feeds/";
    private static final String LIST_VIEW_NAME = "feed_list";
    private static final String LIST_VIEW_JSP = "/WEB-INF/pages/feed_list.jsp";

    private static final String DELETE_URL = "/feeds/delete/";

    private static final String EDIT_URL = "/feeds/edit/";
    private static final String EDIT_VIEW_NAME = "feed_edit";
    private static final String EDIT_VIEW_JSP = "/WEB-INF/pages/feed_edit.jsp";

    private static final String NEW_URL = "/feeds/new/";
    private static final String NEW_VIEW_NAME = "feed_edit";
    private static final String NEW_VIEW_JSP = "/WEB-INF/pages/feed_edit.jsp";

    private static final String SAVE_URL = "/feeds/save/";
    private static final String SAVE_VIEW_NAME = "feed_edit";
    private static final String SAVE_VIEW_JSP = "/WEB-INF/pages/feed_edit.jsp";

    private static final Long INVALID_ID = 100500L;

    @Before
    public void setUp() throws ModelException {
        initDummyData();
        initFeedServiceMock();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void feedList() throws Exception {

        mockMvc.perform(get(LIST_URL))
                .andExpect(status().isOk())
                .andExpect(view().name(LIST_VIEW_NAME))
                .andExpect(forwardedUrl(LIST_VIEW_JSP))
                .andExpect(model().attribute("total", is(countFeeds)))
                .andExpect(model().attribute("feeds", hasSize(countFeeds.intValue())))
                .andExpect(model().attribute("feeds", hasItem(
                        allOf(
                                hasProperty("id", is(feedList.get(0).getId())),
                                hasProperty("feedUrl", is(feedList.get(0).getFeedUrl())),
                                hasProperty("jobInterval", is(feedList.get(0).getJobInterval())),
                                hasProperty("nextJob", is(feedList.get(0).getNextJob()))
                        )
                )))
                .andExpect(model().attribute("feeds", hasItem(
                        allOf(
                                hasProperty("id", is(feedList.get(1).getId())),
                                hasProperty("feedUrl", is(feedList.get(1).getFeedUrl())),
                                hasProperty("jobInterval", is(feedList.get(1).getJobInterval())),
                                hasProperty("nextJob", is(feedList.get(1).getNextJob()))
                        )
                )))
                .andExpect(model().attribute("feeds", hasItem(
                        allOf(
                                hasProperty("id", is(feedList.get(2).getId())),
                                hasProperty("feedUrl", is(feedList.get(2).getFeedUrl())),
                                hasProperty("jobInterval", is(feedList.get(2).getJobInterval())),
                                hasProperty("nextJob", is(feedList.get(2).getNextJob()))
                        )
                )))
        ;

        verify(feedServiceMock, times(1)).countFeeds();
        verify(feedServiceMock, times(1)).getFeeds();

        verifyNoMoreInteractionsInServiceMocks();
    }

    @Test
    public void feedDelete_Empty() throws Exception {

        String url = DELETE_URL;

        mockMvc.perform(get(url))
                .andExpect(status().isNotFound());

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedDelete_InvalidID() throws Exception {

        String url = DELETE_URL + "FOO/";

        mockMvc.perform(get(url))
                .andExpect(status().isBadRequest());

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedDelete_NotFoundID() throws Exception {

        String url = DELETE_URL + INVALID_ID + "/";

        mockMvc.perform(get(url))
                .andExpect(status().isNotFound());

        verify(feedServiceMock, times(1)).getById(INVALID_ID);

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedDelete_Successful() throws Exception {

        Long id = feedList.get(0).getId();

        String url = DELETE_URL + id + "/";

        mockMvc.perform(get(url))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:" + LIST_URL))
        ;

        verify(feedServiceMock, times(1)).getById(id);
        verify(feedServiceMock, times(1)).delete(id);

        verifyNoMoreInteractionsInServiceMocks();

    }


    /*



    @Test
    public void feedRead() {
        assertTrue(false);
    }

    @Test
    public void feedEdit() {
        assertTrue(false);
    }

    @Test
    public void feedNew() {
        assertTrue(false);
    }

    @Test
    public void feedSave() {
        assertTrue(false);
    }*/

    @Test
    public void dummy() {
        assertTrue(true);
    }

    private void initDummyData() throws ModelException {
        feedList = new ArrayList<>();
        feedList.add(new Feed.Builder()
                .id(1L)
                .nextJob(new Timestamp(new Date().getTime() + 100_000))
                .jobInterval(100_000L)
                .feedUrl("http://foo.com/rss")
                .build()
        );
        feedList.add(new Feed.Builder()
                .id(2L)
                .nextJob(new Timestamp(new Date().getTime() + 200_000))
                .jobInterval(300_000L)
                .feedUrl("http://bar.com/rss")
                .build()
        );
        feedList.add(new Feed.Builder()
                .id(3L)
                .nextJob(new Timestamp(new Date().getTime() + 200_000))
                .jobInterval(300_000L)
                .feedUrl("http://baz.com/rss")
                .build()
        );
        countFeeds = Long.valueOf(feedList.size());
    }

    private void initFeedServiceMock() {
        Mockito.reset(feedServiceMock);
        when(feedServiceMock.getFeeds()).thenReturn(feedList);
        when(feedServiceMock.countFeeds()).thenReturn(countFeeds);
        when(feedServiceMock.getById(1L)).thenReturn(feedList.get(0));
        when(feedServiceMock.getById(2L)).thenReturn(feedList.get(1));
        when(feedServiceMock.getById(3L)).thenReturn(feedList.get(2));
        when(feedServiceMock.getById(INVALID_ID)).thenReturn(null);
    }

    private void verifyNoMoreInteractionsInServiceMocks() {
        verifyNoMoreInteractions(feedServiceMock);
    }
}
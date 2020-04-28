package org.rp.sandboxmvc.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.rp.sandboxmvc.helper.Status;
import org.rp.sandboxmvc.model.Feed;
import org.rp.sandboxmvc.model.ModelException;
import org.rp.sandboxmvc.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// TODO: check invalid methods

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"file:/tmp2/projects/sandbox_mvc/tgtools-gui/src/main/java/webapp/WEB-INF/spring-config-test.xml"})
public class FeedControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private FeedService feedServiceMock;

    // Mock data
    private Feed newFeed;
    private List<Feed> feedList;
    private Long countFeeds;

    // Config
    private static final String LIST_URL = "/feeds/";
    private static final String LIST_VIEW_NAME = "feed_list";
    private static final String LIST_VIEW_JSP = "/WEB-INF/pages/feed_list.jsp";

    private static final String DELETE_URL = "/feeds/delete/";

    private static final String READ_URL = "/feeds/read/";


    private static final String EDIT_URL = "/feeds/edit/";
    private static final String EDIT_VIEW_NAME = "feed_edit";
    private static final String EDIT_VIEW_JSP = "/WEB-INF/pages/feed_edit.jsp";

    private static final String NEW_URL = "/feeds/new/";
    private static final String NEW_VIEW_NAME = "feed_edit";
    private static final String NEW_VIEW_JSP = "/WEB-INF/pages/feed_edit.jsp";

    private static final String SAVE_URL = "/feeds/save/";



    private static final Long INVALID_ID = 100500L;

    @Before
    public void setUp() throws ModelException {
        initDummyData();
        initServiceMocks();
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

    @Test
    public void feedNew() throws Exception {

        mockMvc.perform(get(NEW_URL))
                .andExpect(status().isOk())
                .andExpect(view().name(NEW_VIEW_NAME))
                .andExpect(forwardedUrl(NEW_VIEW_JSP))
                .andExpect(model().attribute("feed", allOf(
                        hasProperty("id", is(nullValue())),
                        hasProperty("version", is(nullValue())),
                        hasProperty("jobInterval", greaterThan(1_000L)),
                        hasProperty("nextJob", org.hamcrest.Matchers.isA(Timestamp.class))
                )))
        ;

        verify(feedServiceMock, times(1)).newFeed();

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedEdit_Empty() throws Exception {

        String url = EDIT_URL;

        mockMvc.perform(get(url))
                .andExpect(status().isNotFound());

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedEdit_InvalidId() throws Exception {

        String url = EDIT_URL + "FOO/";

        mockMvc.perform(get(url))
                .andExpect(status().isBadRequest());

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedEdit_NotFoundId() throws Exception {

        String url = EDIT_URL + INVALID_ID + "/";

        mockMvc.perform(get(url))
                .andExpect(status().isNotFound());

        verify(feedServiceMock, times(1)).getById(INVALID_ID);

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedEdit_Successful() throws Exception {

        Feed feed = feedList.get(0);

        String url = EDIT_URL + feed.getId() + "/";

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name(NEW_VIEW_NAME))
                .andExpect(forwardedUrl(NEW_VIEW_JSP))
                .andExpect(model().attribute("feed", allOf(
                        hasProperty("id", is(feed.getId())),
                        hasProperty("version", is(feed.getVersion())),
                        hasProperty("jobInterval", greaterThan(1_000L)),
                        hasProperty("nextJob", org.hamcrest.Matchers.isA(Timestamp.class))
                )))
        ;

        verify(feedServiceMock, times(1)).getById(feed.getId());

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedSave_invalidMethod() throws Exception {
        String url = SAVE_URL;

        mockMvc.perform(get(url))
                .andExpect(status().isMethodNotAllowed());

        verifyNoMoreInteractionsInServiceMocks();
    }

    // Particular case of validation fail
    // TODO: do not ignore me!
    @Ignore
    @Test
    public void feedSave_EmptyRequest() throws Exception {

        String url = SAVE_URL;

        mockMvc.perform(post(url))
                .andExpect(view().name(EDIT_VIEW_NAME))
                .andExpect(forwardedUrl(EDIT_VIEW_JSP))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("feed", "title"))
                .andExpect(model().attributeHasFieldErrors("feed", "status"))
                .andExpect(model().attributeHasFieldErrors("feed", "feedUrl"))
                .andExpect(model().attributeHasFieldErrors("feed", "jobInterval"))
                .andExpect(model().attributeHasFieldErrors("feed", "nextJob"))
                .andExpect(model().attribute("feed", hasProperty("id", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("version", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("feedUrl", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("jobInterval", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("nextJob", nullValue())))
        ;

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedSave_InvalidID() throws Exception {

        String url = SAVE_URL;

        // Redirect to list with error message. Error messages we don't test at the moment
        mockMvc.perform(
                    post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", "foobarbaz")
                )
                .andExpect(view().name(EDIT_VIEW_NAME))
                .andExpect(forwardedUrl(EDIT_VIEW_JSP))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("feed", "id"))
                .andExpect(model().attribute("feed", hasProperty("id", nullValue())))
        ;

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedSave_NotFoundID() throws Exception {

        String url = SAVE_URL;

        // Redirect to list with error message. Error messages we don't test at the moment
        mockMvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", INVALID_ID.toString())
                        .param("title", "foo")
                        .param("status", "NEW")
                        .param("feedUrl", "http://bar.baz/")
                        .param("jobInterval", "100500")
                        .param("nextJob", "2000-01-01 01:00:00")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:" + LIST_URL))
        ;

        verify(feedServiceMock, times(1)).getById(INVALID_ID);

        verifyNoMoreInteractionsInServiceMocks();

    }

    // TODO: do not ignore me!
    @Ignore
    @Test
    public void feedSave_ValidationFailed() throws Exception {

        String url = SAVE_URL;

        mockMvc.perform(
                    post(url)
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                            .param("status", "foo")
                            .param("feedUrl", "bar")
                            .param("jobInterval", "baz")
                            .param("nextJob", "foobar")
                )
                .andExpect(view().name(EDIT_VIEW_NAME))
                .andExpect(forwardedUrl(EDIT_VIEW_JSP))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("feed", "title"))
                .andExpect(model().attributeHasFieldErrors("feed", "status"))
                .andExpect(model().attributeHasFieldErrors("feed", "feedUrl"))
                .andExpect(model().attributeHasFieldErrors("feed", "jobInterval"))
                .andExpect(model().attributeHasFieldErrors("feed", "nextJob"))
                .andExpect(model().attribute("feed", hasProperty("id", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("version", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("title", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("status", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("feedUrl", is("bar"))))
                .andExpect(model().attribute("feed", hasProperty("jobInterval", nullValue())))
                .andExpect(model().attribute("feed", hasProperty("nextJob", nullValue())))
        ;

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedSave_InsertSuccessful() throws Exception {

        String url = SAVE_URL;

        mockMvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("title", "foo")
                        .param("status", "NEW")
                        .param("feedUrl", "http://bar.baz/")
                        .param("jobInterval", "100500")
                        .param("nextJob", "2001-01-01 01:00:00")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:" + LIST_URL))
        ;

        ArgumentCaptor<Feed> feedCaptor = ArgumentCaptor.forClass(Feed.class);

        verify(feedServiceMock, times(1)).insert(feedCaptor.capture());

        Feed insertedFeed = feedCaptor.getValue();

        assertNull(insertedFeed.getId());
        assertNull(insertedFeed.getVersion());
        assertThat(insertedFeed.getTitle(), is("foo"));
        assertThat(insertedFeed.getStatus(), is(Status.NEW));
        assertThat(insertedFeed.getFeedUrl(), is("http://bar.baz/"));
        assertThat(insertedFeed.getNextJob().toString(), is("2001-01-01 01:00:00.0"));
        assertThat(insertedFeed.getJobInterval(), is(100500L));

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedSave_UpdateSuccessful() throws Exception {

        String url = SAVE_URL;

        mockMvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", "1")
                        .param("version", "2")
                        .param("title", "foo")
                        .param("status", "NEW")
                        .param("feedUrl", "http://bar.baz/")
                        .param("jobInterval", "100500")
                        .param("nextJob", "2001-01-01 01:00:00")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:" + LIST_URL))
        ;

        ArgumentCaptor<Feed> feedCaptor = ArgumentCaptor.forClass(Feed.class);

        verify(feedServiceMock, times(1)).getById(1L);
        verify(feedServiceMock, times(1)).update(feedCaptor.capture());

        Feed updatedFeed = feedCaptor.getValue();

        assertThat(updatedFeed.getId(), is(1L));
        assertThat(updatedFeed.getVersion(), is(2));
        assertThat(updatedFeed.getTitle(), is("foo"));
        assertThat(updatedFeed.getStatus(), is(Status.NEW));
        assertThat(updatedFeed.getFeedUrl(), is("http://bar.baz/"));
        assertThat(updatedFeed.getNextJob().toString(), is("2001-01-01 01:00:00.0"));
        assertThat(updatedFeed.getJobInterval(), is(100500L));

        verifyNoMoreInteractionsInServiceMocks();

    }

    @Test
    public void feedRead_NoId() throws Exception {
        String url = READ_URL;

        mockMvc.perform(get(url))
                .andExpect(status().isNotFound());

        verifyNoMoreInteractionsInServiceMocks();
    }

    @Test
    public void feedRead_InvalidId() throws Exception {
        String url = READ_URL + "FOO/";

        mockMvc.perform(get(url))
                .andExpect(status().isBadRequest());

        verifyNoMoreInteractionsInServiceMocks();
    }

    @Test
    public void feedRead_NotFoundId() throws Exception {
        String url = READ_URL + INVALID_ID + "/";

        mockMvc.perform(get(url))
                .andExpect(status().isNotFound());

        verify(feedServiceMock, times(1)).getById(INVALID_ID);

        verifyNoMoreInteractionsInServiceMocks();
    }

    @Test
    public void feedRead_Successful() throws Exception {
        String url = READ_URL + 1L + "/";

        mockMvc.perform(get(url))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:" + LIST_URL));

        verify(feedServiceMock, times(1)).getById(1L);
        verify(feedServiceMock, times(1)).readFeed(feedList.get(0));

        verifyNoMoreInteractionsInServiceMocks();
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
        newFeed = new Feed.Builder()
                .nextJob(new Timestamp(new Date().getTime() + 300_000))
                .jobInterval(300_000L)
                .build();
        countFeeds = Long.valueOf(feedList.size());
    }

    private void initServiceMocks() throws ModelException {
        initFeedServiceMock();
    }

    private void initFeedServiceMock() throws ModelException {
        Mockito.reset(feedServiceMock);
        when(feedServiceMock.getFeeds()).thenReturn(feedList);
        when(feedServiceMock.countFeeds()).thenReturn(countFeeds);

        for (Feed feed : feedList) {
            when(feedServiceMock.getById(feed.getId())).thenReturn(feed);
        }

        when(feedServiceMock.newFeed()).thenReturn(newFeed);

        when(feedServiceMock.getById(INVALID_ID)).thenReturn(null);
    }

    private void verifyNoMoreInteractionsInServiceMocks() {
        verifyNoMoreInteractions(feedServiceMock);
    }
}
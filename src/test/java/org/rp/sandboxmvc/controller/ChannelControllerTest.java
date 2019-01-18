package org.rp.sandboxmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.model.ModelException;
import org.rp.sandboxmvc.model.Post;
import org.rp.sandboxmvc.model.Publication;
import org.rp.sandboxmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

// TODO: add tests for SearchCriteria

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-config-test.xml"
})
public class ChannelControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BotService botServiceMock;

    @Autowired
    private ChannelService channelServiceMock;

    @Autowired
    private FeedService feedServiceMock;

    @Autowired
    private PostService postServiceMock;

    @Autowired
    private PublicationService publicationServiceMock;

    // Mock data
    private List<Channel> channelList;
    private Long countChannels;
    private List<Publication> publicationList;
    private List<Post> postList;

    // Config
    private static final String LIST_URL = "/channels/";
    private static final String LIST_VIEW_NAME = "channel_list";
    private static final String LIST_VIEW_JSP = "/WEB-INF/pages/channel_list.jsp";

    private static final String ERROR404_VIEW_NAME = "error/404";
    private static final String ERROR404_VIEW_JSP = "/WEB-INF/pages/error/404.jsp";

    private static final String DETAILS_URL = "/channels/view/{id}/";
    private static final String DETAILS_VIEW_NAME = "channel_view";
    private static final String DETAILS_VIEW_JSP = "/WEB-INF/pages/channel_view.jsp";

    private static final String EDIT_URL = "/channels/edit/{id}/";
    private static final String EDIT_VIEW_NAME = "channel_edit";
    private static final String EDIT_VIEW_JSP = "/WEB-INF/pages/channel_edit.jsp";

    private static final String NEW_URL = "/channels/new/";
    private static final String NEW_VIEW_NAME = "channel_edit";
    private static final String NEW_VIEW_JSP = "/WEB-INF/pages/channel_edit.jsp";

    private static final String SAVE_URL = "/channels/save/";
    private static final String SAVE_VIEW_NAME = "channel_edit";
    private static final String SAVE_VIEW_JSP = "/WEB-INF/pages/channel_edit.jsp";

    private static final Long INVALID_ID = 10000L;

    @Before
    public void setUp() throws Exception {
        Mockito.reset(channelServiceMock);
        //MockitoAnnotations.initMocks(this);
        mockMvc = webAppContextSetup(webApplicationContext).build();
        setUpDummyData();
        setUpChannelServiceMock();
        setUpPublicationServiceMock();
        setUpPostServiceMock();
    }

    private void setUpDummyData() throws ModelException {
        channelList = new ArrayList<>();
        channelList.add(new Channel.Builder().id(1L).username("username1").build());
        channelList.add(new Channel.Builder().id(2L).username("username2").build());
        channelList.add(new Channel.Builder().id(3L).username("username3").build());
        countChannels = Long.valueOf(channelList.size());

        publicationList = new ArrayList<>();
        publicationList.add(new Publication.Builder().id(4L).build());
        publicationList.add(new Publication.Builder().id(5L).build());
        publicationList.add(new Publication.Builder().id(6L).build());

        postList = new ArrayList<>();
        postList.add(new Post.Builder().id(7L).build());
        postList.add(new Post.Builder().id(8L).build());
        postList.add(new Post.Builder().id(9L).build());
    }

    private void setUpChannelServiceMock() {
        when(channelServiceMock.getChannels()).thenReturn(channelList);
        when(channelServiceMock.countChannels()).thenReturn(countChannels);
        when(channelServiceMock.getById(1L)).thenReturn(channelList.get(0));
        when(channelServiceMock.getById(2L)).thenReturn(channelList.get(1));
        when(channelServiceMock.getById(3L)).thenReturn(channelList.get(2));
        when(channelServiceMock.getById(INVALID_ID)).thenReturn(null);
    }

    private void setUpPublicationServiceMock() {
        when(publicationServiceMock.getPublicationsByChannel(any())).thenReturn(publicationList);
    }

    private void setUpPostServiceMock() {
        when(postServiceMock.getUnpublishedPostsByChannel(any())).thenReturn(postList);
        when(postServiceMock.getUnpublishedPostsByChannel(any(), anyInt())).thenReturn(postList);
    }

    @Test
    public void channelList() throws Exception {

        //ArgumentCaptor<SearchCriteria> searchCriteriaArgumentCaptor = ArgumentCaptor.forClass(SearchCriteria.class);

        mockMvc.perform(get(LIST_URL))
                .andExpect(status().isOk())
                .andExpect(view().name(LIST_VIEW_NAME))
                .andExpect(forwardedUrl(LIST_VIEW_JSP))
                .andExpect(model().attribute("total", is(countChannels)))
                .andExpect(model().attribute("channels", hasSize(3)))
                .andExpect(model().attribute("channels", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("username", is("username1"))
                        )
                )))
                .andExpect(model().attribute("channels", hasItem(
                        allOf(
                                hasProperty("id", is(2L)),
                                hasProperty("username", is("username2"))
                        )
                )))
                .andExpect(model().attribute("channels", hasItem(
                        allOf(
                                hasProperty("id", is(3L)),
                                hasProperty("username", is("username3"))
                        )
                )))
        ;

        verify(channelServiceMock, times(1)).countChannels();
        verify(channelServiceMock, times(1)).getChannels();

        //verify(channelServiceMock, times(1)).getChannels(searchCriteriaArgumentCaptor.capture());

        verifyNoMoreInteractions(channelServiceMock);

        //System.out.println(searchCriteriaArgumentCaptor.getValue());

    }

    @Test
    public void channelList_NoData() throws Exception {

        when(channelServiceMock.getChannels()).thenReturn(new ArrayList<>());
        when(channelServiceMock.countChannels()).thenReturn(0L);

        mockMvc.perform(get(LIST_URL))
                .andExpect(status().isOk())
                .andExpect(view().name(LIST_VIEW_NAME))
                .andExpect(forwardedUrl(LIST_VIEW_JSP))
                .andExpect(model().attribute("total", is(0L)))
                .andExpect(model().attribute("channels", hasSize(0)))
                .andExpect(model().attribute("channels", empty()))
        ;

        verify(channelServiceMock, times(1)).countChannels();
        verify(channelServiceMock, times(1)).getChannels();

        verifyNoMoreInteractions(channelServiceMock);
    }

    @Test
    public void channelView() throws Exception {

        Long id = 1L;

        ArgumentCaptor<Channel> channelArgumentCaptor1 = ArgumentCaptor.forClass(Channel.class);
        ArgumentCaptor<Channel> channelArgumentCaptor2 = ArgumentCaptor.forClass(Channel.class);

        mockMvc.perform(get(DETAILS_URL, id))
                .andExpect(view().name(DETAILS_VIEW_NAME))
                .andExpect(forwardedUrl(DETAILS_VIEW_JSP))

                .andExpect(model().attribute("channel", hasProperty("id", is(id))))
                .andExpect(model().attribute("channel", hasProperty("username", is("username" + id))))

                .andExpect(model().attribute("publishedPosts", hasSize(3)))
                .andExpect(model().attribute("publishedPosts", hasItem(allOf(hasProperty("id", is(4L))))))
                .andExpect(model().attribute("publishedPosts", hasItem(allOf(hasProperty("id", is(5L))))))
                .andExpect(model().attribute("publishedPosts", hasItem(allOf(hasProperty("id", is(6L))))))

                .andExpect(model().attribute("unpublishedPosts", hasSize(3)))
                .andExpect(model().attribute("unpublishedPosts", hasItem(allOf(hasProperty("id", is(7L))))))
                .andExpect(model().attribute("unpublishedPosts", hasItem(allOf(hasProperty("id", is(8L))))))
                .andExpect(model().attribute("unpublishedPosts", hasItem(allOf(hasProperty("id", is(9L))))))

                .andExpect(status().isOk());

        verify(channelServiceMock, times(1)).getById(id);
        verifyNoMoreInteractions(channelServiceMock);

        verify(publicationServiceMock, times(1)).getPublicationsByChannel(channelArgumentCaptor1.capture());
        verifyNoMoreInteractions(publicationServiceMock);

        verify(postServiceMock, times(1)).getUnpublishedPostsByChannel(channelArgumentCaptor2.capture());
        verifyNoMoreInteractions(postServiceMock);

        assertEquals(1L, (long)channelArgumentCaptor1.getValue().getId());
        assertEquals(1L, (long)channelArgumentCaptor2.getValue().getId());
    }

    @Test
    public void channelView_NotFound() throws Exception {

        mockMvc.perform(get(DETAILS_URL, INVALID_ID))
                .andExpect(view().name(ERROR404_VIEW_NAME))
                .andExpect(forwardedUrl(ERROR404_VIEW_JSP))
                .andExpect(status().isNotFound());

        verify(channelServiceMock, times(1)).getById(INVALID_ID);

        verifyNoMoreInteractions(channelServiceMock);
    }

    @Test
    public void channelEdit() throws Exception {

        Long id = 1L;

        mockMvc.perform(get(EDIT_URL, id))
                .andExpect(view().name(EDIT_VIEW_NAME))
                .andExpect(forwardedUrl(EDIT_VIEW_JSP))
                .andExpect(model().attribute("channel", hasProperty("id", is(id))))
                .andExpect(model().attribute("channel", hasProperty("username", is("username" + id))))

                .andExpect(status().isOk());

        verify(channelServiceMock, times(1)).getById(id);
        verifyNoMoreInteractions(channelServiceMock);

        verifyNoMoreInteractions(publicationServiceMock);

        verifyNoMoreInteractions(postServiceMock);
    }

    @Test
    public void channelEdit_NotFound() throws Exception {

        mockMvc.perform(get(DETAILS_URL, INVALID_ID))
                .andExpect(view().name(ERROR404_VIEW_NAME))
                .andExpect(forwardedUrl(ERROR404_VIEW_JSP))
                .andExpect(status().isNotFound());

        verify(channelServiceMock, times(1)).getById(INVALID_ID);

        verifyNoMoreInteractions(channelServiceMock);
    }

    @Test
    public void channelNew() throws Exception {

        mockMvc.perform(get(NEW_URL))
                .andExpect(view().name(NEW_VIEW_NAME))
                .andExpect(forwardedUrl(NEW_VIEW_JSP))
                .andExpect(model().attribute("channel", is(allOf(
                        hasProperty("id", is(nullValue())),
                        hasProperty("username", is(nullValue()))
                ))))

                .andExpect(status().isOk());

        verifyNoMoreInteractions(channelServiceMock);
        verifyNoMoreInteractions(publicationServiceMock);
        verifyNoMoreInteractions(postServiceMock);

    }

    /* Test validation: see Channel annotations */
    /*@Test
    public void channelSave_ValidationFails() throws Exception {

        ResultActions channel = mockMvc.perform(post(SAVE_URL)
                .contentType(APPLICATION_FORM_URLENCODED)
                //.param("name", "")
                .sessionAttr("channel", new Channel()))
                .andExpect(view().name(EDIT_VIEW_NAME))
                .andExpect(forwardedUrl(EDIT_VIEW_JSP))
                .andExpect(status().isOk());

        mockMvc.perform(post(SAVE_URL))
                .andExpect(view().name(SAVE_VIEW_NAME))
                .andExpect(forwardedUrl(SAVE_VIEW_JSP))
                .andExpect(model().attribute("channel", is(allOf(
                        hasProperty("id", is(nullValue())),
                        hasProperty("username", is(nullValue()))
                ))))

                .andExpect(status().isOk());

        verifyNoMoreInteractions(channelServiceMock);
        verifyNoMoreInteractions(publicationServiceMock);
        verifyNoMoreInteractions(postServiceMock);

    }*/

    /*

    @Test
    public void channelSave() {
    }

    @Test
    public void channelDelete() {
    }
    */
}
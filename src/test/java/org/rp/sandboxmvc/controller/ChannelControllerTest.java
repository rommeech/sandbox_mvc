package org.rp.sandboxmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// TODO: add tests for SearchCriteria

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-config-test.xml"
})
public class ChannelControllerTest {

    private MockMvc mockMvc;

    @Autowired
    @Qualifier(value = "channelService")
    private ChannelService channelServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    // Mock data
    private List<Channel> channelList;
    private Long countChannels;

    // Config
    private static final String LIST_URL = "/channels/";
    private static final String LIST_VIEW_NAME = "channel_list";
    private static final String LIST_VIEW_JSP = "/WEB-INF/pages/channel_list.jsp";

    private static final String ERROR404_VIEW_NAME = "error/404";
    private static final String ERROR404_VIEW_JSP = "/WEB-INF/pages/error/404.jsp";

    private static final String DETAILS_URL = "/channels/view/{id}/";
    private static final String DETAILS_VIEW_NAME = "channel_list";
    private static final String DETAILS_VIEW_JSP = "/WEB-INF/pages/channel_list.jsp";

    private static final Long INVALID_ID = 4L;

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp started");

        Mockito.reset(channelServiceMock);

        //MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        channelList = new ArrayList<>();

        channelList.add(new Channel.Builder().id(1L).username("username1").build());
        channelList.add(new Channel.Builder().id(2L).username("username2").build());
        channelList.add(new Channel.Builder().id(3L).username("username3").build());

        countChannels = new Long(channelList.size());

        when(channelServiceMock.getChannels()).thenReturn(channelList);
        when(channelServiceMock.countChannels()).thenReturn(countChannels);

        when(channelServiceMock.getById(1L)).thenReturn(channelList.get(0));
        when(channelServiceMock.getById(2L)).thenReturn(channelList.get(1));
        when(channelServiceMock.getById(3L)).thenReturn(channelList.get(2));
        when(channelServiceMock.getById(INVALID_ID)).thenReturn(null);

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

    /*@Test
    public void channelView() throws Exception {

        Long id = 1L;

        mockMvc.perform(get(DETAILS_URL, id))
                .andExpect(view().name(DETAILS_VIEW_NAME))
                .andExpect(forwardedUrl(DETAILS_VIEW_JSP))
                .andExpect(model().attribute("channel", is(allOf(
                        hasProperty("id", is(id)),
                        hasProperty("username", is("username" + id))
                ))))
                .andExpect(model().attribute("publishedPosts", notNull()))
                .andExpect(model().attribute("unpublishedPosts", notNull()))
                .andExpect(status().isOk());

        verify(channelServiceMock, times(1)).getById(id);

        verifyNoMoreInteractions(channelServiceMock);
    }*/

    @Test
    public void channelView_NotFound() throws Exception {

        mockMvc.perform(get(DETAILS_URL, INVALID_ID))
                .andExpect(view().name(ERROR404_VIEW_NAME))
                .andExpect(forwardedUrl(ERROR404_VIEW_JSP))
                .andExpect(status().isNotFound());

        verify(channelServiceMock, times(1)).getById(INVALID_ID);

        verifyNoMoreInteractions(channelServiceMock);
    }

    public void channelEdit_NotFound() throws Exception {
        mockMvc.perform(get(DETAILS_URL, INVALID_ID))
                .andExpect(view().name(ERROR404_VIEW_NAME))
                .andExpect(forwardedUrl(ERROR404_VIEW_JSP))
                .andExpect(status().isNotFound());

        verify(channelServiceMock, times(1)).getById(INVALID_ID);

        verifyNoMoreInteractions(channelServiceMock);
    }

    /*
    @Test


    @Test
    public void channelNew() {
    }

    @Test
    public void channelSave() {
    }

    @Test
    public void channelDelete() {
    }
    */
}
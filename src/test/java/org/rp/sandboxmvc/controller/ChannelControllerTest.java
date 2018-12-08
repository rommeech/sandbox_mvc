package org.rp.sandboxmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
    }

    @Test
    public void channelList() throws Exception {

        ArgumentCaptor<SearchCriteria> searchCriteriaArgumentCaptor = ArgumentCaptor.forClass(SearchCriteria.class);

        doNothing().when(channelServiceMock).fixSearchCriteria(searchCriteriaArgumentCaptor.capture());
        when(channelServiceMock.getChannels(any())).thenReturn(channelList);
        when(channelServiceMock.countChannels(any())).thenReturn(countChannels);

        mockMvc.perform(get("/channels/"))
                .andExpect(status().isOk())
                .andExpect(view().name("channel_list"))
                .andExpect(forwardedUrl("/WEB-INF/pages/channel_list.jsp"))
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

        verify(channelServiceMock, times(1)).countChannels(any());
        verify(channelServiceMock, times(1)).fixSearchCriteria(any());
        verify(channelServiceMock, times(1)).getChannels(searchCriteriaArgumentCaptor.capture());

        //System.out.println(searchCriteriaArgumentCaptor.getValue());

    }

    @Test
    public void channelList_NoData() throws Exception {

        when(channelServiceMock.getChannels(any())).thenReturn(new ArrayList<>());
        when(channelServiceMock.countChannels(any())).thenReturn(0L);

        mockMvc.perform(get("/channels/"))
                .andExpect(status().isOk())
                .andExpect(view().name("channel_list"))
                .andExpect(forwardedUrl("/WEB-INF/pages/channel_list.jsp"))
                .andExpect(model().attribute("total", is(0L)))
                .andExpect(model().attribute("channels", hasSize(0)))
                .andExpect(model().attribute("channels", empty()))
        ;

        verify(channelServiceMock, times(1)).getChannels(any());
    }

    /*@Test
    public void channelView() {
    }*/

    /*
    @Test
    public void channelEdit() {
    }

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
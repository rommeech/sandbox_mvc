package org.rp.sandboxmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.model.Channel;
import org.rp.sandboxmvc.service.AbstractService;
import org.rp.sandboxmvc.service.ChannelService;
import org.rp.sandboxmvc.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// TODO: add tests for SearchCriteria

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-config.xml",
        "file:src/main/webapp/WEB-INF/spring-config-test.xml"
})
public class ChannelControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ChannelService channelServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    // Mock data
    private List<Channel> channelList;
    private Long countChannels;

    @Before
    public void setUp() throws Exception {
        Mockito.reset(channelServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        channelList = new ArrayList<>();

        channelList.add(new Channel.Builder().id(1L).username("username1").build());
        channelList.add(new Channel.Builder().id(2L).username("username2").build());
        channelList.add(new Channel.Builder().id(3L).username("username3").build());

        countChannels = new Long(channelList.size());
    }

    @Test
    public void channelList() throws Exception {

        ArgumentCaptor<SearchCriteria> searchCriteriaArgumentCaptor1 = ArgumentCaptor.forClass(SearchCriteria.class);

        when(channelServiceMock.getChannels(searchCriteriaArgumentCaptor1.capture())).thenReturn(channelList);
        when(channelServiceMock.countChannels(any())).thenReturn(countChannels);

        verify(channelServiceMock).countChannels(searchCriteriaArgumentCaptor1.capture());

        //verify(channelServiceMock).fixSearchCriteria(any());
        //verify(channelServiceMock).getChannels(any());

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


        //verify(channelServiceMock, times(1)).countChannels(any());
        //verifyNoMoreInteractions(channelServiceMock);

        //assertEquals(searchCriteriaArgumentCaptor1.getValue().getOrderBy(), "id");
        //verify(searchCriteriaArgumentCaptor1.getValue().getOrderDir()).equals("desc");

        //System.out.println(searchCriteriaArgumentCaptor1.getValue());

    }

    /*
    @Test
    public void channelEdit() {
    }

    @Test
    public void channelView() {
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
package org.rp.sandboxmvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.rp.sandboxmvc.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-config.xml",
        "file:src/main/webapp/WEB-INF/spring-config-test.xml"
})
public class FeedControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private FeedService feedServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(feedServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /*@Test
    public void feedList() {
        assertTrue(false);
    }

    @Test
    public void feedDelete() {
        assertTrue(false);
    }

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
}
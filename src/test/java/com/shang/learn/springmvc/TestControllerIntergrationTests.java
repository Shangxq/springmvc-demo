package com.shang.learn.springmvc;

import com.shang.learn.springmvc.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestControllerIntergrationTests {
    private MockMvc mockMvc;
    @Autowired
    private DemoService demoService;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    MockHttpSession session;

    @Autowired
    MockHttpServletRequest request;

    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testNormalController() throws Exception{
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/classes/views/index.jsp"))
                .andExpect(model().attribute("msg",demoService.satSomething()));
    }

    @Test
    public void testRestController() throws Exception{
        mockMvc.perform(get("/anno/pathvar/nihao"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("url:http://localhost/anno/pathvar/nihaocan access,str:nihao"));
    }
}

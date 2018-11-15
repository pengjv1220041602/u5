package com.su5.controller;

import com.su5.entry.Goods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ViewControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockGoodsMvc;

    @Before
    public void setUp() throws Exception {
        mockGoodsMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void view() throws Exception{
        mockGoodsMvc.perform(get("/view")).andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("/view"));
    }

    @Test
    public void view1() throws Exception{
        mockGoodsMvc.perform(get("/")).andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("/view"))
        .andExpect(model().attribute("goods", new Goods("1", "2", 1)));
    }
}
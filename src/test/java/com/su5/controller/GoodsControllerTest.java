package com.su5.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001516:29
 * @Version 1.0
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsControllerTest {

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

    /**
     * @deprecation:  验证get和post请求  ，验证405
     */
    @Test
    public void goodsById1() throws Exception {
        mockGoodsMvc.perform(post("/goods/1"))
                .andExpect(status().is(405));
    }
    /**
     * @deprecation:  验证get和post请求  ，验证405
     */
    @Test
    public void goodsById2() throws Exception {
        mockGoodsMvc.perform(get("/goods/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getById3 () throws Exception {
        mockGoodsMvc.perform(get("/goods/{id}", "34")).andExpect(status().isOk());
    }

    @Test
    public void getById4 () throws Exception {
        mockGoodsMvc.perform(get("/goods").param("id", "34")).andExpect(status().isOk());
    }


}
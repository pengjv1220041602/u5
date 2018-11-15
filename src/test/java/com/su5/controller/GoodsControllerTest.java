package com.su5.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.su5.constants.Code;
import com.su5.entry.Goods;
import com.su5.utils.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockGoodsMvc;

    @Before
    public void setUp() throws Exception {
        mockGoodsMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void goodsById() throws Exception {
        mockGoodsMvc.perform(get("/goods/{id}", "1")).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.data.id").value("1"));

    }

    @Test
    public void goodsByIdPa() throws Exception{
        Goods goods = new Goods("1", "2", null);
        final String resultJson = objectMapper.writeValueAsString(new Result(Code.SUCCESS_CODE, goods, "查询成功"));
        mockGoodsMvc.perform(get("/goods").param("id", "1")).andExpect(content().json(resultJson));
    }

    @Test
    public void updateOrSaveGoods() throws Exception{
        Goods goods = new Goods();
        goods.setName("hello world");
        goods.setFlag(1);
        final String json = objectMapper.writeValueAsString(goods);
        mockGoodsMvc.perform(post("/goods").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().is2xxSuccessful()).andReturn();
        goods.setId("1");
        mockGoodsMvc.perform(post("/goods").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().is2xxSuccessful()).andReturn();
    }

    @Test
    public void listBook() throws Exception{

        mockGoodsMvc.perform(get("/listgood")
                .param("page","1")
                .param("size", "2")
                .param("goods.name",""))
                .andExpect(status().is2xxSuccessful()).andDo(print());
    }

}
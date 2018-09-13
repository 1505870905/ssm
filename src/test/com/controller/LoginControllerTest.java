package com.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//表示测试的是controller
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mvc.xml"})
public class LoginControllerTest {

    @Autowired
    WebApplicationContext wac;
    //controller 测试核心类  mock模拟
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void login() throws Exception {
        String json="{\"id\":3,\"name\":\"rose\",\"password\":\"123456\"}";
        mockMvc.perform(get("/login/loginx.do").param("id","3"))
                .andDo(print())//打印该次请求的结果
                .andExpect(status().isOk())//期待方法调用成功
                .andExpect(content().string(json))
                .andReturn();
    }
    @Test
    public void login1() throws Exception{
        mockMvc.perform(post("/login/login.do").param("name","rose").param("password","123456"))
                .andDo(print())
                .andExpect(status().isOk())//期待方法调用成功
                .andExpect(view().name("success"))//期待视图的名字
                .andExpect(model().attribute("name","rose"))//期待model的值
                .andExpect(model().attribute("password","123456"));
    }

}
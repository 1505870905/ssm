package com.interceptor;

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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //指定加载 ApplicationContext是一个WebApplicationContext
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mvc.xml"})
public class LoginInterceptorTest {
    @Autowired
    WebApplicationContext wac;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testLogin() throws Exception {
        /*mockMvc.perform(get("/login/login.do")).andExpect(status().isOk())
                .andDo(print())
            .andExpect(view().name("error"));*/



        mockMvc.perform(get("/student/get.do").param("id","1"))
                .andExpect(status().is3xxRedirection())
                .andDo(print());


        mockMvc.perform(get("/student/get.do").param("id","1").sessionAttr("user","rose"))
                .andExpect(status().isOk())
                .andDo(print());

    }

}
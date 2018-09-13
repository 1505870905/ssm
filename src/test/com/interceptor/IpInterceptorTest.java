package com.interceptor;


import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IpInterceptorTest {



    @Test
    public void preHandle() throws Exception {


    }

    @Test
    public void postHandle() {
    }

    @Test
    public void afterCompletion() {
    }
}
package com.controller;

import com.entity.User;
import com.google.gson.Gson;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @ResponseBody
    @RequestMapping("/loginx.do")
    public String login(int id, String name, String password){
        User user = loginService.findById(id);
        Gson gson = new Gson();
        String json = gson.toJson(user);//787987946465
        return json;
    }
    //sdgfdsf
    @RequestMapping("/login.do")
    public ModelAndView login1(String name, String password, ModelAndView mav, HttpServletRequest request) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            mav.setViewName("error");
            return mav;
        }
        if (name.equals("rose") && password.equals("123456"))
            mav.setViewName("success");
            mav.addObject("name","rose");
            mav.addObject("password","123456");
            request.getSession().setAttribute("user", "rose");
            return mav;
    }
}

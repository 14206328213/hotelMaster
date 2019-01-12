package com.fhx.controller;


import com.fhx.entity.Customer;
import com.fhx.entity.User;
import com.fhx.servicelmp.ItemServicelmp;
import com.fhx.servicelmp.OrderServicelmp;
import com.fhx.servicelmp.UserServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class userController {
    @Autowired
    private UserServicelmp usi;
    @Autowired
    private OrderServicelmp osi;
    @Autowired
    private ItemServicelmp isi;
    @RequestMapping("/userInfo.html")
    public ModelAndView userInfoPage(ModelAndView modelAndView){
        if(modelAndView.getModel().get("user")==null){
            modelAndView.clear();
            modelAndView.getModel().put("msg","您还没有登录,请先登录");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        User user=(User) modelAndView.getModel().get("user");
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }


}

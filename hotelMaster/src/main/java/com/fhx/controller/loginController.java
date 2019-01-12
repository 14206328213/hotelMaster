package com.fhx.controller;


import com.fhx.entity.Customer;
import com.fhx.entity.User;
import com.fhx.servicelmp.UserServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class loginController {
    @Autowired
    private UserServicelmp userServicelmp;

    @RequestMapping(value = "/loginCheck.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loginCheck(Model model, @RequestBody User user){
        boolean isValidUser=userServicelmp.hasMatchUser(user.getUsername(),user.getPassword());
        Map<String, Object> map = new HashMap<String, Object>();
        if(!isValidUser){
            map.put("status","error");
        }else{
            user=userServicelmp.findUserByUid(user.getUsername());
            map.put("user",user);
            map.put("status", "success");
        }
        return map;
    }

    @RequestMapping("/loginBack.html")
    public void loginBack(HttpServletRequest request,HttpServletResponse response){
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        try{
            response.sendRedirect("/login.html");
        }catch (Exception e){

        }
    }
}

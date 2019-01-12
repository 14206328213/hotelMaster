package com.fhx.controller;

import com.fhx.entity.*;
import com.fhx.servicelmp.ItemServicelmp;
import com.fhx.servicelmp.OrderServicelmp;
import com.fhx.servicelmp.RoomServicelmp;
import com.fhx.servicelmp.UserServicelmp;
import com.sun.org.apache.bcel.internal.generic.FLOAD;
import org.apache.ibatis.type.FloatTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class pageController {
    @Autowired
    private RoomServicelmp rsi;
    @Autowired
    private ItemServicelmp isi;
    @Autowired
    private UserServicelmp usi;
    @Autowired
    private OrderServicelmp osi;
    @RequestMapping("/order.html")
    public ModelAndView orderPage(ModelAndView modelAndView, HttpServletRequest request){
        String uID=request.getParameter("uID");
        User user=usi.findUserByUid(uID);
        Customer customer=usi.findCusByUID(uID);
        customer.setUser(user);
        List<Room> rooms=rsi.findRooms();
        int num=0;
        float max= 0;
        float min=1000;
        for(Room r:rooms){
            if(r.getStatus()==Room.FREE){
                num++;
            }
        }
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("customer",customer);
        modelAndView.getModel().put("freenum",num);
        session.setAttribute("rooms",rooms);
        List<Order> orders=(List<Order>)usi.findOrdersbyCid(customer.getcID());
        session.setAttribute("orders",orders);
        session.setAttribute("usi",usi);
        modelAndView.setViewName("order");
        return modelAndView;
    }

    @RequestMapping("/login.html")
    public ModelAndView loginPage(ModelAndView mav){
        ModelAndView modelAndView=new ModelAndView("login");
        if(mav.getModel().get("msg")!=null){
            modelAndView.getModel().put("msg",mav.getModel().get("msg"));
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping("/index.html")
    public ModelAndView indexPage(ModelAndView modelAndView,HttpServletRequest request){
        List<Room> rooms=rsi.findRooms();
        String uID=request.getParameter("uID");
        User user=usi.findUserByUid(uID);
        HttpSession session=request.getSession();
        session.setAttribute("rooms",rooms);
        session.setAttribute("user",user);
        List<Item> items=isi.findItems();
        session.setAttribute("items",items);
        session.setAttribute("usi",usi);
        session.setAttribute("osi",osi);
        modelAndView.setViewName("index");
        int num=0;
        for(Room r:rooms){
            if(r.getStatus()==Room.FREE){
                num++;
            }
        }
        modelAndView.getModel().put("freenum",num);
        return modelAndView;
    }

    @RequestMapping("/show.html")
    public String showPage(Model model,HttpServletRequest request){
        List<Room> rooms=rsi.findRooms();
        int num=0;
        float max= 0;
        float min=1000;
        for(Room r:rooms){
            if(r.getStatus()==Room.FREE){
                num++;
            }
            if(r.getRcost()>max){
                max=r.getRcost();
            }
            if(r.getRcost()<min){
                min=r.getRcost();
            }
        }
        List<Item> items=isi.findItems();
        model.addAttribute("rmax",max);
        model.addAttribute("rmin",min);
        HttpSession session=request.getSession();
        session.setAttribute("rooms",rooms);
        session.setAttribute("items",items);
        model.addAttribute("freenum",num);
        return "show";
    }



}

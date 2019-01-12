package com.fhx.controller;


import com.fhx.entity.*;
import com.fhx.service.ItemService;
import com.fhx.servicelmp.ItemServicelmp;
import com.fhx.servicelmp.OrderServicelmp;
import com.fhx.servicelmp.RoomServicelmp;
import com.fhx.servicelmp.UserServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.rmi.MarshalledObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class orderController {

    @Autowired
    private RoomServicelmp rsi;

    @Autowired
    private UserServicelmp usi;

    @Autowired
    private OrderServicelmp osi;
    @Autowired
    private ItemServicelmp isi;
    /*订单处理*/
    @RequestMapping("/orderCheck.do")
    public ModelAndView orderAction(ModelAndView modelAndView, HttpServletRequest request,
                                    HttpServletResponse response){
        User user=(User) request.getSession().getAttribute("user");
        if(user!=null){
            String rID=(String)request.getParameter("rID");
            Customer customer=(Customer)request.getSession().getAttribute("customer");
            Order order=new Order();
            order.setcID(customer.getcID());
            order.setOtype(0);
            order.setrID(rID);
            order.setTotal(Float.parseFloat((String)request.getParameter("total")));
            order.setBargin(Float.parseFloat((String)request.getParameter("bargin")));
            int day=Integer.parseInt((String) request.getParameter("day"));
            order.setDay(day);
            String time=(String)request.getParameter("time");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            try {
                order.setOtime(sdf.parse(time));
            }catch(Exception e){

            }
            //添加订单，同时更新房间状态
            int ono=rsi.addOrder(order);
            order.setoNo(ono);
            if(ono>0){
                String[] nums=(String [])request.getParameterValues("num");
                HttpSession session=request.getSession();
                Room room=rsi.findByrID(rID);
                List<Item> items=(List<Item>) session.getAttribute("items");
                for (int i=0;i<nums.length;i++){
                    Item item=(Item) items.get(i);
                    isi.useItem(item,order,Float.parseFloat(nums[i])*item.getIcost());
                }
                modelAndView.getModel().put("msg","订单成功");
            }
            else modelAndView.getModel().put("msg","订单失败");
        }else{
            modelAndView.getModel().put("msg","您还没有登录,请先登录");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        initOrderPage(modelAndView,request);
        modelAndView.setViewName("order");
        return modelAndView;
    }
    @RequestMapping("/orderCheck.html")
    public ModelAndView order(ModelAndView modelAndView,HttpServletRequest  request){
        User user=(User)request.getSession().getAttribute("user");
        if(user!=null){
            String rID=request.getParameter("rID");//获得房间编号
            Room room=rsi.findByrID(rID);
            List<Item> items=isi.findItems();
            for(Item it:items){
                if(it.getStock()==0)items.remove(it);
            }
            HttpSession session=request.getSession();
            session.setAttribute("items",items);
            modelAndView.getModel().put("room",room);
            modelAndView.getModel().put("room",room);
            initOrderPage(modelAndView,request);
            modelAndView.setViewName("orderCheck");
            return modelAndView;
        }else{
            modelAndView.getModel().put("msg","您还没有登录,请先登录");
            modelAndView.setViewName("login");
            return modelAndView;
        }

    }

    private void initOrderPage(ModelAndView modelAndView,HttpServletRequest request){
        List<Room> rooms=rsi.findRooms();
        List<Item> items=isi.findItems();
        HttpSession session=request.getSession();
        Customer customer=(Customer)session.getAttribute("customer");
        int num=0;
        float max= 0;
        float min=1000;
        for(Room r:rooms){
            if(r.getStatus()==Room.FREE){
                num++;
            }
        }
        for(Item item:items){
            if(item.getStock()==0){
                items.remove(item);
            }
        }
        List<Order> orders=(List<Order>)usi.findOrdersbyCid(customer.getcID());
        System.out.println(orders.size());
        session.setAttribute("orders",orders);
        session.setAttribute("rooms",rooms);
        session.setAttribute("items",items);
        modelAndView.getModel().put("freenum",num);
    }


    @RequestMapping("/pay.do")
    public ModelAndView payOrder(ModelAndView modelAndView,HttpServletRequest request){
        String ono=request.getParameter("ono");
        osi.payOrder(ono);
        initOrderPage(modelAndView,request);
        modelAndView.setViewName("order");
        return modelAndView;
    }

    @RequestMapping("/itemback.do")
    public ModelAndView itemBack(ModelAndView modelAndView, HttpServletRequest request){
        String ono=request.getParameter("ono");
        isi.itemback(Integer.parseInt(ono));
        initOrderPage(modelAndView,request);
        modelAndView.setViewName("order");
        return modelAndView;
    }
}

package com.fhx.controller;

import com.fhx.entity.Customer;
import com.fhx.entity.Item;
import com.fhx.entity.Room;
import com.fhx.entity.User;
import com.fhx.servicelmp.ItemServicelmp;
import com.fhx.servicelmp.OrderServicelmp;
import com.fhx.servicelmp.RoomServicelmp;
import com.fhx.servicelmp.UserServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class adminController {
    @Autowired
    private RoomServicelmp rsi;
    @Autowired
    private UserServicelmp usi;
    @Autowired
    private ItemServicelmp isi;
    @Autowired
    private OrderServicelmp osi;
    //退房间
    @RequestMapping("/change.do")
    public ModelAndView changeRoomStatus(ModelAndView modelAndView, HttpServletRequest request){
        String rID=request.getParameter("riD");
        rsi.changeRoomStatus(0,rID);
        HttpSession session=request.getSession();
        session.setAttribute("osi",osi);
        modelAndView.setViewName("index");
        initIndexPage(modelAndView,request);
        return modelAndView;
    }
    @RequestMapping("/home.do")
    public ModelAndView home(ModelAndView modelAndView, HttpServletRequest request){
        String rID=request.getParameter("riD");
        rsi.changeRoomStatus(2,rID);
        HttpSession session=request.getSession();
        session.setAttribute("osi",osi);
        modelAndView.setViewName("index");
        initIndexPage(modelAndView,request);
        return modelAndView;
    }

    private void initIndexPage(ModelAndView modelAndView,HttpServletRequest request){
        List<Room> rooms=rsi.findRooms();
        HttpSession session=request.getSession();
        session.setAttribute("rooms",rooms);
        List<Item> items=isi.findItems();
        session.setAttribute("items",items);
        modelAndView.setViewName("index");
        int num=0;
        for(Room r:rooms){
            if(r.getStatus()==Room.FREE){
                num++;
            }
        }
        modelAndView.getModel().put("freenum",num);
    }

//    <td><input name="iname"></td>
//                <td><input name="inum"></td>
//                <td><input name="icost"></td>
//                <td><input name="unit">/td>
    @RequestMapping("/additem")
    public ModelAndView addItem(ModelAndView modelAndView,HttpServletRequest request) throws Exception{
        request.setCharacterEncoding("utf-8");
        Item item=new Item();
        item.setIname(request.getParameter("iname"));
        item.setUnit(request.getParameter("unit"));
        item.setStock(Integer.parseInt(request.getParameter("inum")));
        List<Item> items=isi.findItems();
        item.setIiD(Integer.toString(items.size()+1));
        isi.addItem(item);
        initIndexPage(modelAndView,request);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/addCus.do")
    public ModelAndView addCus(ModelAndView modelAndView, Customer customer,HttpServletRequest request) throws Exception{
        request.setCharacterEncoding("utf-8");
        System.out.println("adminCOntroller要插入的"+customer.toString());
        initIndexPage(modelAndView,request);
        customer.setRole(0);
        usi.addCus(customer);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/addUser")
    public ModelAndView addUSer(ModelAndView modelAndView, User user,HttpServletRequest request) throws Exception{
        request.setCharacterEncoding("utf-8");
        System.out.println("adminCOntroller要插入的"+user.toString());
        user.setRole(1);
        usi.addUser(user);
        initIndexPage(modelAndView,request);
        modelAndView.setViewName("index");
        return modelAndView;
    }


}

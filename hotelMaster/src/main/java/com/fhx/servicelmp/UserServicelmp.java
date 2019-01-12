package com.fhx.servicelmp;

import com.fhx.dao.OrderDao;
import com.fhx.dao.UserDao;
import com.fhx.entity.Customer;
import com.fhx.entity.ItemUsing;
import com.fhx.entity.Order;
import com.fhx.entity.User;
import com.fhx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.ConversionUtils;
import org.testng.annotations.Test;

import java.util.List;

@Service
public class UserServicelmp implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public Customer findCusByCid(String cid) {
        return userDao.findCusByCid(cid);
    }

    @Override
    public List<ItemUsing> findItemsInUse(int ono) {
        if(orderDao.isUsingItems(ono)){
            return orderDao.findItemsInUse(ono);
        }
        else return null;
    }

    public boolean hasMatchUser(String uid, String passowrd){
        int ct=userDao.getMatchCount(uid,passowrd);
        return ct>0;
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }
    public void addCus(Customer customer) {
        User user=new User();
        user.setRole(customer.getRole());
        user.setPassword(customer.getPassword());
        user.setUsername(customer.getUsername());
        userDao.insertUser(user);
        userDao.inserCus(customer);
    }
    @Override
    public Customer findCusByUID(String uID) {
        return userDao.findCusByUID(uID);
    }

    @Override
    public List<Order> findOrdersbyCid(String cid) {
        return orderDao.findOrdersbyCid(cid);
    }

    @Override
    public User findUserByUid(String uID) {
        return userDao.findUserByUid(uID);
    }
}

package com.fhx.service;

import com.fhx.entity.Customer;
import com.fhx.entity.ItemUsing;
import com.fhx.entity.Order;
import com.fhx.entity.User;

import java.util.List;

public interface UserService {
    public abstract boolean hasMatchUser(String uid, String passowrd);
    public abstract void addUser(User user);
    public abstract Customer findCusByUID(String uID);
    public abstract User findUserByUid(String uID);
    public abstract List<Order> findOrdersbyCid(String cid);
    public abstract List<ItemUsing> findItemsInUse(int ono);
    Customer findCusByCid(String cid);
}

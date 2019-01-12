package com.fhx.service;

import com.fhx.entity.Customer;
import com.fhx.entity.Item;
import com.fhx.entity.Order;
import com.fhx.entity.Room;

import java.util.List;

public interface ItemService {
    public abstract List<Item> findItems();

    public abstract boolean useItem(Item item,Order order,float iecost);
}

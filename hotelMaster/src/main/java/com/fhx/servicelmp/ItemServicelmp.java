package com.fhx.servicelmp;

import com.fhx.dao.ItemDao;
import com.fhx.dao.OrderDao;
import com.fhx.entity.*;
import com.fhx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServicelmp implements ItemService {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Item> findItems() {
        return itemDao.findItems();
    }

    @Override
    public boolean useItem(Item item,Order order,float iecost) {
        itemDao.reduceItemNum(item.getIiD(),(int)(iecost/item.getIcost()));//减少库存
        return itemDao.useItem(item,order,iecost);
    }

    public void itemback(int ono){
        List<ItemUsing> itemUsings=orderDao.findItemsInUse(ono);
        for(ItemUsing itemUsing:itemUsings)
        itemDao.addItemNum(itemUsing.getIiD(),(int)(itemUsing.getIecost()/itemUsing.getIcost()));
        itemDao.removeItemUsing(ono);
    }

    public void addItem(Item i){
        itemDao.insertItem(i);
    }
}

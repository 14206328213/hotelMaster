package com.fhx.servicelmp;

import com.fhx.dao.OrderDao;
import com.fhx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServicelmp implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int findrIDby(String cID, int otype) {
        return orderDao.findrIDby(cID,otype);
    }

    @Override
    public String findcIDby(String rID, int otype) {
        return orderDao.findcIDby(rID,otype);
    }

    @Override
    public boolean payOrder(String ono) {
        return orderDao.payOrder(ono);
    }
}

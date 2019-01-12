package com.fhx.servicelmp;


import com.fhx.dao.ItemDao;
import com.fhx.dao.OrderDao;
import com.fhx.dao.RoomDao;
import com.fhx.dao.UserDao;
import com.fhx.entity.Order;
import com.fhx.entity.Room;
import com.fhx.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServicelmp implements RoomService {

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Room> findRooms() {
        return roomDao.findRooms();
    }

    @Override
    public List<Room> findRoomsByStatus(int status) {
        return roomDao.findRoomsByStatus(status);
    }

    @Override
    public int addOrder(Order order) {
        roomDao.updateRoomStatus(Room.ORDER,order.getrID());
         return roomDao.addOrder(order);
    }

    @Override
    public Room findByrID(String rID) {
        return roomDao.findByrID(rID);
    }

    public boolean changeRoomStatus(int status,String rID){
        return roomDao.updateRoomStatus(status,rID);
    }
}

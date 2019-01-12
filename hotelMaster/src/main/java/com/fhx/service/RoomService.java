package com.fhx.service;

import com.fhx.entity.Order;
import com.fhx.entity.Room;

import java.util.List;

public interface RoomService {
    public abstract List<Room> findRooms();
    public abstract List<Room> findRoomsByStatus(int status);
    public abstract int addOrder(Order order);
    public abstract Room findByrID(String rID);
}

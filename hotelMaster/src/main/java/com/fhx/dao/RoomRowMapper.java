package com.fhx.dao;

import com.fhx.entity.Room;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomRowMapper implements RowMapper<Room> {
    @Override
    public Room mapRow(ResultSet rs, int rowNum)throws SQLException {
        Room room=new Room();
        room.setRcost(rs.getFloat("rcost"));
        room.setrID(rs.getInt("rID"));
        room.setRname(rs.getString("rname"));
        room.setStatus(rs.getInt("status"));
        return room;
    }
}

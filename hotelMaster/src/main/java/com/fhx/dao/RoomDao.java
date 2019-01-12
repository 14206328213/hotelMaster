package com.fhx.dao;

import com.fhx.entity.Order;
import com.fhx.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class RoomDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Room> findRooms(){
        String sql="select * from room";
        List<Room> rooms=jdbcTemplate.query(sql, new RoomRowMapper());
        return rooms;
    }

    public List<Room> findRoomsByStatus(int status){
        String sql="select * from room where status =?";
        List<Room> rooms=jdbcTemplate.query(sql,new Object[]{status},new RoomRowMapper());
        return rooms;
    }
    public boolean changeRoomStatus(int status,String rID){
        String sql="update room set status=? where rID=?";
        return jdbcTemplate.update(sql,new Object[]{status,rID})!=0;
    }

    public Room findByrID(String rID){
        String sql="select * from room where rID=?";
        Room room=(Room)jdbcTemplate.queryForObject(sql,new Object[]{rID},new RoomRowMapper());
        return room;
    }
    public int addOrder(Order order){
        String sql="insert into `order`(cID,rID,otype,oTime,day,total,bargain)" +
                "values(?,?,?,?,?,?,?);";

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(order.getOtime()));
        jdbcTemplate.update(sql,new Object[]{order.getcID(),order.getrID(),order.getOtype(),
                sdf.format(order.getOtime()),
                order.getDay(),order.getTotal(),order.getBargin()});
        return findMaxOno();
    }

    private int findMaxOno() {
        String sql = "select max(oNo) from `order`";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    public boolean updateRoomStatus(int status,String riD){
        String sql="update room set status=? WHERE rID=?";
        return jdbcTemplate.update(sql,new Object[]{status,riD})>=1;
    }

}

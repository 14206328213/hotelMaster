package com.fhx.dao;

import com.fhx.entity.Item;
import com.fhx.entity.ItemUsing;
import com.fhx.entity.Order;
import com.fhx.entity.Room;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> findOrdersbyCid(String cid){
        String sql="select * from `order` where cID=?";
        List<Order> orders=jdbcTemplate.query(sql,new Object[]{cid},new OrderRowMapper());
        return orders;
    }

    public List<ItemUsing> findItemsInUse(int ono){
        String sql="SELECT iID,stock,iname,icost,unit,ieTime,iecost,ieday FROM item NATURAL JOIN itememploy where ono=?";
        List<ItemUsing> itemUsings=jdbcTemplate.query(sql, new Object[]{ono},
                new RowMapper<ItemUsing>() {
                    @Override
                    public ItemUsing mapRow(ResultSet resultSet, int i) throws SQLException {
                        ItemUsing itemUsing=new ItemUsing();
                        itemUsing.setIiD(resultSet.getString("iID"));
                        itemUsing.setStock(resultSet.getInt("stock"));
                        itemUsing.setIiD(resultSet.getString("iID"));
                        itemUsing.setIname(resultSet.getString("iname"));
                        itemUsing.setIcost(resultSet.getFloat("icost"));
                        itemUsing.setUnit(resultSet.getString("unit"));
                        itemUsing.setIecost(resultSet.getFloat("iecost"));
                        itemUsing.setIeday(resultSet.getInt("ieday"));
                        return itemUsing;
                    }
                });
        return itemUsings;
    }


    public boolean payOrder(String ono){
        String sql="update `order` set otype=1 where ono=?";
        return jdbcTemplate.update(sql,new Object[]{ono})>=1;
    }

    public boolean isUsingItems(int ono){
        String sql="SELECT count(*) FROM item NATURAL JOIN itememploy where ono=?";
        int i=jdbcTemplate.queryForObject(sql,new Object[]{ono},Integer.class);
        return i!=0;
    }

    public int findrIDby(String cID,int otype){
        String sql="SELECT rID FROM `order` WHERE cID=? AND otype=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{cID,otype},Integer.class);
    }
    public String findcIDby(String rID,int otype){
        String sql="SELECT cID FROM `order` WHERE rID=? AND otype=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{rID, otype}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("cID");
            }
        });
    }

}

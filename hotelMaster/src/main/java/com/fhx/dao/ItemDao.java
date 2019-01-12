package com.fhx.dao;


import com.fhx.entity.Customer;
import com.fhx.entity.Item;
import com.fhx.entity.Order;
import com.fhx.entity.Room;
import com.fhx.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> findItems(){
        String sql="select * from item";
        List<Item> items=jdbcTemplate.query(sql,new ItemRowMapper());
        return items;
    }

    public boolean useItem(Item item, Order order,float iecost){
        String sql="INSERT INTO itememploy(oNo,iecost,ieday,iID,ieTime) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{order.getoNo(),
        iecost,order.getDay(),item.getIiD(), new Time().Date2String(order.getOtime())})>=1;
    }

    public void reduceItemNum(String iID,int num){
        String sql="UPDATE item SET stock=stock-? WHERE iID=?";
        jdbcTemplate.update(sql,new Object[]{num,iID});
    }

    public void addItemNum(String iID,int num){
        String sql="UPDATE item SET stock=stock+? WHERE iID=?";
        jdbcTemplate.update(sql,new Object[]{num,iID});
    }

    public void removeItemUsing(int ono){
        String sql="DELETE FROM itememploy WHERE oNo=?";
        jdbcTemplate.update(sql,new Object[]{ono});

    }

    public void insertItem(Item item){
        String sql="insert into item values (?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{item.getIname(),
        item.getStock(),item.getIiD(),item.getIcost(),item.getUnit()});

    }


}

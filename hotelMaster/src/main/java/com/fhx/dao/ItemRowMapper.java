package com.fhx.dao;

import com.fhx.entity.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemRowMapper implements RowMapper {
    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item=new Item();
        item.setStock(resultSet.getInt("stock"));
        item.setIiD(resultSet.getString("iID"));
        item.setIname(resultSet.getString("iname"));
        item.setIcost(resultSet.getFloat("icost"));
        item.setUnit(resultSet.getString("unit"));
        return item;
    }
}

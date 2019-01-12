package com.fhx.dao;

import com.fhx.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper {
    @Override
    public Order mapRow(ResultSet rs, int i) throws SQLException {
        Order order =new Order();
        order.setoNo(rs.getInt("oNo"));
        order.setcID(rs.getString("cID"));
        order.setrID(rs.getString("rID"));
        order.setOtype(rs.getInt("otype"));
        order.setTotal(rs.getFloat("total"));
        order.setOtime(rs.getTimestamp("oTime"));
        order.setBargin(rs.getFloat("bargain"));
        order.setDay(rs.getInt("day"));
        return order;
    }
}

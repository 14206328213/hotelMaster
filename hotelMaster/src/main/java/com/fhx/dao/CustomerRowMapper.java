package com.fhx.dao;

import com.fhx.entity.Customer;
import com.fhx.entity.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer=new Customer();
        customer.setcID(resultSet.getString("cID"));
        customer.setCname(resultSet.getString("cname"));
        customer.setTel(resultSet.getString("tel"));
        return customer;
    }
}

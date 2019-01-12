package com.fhx.dao;


import com.fhx.entity.Customer;
import com.fhx.entity.Order;
import com.fhx.entity.User;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String uid,String password){
        String sql="select count(*) from user " +
                "where uID=? and password=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{uid,password},
                Integer.class);

    }

    public Customer findCusByUID(String uID){
        String sql="select * from customer where uID=?";
        Customer customer=(Customer)jdbcTemplate.queryForObject(sql,new CustomerRowMapper(),new Object[]{uID});
        return customer;
    }

    //根据id查找用户
    public User findUserByUid(String uID){
        String sql="select * from user where uID=?";
        User user=(User)jdbcTemplate.queryForObject(sql,new UserRowMapper(),new Object[]{uID});
        return user;
    }


    public Customer findCusByCid(String cid){
        String sql="SELECT * FROM `user` NATURAL JOIN customer where cID=?";
        Customer customer=jdbcTemplate.queryForObject(sql, new Object[]{cid}, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer=new Customer();
                customer.setUsername(resultSet.getString("uID"));
                customer.setPassword(resultSet.getString("password"));
                customer.setRole(resultSet.getInt("role"));
                customer.setcID(resultSet.getString("cID"));
                customer.setCname(resultSet.getString("cname"));
                customer.setTel(resultSet.getString("tel"));
                return customer;
            }
        });
        return customer;
    }

    public void insertUser(User user){
        String sql="insert into `user` VALUES(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getPassword(),
        user.getRole()});
    }

    public void inserCus(Customer customer){
        String sql="insert into customer VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{customer.getcID(),
                customer.getCname(),
                customer.getTel(),
                customer.getUsername()});

    }
}

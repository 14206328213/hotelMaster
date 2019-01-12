package com.fhx.dao;

import com.fhx.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setRole(resultSet.getInt("role"));
        user.setPassword(resultSet.getString("password"));
        user.setUsername(resultSet.getString("uID"));
        return user;
    }
}

package com.hanson.dao;

import com.hanson.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void insertUser() {
        User user = new User();
        user.setUsername("Python");
        user.setAge(25);
        String sql = "INSERT INTO tb_user (username, age) \n "//
                + "VALUES \n " //
                + "\t(?, ?) ";//
        jdbcTemplate.update(sql, user.getUsername(), user.getAge());
    }
}

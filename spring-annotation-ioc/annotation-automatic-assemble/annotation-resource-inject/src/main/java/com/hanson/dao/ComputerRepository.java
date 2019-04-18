package com.hanson.dao;

import com.hanson.bean.Computer;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerRepository {

    public void add(Computer computer) {
        System.out.println("新增电脑");
    }
}

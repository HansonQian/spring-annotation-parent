package com.hanson.dao;

import com.hanson.bean.Child;
import org.springframework.stereotype.Repository;

@Repository
public class ChildRepository {
    public void insertChild(Child child) {
        System.out.println("数据库插入一条小孩信息");
    }
}

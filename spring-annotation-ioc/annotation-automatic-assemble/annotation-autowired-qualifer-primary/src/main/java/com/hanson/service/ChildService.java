package com.hanson.service;

import com.hanson.bean.Child;
import com.hanson.dao.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ChildService {

    private String tag;

    @Autowired
    private ChildRepository childRepository;


    public void saveChild(Child child) {
        childRepository.insertChild(child);
    }

    public ChildService() {
    }

    public ChildService(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ChildService{" +
                "tag='" + tag + '\'' +
                ", childRepository=" + childRepository +
                '}';
    }
}

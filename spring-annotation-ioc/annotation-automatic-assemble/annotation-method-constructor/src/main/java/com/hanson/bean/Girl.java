package com.hanson.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Girl {


    @Value("女")
    private String gender;


    private Beauty beauty;


    public Girl() {
    }

    public Beauty getBeauty() {
        return beauty;
    }

    public void setBeauty(Beauty beauty) {
        this.beauty = beauty;
    }

    public Girl(Beauty beauty) {
        this.beauty = beauty;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "gender='" + gender + '\'' +
                '}';
    }
}

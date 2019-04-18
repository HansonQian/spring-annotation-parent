package com.hanson.web;


import com.hanson.bean.Child;
import com.hanson.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ChildController {

    @Autowired(required = false)
    @Qualifier("childService2")
    private ChildService childService;


    public void submitForm(Child child) {
        System.out.println(childService);
    }
}

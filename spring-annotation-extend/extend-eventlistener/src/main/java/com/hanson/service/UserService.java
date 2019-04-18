package com.hanson.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @EventListener(classes = {ApplicationEvent.class})
    public void listener(ApplicationEvent event){
        System.out.println("Uservice....监听到了事件："+event);
    }
}

package com.hanson.web.controller;

import com.hanson.bean.Computer;
import com.hanson.service.ComputerService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

@Controller
public class ComputerController {
    @Inject
    private ComputerService computerService;

    public void add(Computer computer) {
        computerService.save(computer);
    }
}

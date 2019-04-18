package com.hanson.service;

import com.hanson.bean.Computer;
import com.hanson.dao.ComputerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ComputerService {
    @Resource
    private ComputerRepository computerRepository;

    public void save(Computer computer) {
        computerRepository.add(computer);
    }
}

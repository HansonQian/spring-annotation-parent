package com.hanson.service;

import org.springframework.stereotype.Service;

@Service
public class MathCalculatorService {

    /**
     * 除法运算
     *
     * @param i
     * @param j
     * @return
     */
    public int div(int i, int j) {
        return i / j;
    }

}

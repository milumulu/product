package com.milu.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: product
 * @description: 测试
 * @author: 马建鹏
 * @create: 2019-06-04 14:29
 */
@RestController
public class ServiceController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product msg";
    }
}

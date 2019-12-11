package com.wyl.springbootsecond.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    @GetMapping(value = "/echo/second/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery second " + string;
    }
}
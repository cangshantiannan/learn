package com.wyl.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    @GetMapping(value = "/echo/first/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery first :" + string;
    }
}
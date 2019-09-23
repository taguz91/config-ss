package com.shopshopista.jwtp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Johnny
 */
@RestController
@CrossOrigin(origins = "*")
public class TestCTR {
    
    @RequestMapping("/hello")
    public String hello(){
        return "Hellow World";
    }
    
}

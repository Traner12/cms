package com.doc.cms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

    @RequestMapping(value="/hello")
    public String sayHello(){

        return "Hello World";
    }
}

package com.Apidemo.demoapi;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldControler {
    @RequestMapping(method = RequestMethod.GET,path = "/hello-world" )
    public String helloWorld(){
        return "Hello World";


    }
}

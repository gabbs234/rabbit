package com.rabbit.rabbit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
        
    @RequestMapping("/hello")
    public String sayHello() {
        return "yes! gabbs your taskmanager is ready and running";
    }

}

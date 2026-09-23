package com.rabbit.rabbit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
        
    @GetMapping("/hello")
    public String sayHello() {
        return "yes! gabbs your taskmanager is ready and running";
    }

}

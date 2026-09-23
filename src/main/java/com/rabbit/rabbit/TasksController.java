package com.rabbit.rabbit;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TasksController {
    @GetMapping ("/tasks")
        public List<Tasks> getTasks() {
            return List.of(
                new Tasks(1L, "Task 1", false),
                new Tasks(2L, "Task 2", true)
            ); 
        }
    
}

package com.rabbit.rabbit;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
public class TasksController {
    
    private List<Tasks> tasks = new ArrayList<>(List.of(
        new Tasks (1L, "Task 3", false),
        new Tasks (1L, "Task 4", true)
    ));
    
    
    
    @GetMapping ("/tasks")
    public List <Tasks> getTasks(){
        return tasks;
    

        }

        @PostMapping ("/tasks/add")
        public List<Tasks> addTasks(@RequestBody Tasks newTask){
            tasks.add(newTask);
            return tasks;
            
        }
    
}

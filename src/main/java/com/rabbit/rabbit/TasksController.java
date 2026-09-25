package com.rabbit.rabbit;

import java.util.List;
import java.util.ArrayList;

import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
public class TasksController {
    
   private final TaskRepository taskRepository;
   public TasksController(TaskRepository taskRepository){
        this.taskRepository = taskRepository; 
   }
    
    
    @GetMapping ("/tasks")
    public List <Tasks> getTasks(){
        return taskRepository.findAll();
    

        }

        @PostMapping ("/tasks/add")
        public List<Tasks> addTasks(@RequestBody Tasks newTask){
            taskRepository.save(newTask);
            return taskRepository.findAll();
        }
    
}

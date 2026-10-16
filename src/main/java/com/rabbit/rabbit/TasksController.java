package com.rabbit.rabbit;

import java.util.List;
//import java.util.ArrayList;

import org.springframework.security.core.Authentication;
//import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
public class TasksController {
    
   private final TaskRepository taskRepository;
   private final UserRepository userRepository;
   public TasksController(TaskRepository taskRepository, UserRepository userRepository){
        this.taskRepository = taskRepository; 
        this.userRepository = userRepository;
   }
    
   
    @GetMapping ("/tasks")
    public List <Tasks> getTasks(Authentication authentication){
        
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        return taskRepository.findByUser(user);
    

        }

        @PostMapping ("/tasks/add")
        public List<Tasks> addTasks(@RequestBody Tasks newTask, Authentication authentication){
           

            User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
                        
                newTask.setUser(user);
            System.out.println(authentication.getName());

           
            taskRepository.save(newTask);
            return taskRepository.findAll();
            

        }
    
}

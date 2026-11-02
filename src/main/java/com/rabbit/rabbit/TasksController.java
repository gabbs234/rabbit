package com.rabbit.rabbit;

import java.util.List;
//import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
            return taskRepository.findByUser(user);
            

        }
    
        @DeleteMapping ("/tasks/{id}")
        public void deleteTask(@PathVariable Long id, Authentication authentication){
           
            User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
            Tasks task = taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                        
                        if (!task.getUser().getId().equals(user.getId())) {
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }

            taskRepository.delete(task);

        }

        @PutMapping ("/tasks/{id}")
        public Tasks updateTasks(@PathVariable Long id, @RequestBody Tasks updatedTasks, Authentication authentication){

            User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
            Tasks task = taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                        
                        if (!task.getUser().getId().equals(user.getId())) {
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }
            
            task.setTitle(updatedTasks.getTitle());
            task.setDone(updatedTasks.isDone());
            

            return taskRepository.save(task);
        }
}

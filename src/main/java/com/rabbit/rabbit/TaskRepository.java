package com.rabbit.rabbit;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.List;
public interface TaskRepository extends JpaRepository<Tasks, Long> {


        List<Tasks> findByUser(User user); 
}

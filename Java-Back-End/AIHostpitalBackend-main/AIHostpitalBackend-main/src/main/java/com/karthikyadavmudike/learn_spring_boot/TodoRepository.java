package com.karthikyadavmudike.learn_spring_boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}

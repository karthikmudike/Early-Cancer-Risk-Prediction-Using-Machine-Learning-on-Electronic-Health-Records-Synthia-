package com.karthikyadavmudike.learn_spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TodoJpaController {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private TodoRepository todoRepository;
	
	@CrossOrigin
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/jpa/users/{username}/todosupdate/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable int id){
		return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
	}
	
	@CrossOrigin
	@PutMapping("/jpa/users/{username}/todosupdate/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo){
		Todo todo1 = todoService.updateTheList(todo, id);
	    return ResponseEntity.ok(todo1); // Directly returning the entity
	}
	
	@CrossOrigin
	@PostMapping("/jpa/users/{username}/newtodosupdate")
	public ResponseEntity<Todo> newTodo(@PathVariable String username, @RequestBody Todo todo){
		
		todoRepository.save(todo);
		
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoService.updateTheList(todo, -1);.getId()).toUri();
//		
//		return ResponseEntity.created(uri).build();
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	} 
	
	@CrossOrigin
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
		
		Todo todo = todoService.deleteById(id);
		
		if(todo!=null)
		{
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}



}

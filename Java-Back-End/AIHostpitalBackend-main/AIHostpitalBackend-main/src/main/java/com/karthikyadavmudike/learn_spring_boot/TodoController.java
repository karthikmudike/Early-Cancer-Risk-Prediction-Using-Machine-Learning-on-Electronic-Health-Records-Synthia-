//package com.karthikyadavmudike.learn_spring_boot;
//
////import java.net.URI;
//
//import java.util.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@CrossOrigin
//public class TodoController
//{	
//	@Autowired
//	private TodoHardCodedService todoService;
//	
//	@CrossOrigin
//	@GetMapping("/users/{username}/todos")
//	public List<Todo> getAllTodos(@PathVariable String username){
//		System.out.println(todoService.findAll());
//		return todoService.findAll();
//	}
//	
//	@CrossOrigin
//	@GetMapping("/users/{username}/todosupdate/{id}")
//	public Todo getTodo(@PathVariable String username, @PathVariable int id){
//		return todoService.findById(id);
//	}
//	
//	@CrossOrigin
//	@PutMapping("/users/{username}/todosupdate/{id}")
//	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo){	
//		return new ResponseEntity<Todo>(todoService.updateTheList(todo, id), HttpStatus.OK);
//	}
//	
//	@CrossOrigin
//	@PostMapping("/users/{username}/newtodosupdate")
//	public ResponseEntity<Todo> newTodo(@PathVariable String username, @RequestBody Todo todo){
//		
//		todoService.updateTheList(todo, -1);
//		
////		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoService.updateTheList(todo, -1);.getId()).toUri();
////		
////		return ResponseEntity.created(uri).build();
//		
//		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
//	} 
//	
//	@CrossOrigin
//	@DeleteMapping("/users/{username}/todos/{id}")
//	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
//		
//		Todo todo = todoService.deleteById(id);
//		
//		if(todo!=null)
//		{
//			return ResponseEntity.noContent().build();
//		}
//		
//		return ResponseEntity.notFound().build();
//	}
//	
//}
//

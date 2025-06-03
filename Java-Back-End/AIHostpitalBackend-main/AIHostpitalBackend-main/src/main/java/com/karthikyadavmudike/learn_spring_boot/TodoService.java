package com.karthikyadavmudike.learn_spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepo;
	
	public void addTodoList(Todo todo)
	{
		try {
			todoRepo.save(todo);
			System.out.println("Successfull");
		}catch(Exception e)
		{
			System.out.println("Error as occoured "+e);
		}
	}
	
	public Todo updateTheList(Todo todo, int id) {
		
		if(todoRepo.getReferenceById(id)!=null)
		{
			todoRepo.deleteById(id);
			todoRepo.save(todo);
		}else
		{
			todoRepo.save(todo);
		}
		return todo;
	}
	
	public Todo deleteById(int id) 
	{
		Todo todo = todoRepo.getReferenceById(id);
		
		if(todo!=null)
		{
			todoRepo.delete(todo);
			return todo;
		}
		return null;
	}

	
//	static
//	{
//		todos.add(new Todo (1001,"Karthik",new Date(),false));
//	}
//
//
//	public List<Todo> findAll()
//	{
//		return todos;
//	}
//
//	public Todo deleteById(int id) 
//	{
//		Todo todo = findById(id);
//		if(todos.remove(todo))
//		{
//			return todo;
//		}
//		return null;
//	}
//
//	Todo findById(int id) {
//		for(Todo todo: todos)
//		{
//			if(todo.getId() == id)
//			{
//				return todo;
//			}
//		}
//		return null;
//	}
//
//	public Todo requestedForList(int id) {
//		if(todos.get(id) != null)
//		{
//			return todos.get(id);
//		}
//		return null;
//	}
//	
//	public Todo updateTheList(Todo TodoList, int id)
//	{
//		if(this.findById(id)!=null)
//		{
//			todos.remove(this.findById(id));
//			todos.add(TodoList);
//		}else
//		{
//			todos.add(TodoList);
//			}
//		return TodoList;
//	}
//	
}

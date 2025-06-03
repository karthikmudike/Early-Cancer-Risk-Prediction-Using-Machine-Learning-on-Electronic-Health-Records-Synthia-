package com.karthikyadavmudike.learn_spring_boot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
		
	private static List<Todo> todos = new ArrayList<>();
	
	static
	{
		todos.add(new Todo (1001,"Karthik",new Date(),false));
	}


	public List<Todo> findAll()
	{
		return todos;
	}

	public Todo deleteById(int id) 
	{
		Todo todo = findById(id);
		if(todos.remove(todo))
		{
			return todo;
		}
		return null;
	}

	Todo findById(int id) {
		for(Todo todo: todos)
		{
			if(todo.getId() == id)
			{
				return todo;
			}
		}
		return null;
	}

	public Todo requestedForList(int id) {
		if(todos.get(id) != null)
		{
			return todos.get(id);
		}
		return null;
	}
	
	public Todo updateTheList(Todo TodoList, int id)
	{
		if(this.findById(id)!=null)
		{
			todos.remove(this.findById(id));
			todos.add(TodoList);
		}else
		{
			todos.add(TodoList);
			}
		return TodoList;
	}
	
}

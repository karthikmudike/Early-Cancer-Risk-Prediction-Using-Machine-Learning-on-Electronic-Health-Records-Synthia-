package com.karthikyadavmudike.learn_spring_boot;

import java.util.Date;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TODO")
public class Todo {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	
	@Column(name = "target_date")
	private Date targetDate;
	
	@Column(name = "is_done")
	private boolean isDone;
	
	protected Todo()
	{
		
	}
	
	public Todo(int id, String username, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if(id !=other.id)
			return false;
		return true;
	}
	
	
}

package com.example.studentity;

import org.springframework.web.bind.annotation.RestController;

public class Student
{
	private long id;
	
    private String Name;
    
    private int RollCall;
   
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRollCall() {
		return RollCall;
	}
	public void setRollCall(int rollCall) {
		RollCall = rollCall;
	}
	
  
}


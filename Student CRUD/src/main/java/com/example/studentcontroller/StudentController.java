package com.example.studentcontroller;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.studentity.Student;

@RestController
@RequestMapping("/stud")
public class StudentController
{
	
	private Map<Long, Student>studentEntry=new HashMap<>();
	//getting all data list student 
	
	@GetMapping
	public List<Student>getAll()
     {
    	 return new ArrayList<>(studentEntry.values());
     }
	
	//data created by using post mapping
	@PostMapping
	public boolean createEntry(@RequestBody Student myEntry)
	{
		studentEntry.put(myEntry.getId(), myEntry);
		return true;		
	}

	// get data by id
	@GetMapping("id/{myId}")
	public Student getStudentDataById(@PathVariable Long myId)
	{
		return studentEntry.get(myId);
	}
	
	// deleted student by id
	@DeleteMapping("id/{myId}")
	public Student deleteStudentDataById(@PathVariable Long myId)
	{
		return studentEntry.remove(myId);
	}
	// update student by id
	@PutMapping("/id/{id}")
	public Student updateStudentDataById(@PathVariable Long id ,@RequestBody Student myEntry)
	{
		return studentEntry.put(id,myEntry);
	}
	
}
                  
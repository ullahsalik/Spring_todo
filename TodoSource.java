package com.demo.demorest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jackrutorial.model.User;


@Path("Todos")
public class TodoSource {

	TodoRepository repo = new TodoRepository();
	@RequestMapping(value="/List/", method = RequestMethod.GET, headers="Accept=application/json")	
	public List<Todo> getTodos() {
		System.out.println("getList called....");
		return repo.getTodos();
	}
	
	@RequestMapping(value="/List/{id}/", method = RequestMethod.GET, headers="Accept=application/json")
	public Todo getTodo(@PathParam("id") int id){
		return repo.getTodo(id);
	}
	
	@RequestMapping(value="/List/", method = RequestMethod.POST, headers="Accept=application/json")
	public Todo createTodo(Todo s1) {
		System.out.println(s1);
		repo.create(s1);		
		return s1;
	}
	
	 @RequestMapping(value="/update/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
		public Todo updateTodo(Todo s1) {		
		System.out.println(s1);		
		if(repo.getTodo(s1.getId()).getId()==0) {			
			System.out.println("TaskID not found!!!!");
		}
		else
			repo.update(s1);
		return s1;
	}
}


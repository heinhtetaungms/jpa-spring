package com.ace.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import com.ace.ds.Course;
import com.ace.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;
	
	
	@GetMapping("/courses/{id}")
	public Course findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	//produces means send back data to the client
	@GetMapping("/courses")
	public List<Course> courseList() {
		System.out.println("HELLO:::::::::::::::::::MAYSU");
		return service.findAll();
	}
		
	@PostMapping("/courses")
	public ResponseEntity<Course> createCourse(@RequestBody @Valid Course course, BindingResult result) {
		if(!result.hasErrors()) {
			Course savedCourse = service.save(course);
			return ResponseEntity
					.created(URI.create("/courses/"+ savedCourse.getId()))
					.body(savedCourse);
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("Request contains incorect data = [%s]"
					, getErrors(result)));
		}
	}
	//consume means accept data
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> update(@RequestBody @Valid Course course, @PathVariable int id, BindingResult result) {
		if(!result.hasErrors()) {
			if(service.exitsById(id)) {
				course.setId(id);
				Course savedCourse = service.save(course);
				return ResponseEntity.ok(savedCourse);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("Request contains incorect data = [%s]"
							, getErrors(result)));
		}
	}
		
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<Course> delete(@PathVariable Integer id) {
		if(service.exitsById(id)) {
			service.deleteById(id);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	private String getErrors(BindingResult result) {
		return result.getAllErrors().stream()
				.map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(", "));
	}
	
	
}

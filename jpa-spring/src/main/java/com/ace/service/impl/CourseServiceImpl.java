package com.ace.service.impl;

import java.util.List;

import com.ace.dao.CourseRepoistory;
import com.ace.ds.Course;
import com.ace.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepoistory repo;
	
	@Override
	public Course save(Course course) {
		return repo.save(course);
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);;
	}

	@Override
	public Course findById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public Course findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public List<Course> findAll() {
		return repo.findAll();
	}

	@Override
	public Course findByCode(String code) {
		return repo.findByCode(code);
	}

	@Override
	public Boolean exitsById(int id) {
		return repo.existsById(id);
	}
	

	
	

}

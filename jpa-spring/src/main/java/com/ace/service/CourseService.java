package com.ace.service;

import java.util.List;

import com.ace.ds.Course;

public interface CourseService {
	Course save(Course course);
	void deleteById(int id);
	Boolean exitsById(int id);
	Course findById(Integer id);
	Course findByCode(String code);
	Course findByName(String name);
	List<Course> findAll();
}

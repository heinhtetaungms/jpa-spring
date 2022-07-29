package com.ace.service;

import java.util.List;

import com.ace.ds.Student;

public interface StudentService {
	void save(Student student);
	Student findStudentById(int id);
	List<Student> findAll();
	List<Student> findStudentByCourseName(String name);
	void delete(Student student);
}

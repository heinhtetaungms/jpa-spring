package com.ace.service.impl;

import java.util.List;

import com.ace.dao.StudentRepository;
import com.ace.ds.Student;
import com.ace.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;

	@Override
	public void save(Student student) {
		repo.save(student);
	}

	@Override
	public Student findStudentById(int id) {
		return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Student> findStudentByCourseName(String name) {
		return repo.findStudentByCourseName(name);
	}

	@Override
	public void delete(Student student) {
		repo.delete(student);
	}
	

}

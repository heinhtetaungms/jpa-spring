package com.ace.dao;

import com.ace.ds.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepoistory extends JpaRepository<Course, Integer> {
	Course findByCode(String code);
	Course findByName(String name);
}

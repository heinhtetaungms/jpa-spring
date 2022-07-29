package com.ace.dao;

import java.util.List;

import com.ace.ds.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("select s from Student s where s.cousre.name=:name")
	List<Student> findStudentByCourseName(@Param("name") String name);
}

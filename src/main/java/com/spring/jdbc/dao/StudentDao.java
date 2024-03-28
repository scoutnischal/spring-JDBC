package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.student.*;

public interface StudentDao {
	public int insert(Student student);
	
	public int changeInfo(Student student);
	
	public int deleteInfo(int studentId);
	
	public Student getStudent(int studentId);
	
	public List<Student> getMultiStudent();
}

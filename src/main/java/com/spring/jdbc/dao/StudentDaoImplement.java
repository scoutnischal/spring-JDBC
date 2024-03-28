package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.spring.jdbc.student.Student;

@Component("studentDao")
public class StudentDaoImplement implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		//insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}
	
	@Override
	public int changeInfo(Student student) {
		//change the student data as update
		String query = "update student set name=?,city=? where id=?";
		int result = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;
	}
	
	@Override
	public int deleteInfo(int studentId) {
		//delete the student record
		String query = "delete from student where id=?";
		int result = this.jdbcTemplate.update(query,studentId);
		return result;
	}
	
	@Override
	public Student getStudent(int studentId) {
		//select the student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMappingImplement();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}
	
	@Override
	public List<Student> getMultiStudent() {
		// select multiple student data
		String query = "select * from student";
		List <Student> students= this.jdbcTemplate.query(query, new RowMappingImplement());
		return  students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}

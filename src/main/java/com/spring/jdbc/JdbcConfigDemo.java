package com.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.*;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImplement;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JdbcConfigDemo{
	
	@Bean(name={"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/spring_jdbc");
		ds.setUsername("postgres");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean(name={"jdbcTemp"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	
//	for auto wiring
//	@Bean(name={"studentDao"})
//	public StudentDao getStudentDao() {
//		StudentDaoImplement studentDao = new StudentDaoImplement();
//		studentDao.setJdbcTemplate(getTemplate());
//		return studentDao;
//	}

}

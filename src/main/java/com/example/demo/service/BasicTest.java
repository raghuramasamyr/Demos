package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.transaction.Transactional;

@Configuration
public class BasicTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void saveTest() {
	    jdbcTemplate.execute("INSERT INTO SAVEENTITY (id) VALUES ('0001')");
	}

}

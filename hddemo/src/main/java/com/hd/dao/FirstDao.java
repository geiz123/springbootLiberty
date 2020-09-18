package com.hd.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FirstDao {
	@Autowired
	JdbcTemplate jdbcTemp;
	
	public List<Map<String, Object>> getFirstTable() {
		return jdbcTemp.queryForList("SELECT * FROM FIRSTTABLE");
	}
}

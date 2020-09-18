package com.hd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.dao.FirstDao;

@RestController
public class HelloCtrler {
	Logger logger = LoggerFactory.getLogger(HelloCtrler.class);
	
	@Autowired
	@Qualifier("jndiusername")
	String jndiUserName;
	
	@Autowired
	FirstDao firstDao;
	
	@GetMapping(value="/hello", produces = "application/json")
	public List<String> helloWorld() throws NamingException {
		ArrayList<String> ret = new ArrayList<String>();
		ret.add("hello");
		ret.add("world");
		ret.add(jndiUserName + 1);
		
		return ret;
	}
	
	@GetMapping(value="/hello2", produces = "application/json")
	public List<Map<String, Object>> helloWorld2() throws NamingException {
		
		return firstDao.getFirstTable();
	}
	
	
}

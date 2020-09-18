package com.hd.config;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringConfig {
	Logger logger = LoggerFactory.getLogger(SpringConfig.class);
	
	@Bean(name = "jndiusername")
	String getJndiUserName() throws NamingException {
		Object jndiConstant = new InitialContext().lookup("schoolOfAthens/defaultAdminUserName");
		String defaultAdmin = (String) jndiConstant;
		
		return defaultAdmin;
	}
	
	@Bean(name = "dataSource")
    public DataSource dataSource() throws NamingException {
        return (DataSource) 
        		new InitialContext() // The context of the JEE environment
        		.lookup("jdbc/derbyEmbeddedDs");
    }
	
	@Bean
	@DependsOn({"dataSource"})
	public JdbcTemplate getJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) throws NamingException {
		return new JdbcTemplate(dataSource);
	}

}

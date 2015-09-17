package com.homely.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.homely.api.LoginDAO;
import com.homely.jdbc.UserRowMapper;
import com.homely.model.Hello;

public class LoginDAOImpl implements LoginDAO{
@Autowired
DataSource dataSource;
private boolean check=false;
	@Override
	public boolean loginCheckDAO(Hello hello) {
		String query="Select username from localdb.userinfo where username= ?";
		JdbcTemplate jdbctemplate=new JdbcTemplate(dataSource);
		
		Hello hello1=(Hello) jdbctemplate.queryForObject(query, new Object[]{hello.getUser()}, new UserRowMapper());
		if(hello1!=null && hello1.getUser().equals(hello.getUser()))
		{
			check=true;
		}
		return check;
	}

}

package com.homely.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.homely.model.Hello;

public class UserExtractor implements ResultSetExtractor<Hello> {
	public Hello extractData(ResultSet rs) throws SQLException
	{
		Hello hello=new Hello();
		hello.setUser(rs.getString("username"));
		return hello;
	}

}

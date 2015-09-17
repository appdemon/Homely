package com.homely.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.homely.model.Hello;

public class UserRowMapper implements RowMapper<Hello> {
	@Override
	public Hello mapRow(ResultSet rs,int line) throws SQLException
	{
		UserExtractor userextractor=new UserExtractor();
		return userextractor.extractData(rs);
	}

}

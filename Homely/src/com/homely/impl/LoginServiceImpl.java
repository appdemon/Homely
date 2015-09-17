package com.homely.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.api.LoginDAO;
import com.spring.api.LoginService;
import com.spring.model.Hello;

public class LoginServiceImpl implements LoginService {
@Autowired
LoginDAO loginDao;
private boolean check=false;
	@Override
	public boolean loginCheck(Hello hello) {
		check=loginDao.loginCheckDAO(hello);
		return check;
	}

}

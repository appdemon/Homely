package com.homely.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.homely.api.LoginDAO;
import com.homely.api.LoginService;
import com.homely.model.Hello;

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

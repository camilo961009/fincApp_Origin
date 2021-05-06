package com.uniquindio.FincApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniquindio.FincApp.dao.IUserDao;
import com.uniquindio.FincApp.model.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User save(User user) {
	
		return userDao.save(user);
	}

}

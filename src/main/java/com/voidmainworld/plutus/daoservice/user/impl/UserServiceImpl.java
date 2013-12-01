package com.voidmainworld.plutus.daoservice.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voidmainworld.plutus.dao.user.User;
import com.voidmainworld.plutus.dao.user.UserDAO;
import com.voidmainworld.plutus.daoservice.user.UserService;
import com.voidmainworld.plutus.util.AuthUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO	userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Transactional
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Transactional
	public void addUser(User user) {
		user.setPassword(AuthUtil.digest(user.getPassword()));
		userDAO.addUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		user.setPassword(AuthUtil.digest(user.getPassword()));
		userDAO.updateUser(user);
	}

	@Transactional
	public void removeUser(int id) {
		userDAO.removeUser(id);
	}

	@Transactional
	public void removeUser(String username) {
		userDAO.removeUser(username);
	}

}

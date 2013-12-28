package com.voidmainworld.plutus.daoservice.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voidmainworld.plutus.dao.user.User;
import com.voidmainworld.plutus.dao.user.UserDAO;
import com.voidmainworld.plutus.dao.user.auth.UserAuth;
import com.voidmainworld.plutus.dao.user.auth.UserAuthDAO;
import com.voidmainworld.plutus.daoservice.user.UserService;
import com.voidmainworld.plutus.util.AuthUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO		userDAO;
	@Autowired
	private UserAuthDAO	userAuthDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserAuthDAO getUserAuthDAO() {
		return userAuthDAO;
	}

	public void setUserAuthDAO(UserAuthDAO userAuthDAO) {
		this.userAuthDAO = userAuthDAO;
	}

	@Transactional
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Transactional
	public void addUser(User user, String password) {
		userDAO.addUser(user);
		userAuthDAO.addUser(new UserAuth(user.getUsername(), AuthUtil.digest(password)));
	}

	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Transactional
	public void removeUser(String username) {
		userDAO.removeUser(username);
	}

	@Transactional
	public boolean checkAuth(String username, String password) {
		UserAuth user = userAuthDAO.getUser(username);
		if (user != null) {
			return (AuthUtil.digest(password).equals(user.getPassword()));
		}
		return false;
	}

	@Transactional
	public void changePassword(String username, String password) {
		userAuthDAO.updateUser(new UserAuth(username, password));
	}

}

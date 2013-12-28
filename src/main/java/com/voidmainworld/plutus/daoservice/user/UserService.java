package com.voidmainworld.plutus.daoservice.user;

import com.voidmainworld.plutus.dao.user.User;

public interface UserService {

	User getUser(String username);

	void addUser(User user, String password);

	void updateUser(User user);

	void removeUser(String username);

	boolean checkAuth(String username, String password);

	void changePassword(String username, String password);

}

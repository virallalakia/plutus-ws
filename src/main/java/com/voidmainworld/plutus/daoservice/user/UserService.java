package com.voidmainworld.plutus.daoservice.user;

import com.voidmainworld.plutus.dao.user.User;

public interface UserService {

	User getUser(int id);

	User getUser(String username);

	void addUser(User user);

	void updateUser(User user);

	void removeUser(int id);

	void removeUser(String username);
}

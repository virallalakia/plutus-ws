package com.voidmainworld.plutus.dao.user;

public interface UserDAO {

	User getUser(int id);

	User getUser(String username);

	void addUser(User user);

	void updateUser(User user);

	void removeUser(int id);

	void removeUser(String username);

}

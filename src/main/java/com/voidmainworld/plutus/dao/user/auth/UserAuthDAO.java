package com.voidmainworld.plutus.dao.user.auth;

public interface UserAuthDAO {

	UserAuth getUser(String username);

	void addUser(UserAuth user);

	void updateUser(UserAuth user);

	void removeUser(String username);

}

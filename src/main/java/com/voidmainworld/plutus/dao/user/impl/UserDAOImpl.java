package com.voidmainworld.plutus.dao.user.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.voidmainworld.plutus.dao.user.User;
import com.voidmainworld.plutus.dao.user.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final String	SELECT_USER_BY_USERNAME	= "from User where username=:username";
	private static final String	DELETE_USER_BY_USERNAME	= "DELETE from User where username=:username";

	@Autowired
	private SessionFactory		sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUser(int id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
		if (null != user) {
			Hibernate.initialize(user);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public User getUser(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(SELECT_USER_BY_USERNAME);
		query.setParameter("username", username);
		List<User> users = query.list();
		if (users.size() > 0) {
			User user = users.get(0);
			Hibernate.initialize(user);
			return user;
		}
		return null;
	}

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void removeUser(int id) {
		User user = getUser(id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	public void removeUser(String username) {
		if (null != getUser(username)) {
			Query query = sessionFactory.getCurrentSession().createQuery(DELETE_USER_BY_USERNAME);
			query.setParameter("username", username);
			query.executeUpdate();
		}
	}
}

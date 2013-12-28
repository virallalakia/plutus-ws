package com.voidmainworld.plutus.dao.user.auth.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.voidmainworld.plutus.dao.user.auth.UserAuth;
import com.voidmainworld.plutus.dao.user.auth.UserAuthDAO;

@Repository
public class UserAuthDAOImpl implements UserAuthDAO {

	private static final String	SELECT_USER_BY_USERNAME	= "from UserAuth where username=:username";
	private static final String	DELETE_USER_BY_USERNAME	= "DELETE from UserAuth where username=:username";

	@Autowired
	private SessionFactory		sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public UserAuth getUser(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(SELECT_USER_BY_USERNAME);
		query.setParameter("username", username);
		List<UserAuth> users = (List<UserAuth>) query.list();
		if (users.size() > 0) {
			UserAuth user = users.get(0);
			Hibernate.initialize(user);
			return user;
		}
		return null;
	}

	public void addUser(UserAuth user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void updateUser(UserAuth user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void removeUser(String username) {
		if (null != getUser(username)) {
			Query query = sessionFactory.getCurrentSession().createQuery(DELETE_USER_BY_USERNAME);
			query.setParameter("username", username);
			query.executeUpdate();
		}
	}
}

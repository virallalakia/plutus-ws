package com.voidmainworld.plutus.dao.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer	id;

	@Column(name = "USERNAME")
	private String	username;

	@Column(name = "CREATED_DATE")
	@GeneratedValue
	private Date	createdDate;

	@Column(name = "UPDATED_DATE")
	@GeneratedValue
	private Date	updatedDate;

	private User() {
		super();
	}

	public User(String username) {
		this();
		this.username = username;
	}

	public User(Integer id, String username) {
		this(username);
		this.id = id;
	}

	public User(Integer id, String username, Date createdDate, Date updatedDate) {
		this(id, username);
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
				.append("User [id=")
				.append(id)
				.append(", username=")
				.append(username)
				.append(", createdDate=")
				.append(createdDate)
				.append(", updatedDate=")
				.append(updatedDate)
				.append("]");
		return builder.toString();
	}
}

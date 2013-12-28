package com.voidmainworld.plutus.dao.user.auth;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_AUTH")
public class UserAuth {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer	id;

	@Column(name = "USERNAME")
	private String	username;

	@Column(name = "PASSWORD")
	private String	password;

	@Column(name = "CREATED_DATE")
	@GeneratedValue
	private Date	createdDate;

	@Column(name = "UPDATED_DATE")
	@GeneratedValue
	private Date	updatedDate;

	private UserAuth() {
		super();
	}

	public UserAuth(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}

	public UserAuth(Integer id, String username, String password, Date createdDate, Date updatedDate) {
		this(username, password);
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

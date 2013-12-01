package com.voidmainworld.plutus.vo.user;

import com.voidmainworld.plutus.vo.DataVOI;

public class UserVO implements DataVOI {

	private static final long	serialVersionUID	= 7456046476491395764L;

	private int					id;
	private String				username;
	private String				password;
	private long				createdDate;
	private long				updatedDate;

	public UserVO() {
		super();
	}

	public UserVO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserVO(int id, String username, String password, long createdDate, long updatedDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	public long getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(long updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
				.append("UserVO [id=")
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

package com.lina.chat.app.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
	private long userroleid;

	@Column(name = "userid")
	private long userid;

	@Column(name = "role")
	private String role;

	public long getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(long userroleid) {
		this.userroleid = userroleid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

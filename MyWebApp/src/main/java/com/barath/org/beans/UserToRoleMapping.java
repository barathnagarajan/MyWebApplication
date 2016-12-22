package com.barath.org.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_TO_ROLE_MAPPING")
public class UserToRoleMapping 
{
	@Id
	@Column(name="MAPPING_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mappingId;
	@OneToOne
	@JoinColumn(name="USER_ID",nullable=false)
	private Users users;
	@OneToOne 
	@JoinColumn(name="ROLE_ID",nullable=false)
	private Role roles;
	
	public int getMappingId() {
		return mappingId;
	}
	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserToRoleMapping [mappingId=" + mappingId + ", users=" + users + ", roles=" + roles + "]";
	}
}

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
@Table(name="ROLE_TO_PERMISSION_MAPPING")
public class RoleToPermissionMapping 
{
	@Id
	@Column(name="MAPPING_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mappingId;
	@JoinColumn(nullable=false,name="ROLE_ID")
	@OneToOne
	private Role role;
	@JoinColumn(nullable=false,name="PERMISSION_ID")
	@OneToOne
	private Permission permission;
	
	public int getMappingId() {
		return mappingId;
	}
	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "RoleToPermissionMapping [mappingId=" + mappingId + ", role=" + role + ", permission=" + permission
				+ "]";
	}
}

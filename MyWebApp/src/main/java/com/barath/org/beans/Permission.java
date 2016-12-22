package com.barath.org.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERMISSIONS")
public class Permission 
{
	@Id
	@Column(name="PERMISSION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int permissionId;
	@Column(name="PERMISSION_NAME")
	private String permissionName;
	@Column(name="PERMISSION_DESC")
	private String permissionDesc;
	
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionDesc() {
		return permissionDesc;
	}
	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}
	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName + ", permissionDesc="
				+ permissionDesc + "]";
	}
	
}

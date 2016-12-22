package com.barath.org.dao;

import java.sql.SQLException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO 
{
	public boolean isValidUser(String username, String password) throws SQLException;
	public UserDetails loadUserByUsername(String username);
}

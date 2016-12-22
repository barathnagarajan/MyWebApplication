package com.barath.org.service;

import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public interface UserService 
{
	public boolean isValidUser(String username, String password) throws SQLException;
}

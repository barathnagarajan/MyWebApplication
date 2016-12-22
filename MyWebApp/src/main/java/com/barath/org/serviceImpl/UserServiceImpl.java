package com.barath.org.serviceImpl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.barath.org.dao.LoginDAO;
import com.barath.org.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public boolean isValidUser(String username, String password) throws SQLException
	{
		boolean result = loginDAO.isValidUser(username, password);
		if(result == true)
		{
			
		}
		return result;
	}

}

package com.barath.org.delegate;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.barath.org.serviceImpl.UserServiceImpl;

@Component
public class LoginDelegate 
{
  @Autowired
  private UserServiceImpl userService;

  public boolean isValidUser(String username, String password) throws SQLException
  {
      return userService.isValidUser(username, password);
  }
}

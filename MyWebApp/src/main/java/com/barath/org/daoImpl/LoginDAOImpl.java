package com.barath.org.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.barath.org.beans.UserToRoleMapping;
import com.barath.org.beans.Users;
import com.barath.org.dao.LoginDAO;

@Transactional
@Repository
public class LoginDAOImpl implements LoginDAO,UserDetailsService
{
	@Autowired
	private HibernateTemplate template;
	
	@Override
	public boolean isValidUser(String username, String password) throws SQLException 
	{
		Session session = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Users where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		int matchedResults = query.list().size();
		if(matchedResults > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Session session = template.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Users where username = :username");
		query.setParameter("username", username);
		Users users = (Users)query.uniqueResult();
		List<UserToRoleMapping> mapping = session.createQuery("from UserToRoleMapping where users = :users").setParameter("users", users).list();
		List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		Iterator<UserToRoleMapping> itr = mapping.iterator();
		while(itr.hasNext())
		{
			UserToRoleMapping userToRoleMapping = (UserToRoleMapping)itr.next();
			if(null != userToRoleMapping.getRoles())
			{
				roles.add(new SimpleGrantedAuthority(userToRoleMapping.getRoles().getRoleName()));
			}
		}
		UserDetails user = new User(users.getUsername(), users.getPassword(), true, true, true, true, roles);
		return user;
	}
}

package com.barath.org.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController 
{
	
	@RequestMapping(value="/accessdenied",method=RequestMethod.GET)
    public ModelAndView accessDenied(HttpServletRequest request, HttpServletResponse response)
	 {
	     return new ModelAndView("indexPluginPages/page_403");
    }
	
	@RequestMapping(value="/loadLoginPage",method=RequestMethod.GET)
    public ModelAndView loadLoginPage(HttpServletRequest request, HttpServletResponse response)
	 {
	     return new ModelAndView("login");
    }
	
	@RequestMapping(value="/",method=RequestMethod.GET)
    public ModelAndView loadIndexPage(HttpServletRequest request, HttpServletResponse response)
	 {
		return new ModelAndView("index");
    }
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
	 {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return new ModelAndView("login");
    }
	
	@RequestMapping(value="/getHomePage",method=RequestMethod.GET)
    public ModelAndView getHomePage(HttpServletRequest request, HttpServletResponse response)
	 {
	    return new ModelAndView("home/homePage");
    }
	
	@RequestMapping(value="/getCustomers",method=RequestMethod.GET)
    public ModelAndView getCustomers(HttpServletRequest request, HttpServletResponse response)
	 {
	    return new ModelAndView("customers/customers");
    }
}

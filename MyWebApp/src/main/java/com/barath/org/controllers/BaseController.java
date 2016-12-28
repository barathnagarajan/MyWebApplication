package com.barath.org.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.barath.org.beans.Users;

@Controller
public class BaseController {

	private static final Logger logger = Logger.getLogger(BaseController.class);
	private static int counter = 0;
	private static final String VIEW_INDEX = "index";

	@RequestMapping(value = "/comes", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}"+counter);
		System.out.println("comes here 1");
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap model) {
		logger.debug("[welcomeName] login : {}");
		System.out.println("comes here 2");
		model.addAttribute("loginBean", new Users());
		return "login";
	}*/
}
package com.sf.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sf.bean.User;

@Controller
@RequestMapping(value="/user")
@SessionAttributes("user")
public class UserController {

	private List<User> users = null;
	public UserController() {
		// TODO Auto-generated constructor stub
			users = new ArrayList<User>();
	}
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/registerForm",method=RequestMethod.GET) 
	public String registerForm(){
		log.info("registerForm登录.....");

		return "registerForm";
	}
	//该方法接受注册
	@RequestMapping(value="/register")
	public String register( @RequestParam("loginname")String loginname,
							@RequestParam("username")String username,
							@RequestParam("password")String password){
	User user = new User();
	user.setLoginname(loginname);
	user.setPassword(password);
	user.setUsername(username);
	users.add(user);
	return "loginForm";
		
	}
	
	//该方法接受登录
	@RequestMapping("/login")
	public String login(@RequestParam("loginname")String loginname,
						@RequestParam("password")String password,
						Model model){
							for(User user: users){
								if(user.getLoginname().equals(loginname) && user.getPassword().equals(password)){
									model.addAttribute("user", user);
									return "welcome";
								}
							}
							return "loginForm";		
	}
}

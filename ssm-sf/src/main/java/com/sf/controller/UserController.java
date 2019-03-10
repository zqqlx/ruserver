package com.sf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.sf.bean.Person;
import com.sf.bean.User;
import com.sf.service.UserService;

/**
 * @author zqq
 * @date 2018年6月23日 下午5:19:10
 * 
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired 
	private UserService userService;
	public static List<User> userList = new ArrayList<User>();

	@RequestMapping(value="/registerForm", method=RequestMethod.GET)
	public String registerForm(){
		return "registerForm";
		
	}
	@RequestMapping(value="/inputForm")
	public String inputForm(Model model){
		Person p = new Person();
		p.setName("zqq");
		p.setSex("M");
		p.setAge(12);
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("math");
		List<String> courseList = new ArrayList<String>();
		courseList.add("java");
		courseList.add("math");
		courseList.add("fdas");
		p.setCourse(list);
		model.addAttribute("user",p);
		model.addAttribute("courseList",courseList);
		
		return "inputForm";
	}
	@RequestMapping(value="/register")
	public String register(@RequestParam("loginname")String loginname,
			@RequestParam("password") String password,
			@RequestParam("username") String username, Model model){
		User user = new User();
		user.setUserId(null);
		user.setLoginname(loginname);
		user.setPassword(password);
		user.setUsername(username);
		userService.saveUserByLoginName(user);
		model.addAttribute("user", user);
		return "loginForm";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("loginname") String loginname,
			@RequestParam("password")String password, Model model){
		//查找数据库中指定的用户
		User user = userService.findIndexUserByLoginname(loginname);
		if(user != null && user.getPassword().equals(password)){
			model.addAttribute("user",user);
			return "welcome";
		}
	
		return "error";
	}
	
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName,String request_locale, Model model, HttpServletRequest request){
		if(request_locale != null){
			//设置中文环境
			if(request_locale.equals("zh_CN")){
				Locale locale = new Locale("zh", "CN");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			}else if(request_locale.equals("en_US")){
				Locale locale = new Locale("en", "US");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			}else{
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
			}
		}
		User user = new User();
		model.addAttribute("user", user);
		return formName;
	}
	
//	@RequestMapping(value="/{formName}")
//	public String loginForm1(@PathVariable String formName, String request_locale, Model model, HttpServletRequest request, HttpServletResponse response){
//		if(request_locale != null){
//			if(request_locale.equals("zh_CN")){
//				Locale locale = new Locale("zh","CN");
//				(new CookieLocaleResolver()).setLocale(request, response, locale);
//			}else if(request_locale.equals("en_US")){
//				Locale locale = new Locale("en","US");
//				(new CookieLocaleResolver()).setLocale(request, response, locale);
//			}else{
//				(new CookieLocaleResolver()).setLocale(request, response, LocaleContextHolder.getLocale());;
//			}
//		}
//		User user = new User();
//		model.addAttribute("user",user);
//		return formName;
//	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(@ModelAttribute @Validated User user, Model model, HttpServletRequest request){
//		RequestContext requestContext = new RequestContext(request);
//		String username = requestContext.getMessage("loginname");
//		user.setUsername(username);
//		model.addAttribute("user", user);
//		return "welcome";
//	}
}

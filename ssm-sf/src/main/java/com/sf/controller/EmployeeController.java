package com.sf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sf.bean.Employee;
import com.sf.service.EmployeeService;
/**
 * 处理员工增删改查
 * @author Administrator
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@RequestMapping("/emps") 
	public String getEms(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model){
		PageHelper.startPage(pn, 5);
		//startPage紧跟的查询是分页查询
		List<Employee> emps = employeeService.getAll();
		//使用pageInfo包装查询的内容,只需将pageInfo交给页面,封装详细的分页信息
		PageInfo<Employee> page  = new PageInfo<Employee>(emps, 5);
		model.addAttribute("pageInfo",page);
		return "list";
	}
}

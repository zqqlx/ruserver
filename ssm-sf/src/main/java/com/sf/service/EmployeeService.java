package com.sf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.bean.Employee;
import com.sf.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	public List<Employee> getAll(){
		return employeeMapper.selectByExampleWithDept(null);
	}
}

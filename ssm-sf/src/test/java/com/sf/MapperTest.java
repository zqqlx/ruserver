package com.sf;

import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sf.bean.Department;
import com.sf.bean.Employee;
import com.sf.dao.DepartmentMapper;
import com.sf.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	private static Logger logger = Logger.getLogger(MapperTest.class);
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Test
	public void testCRUD(){
//		departmentMapper.insert(new Department(null,"sf1"));
//		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//		Random r = new Random();
//		String[]sex = new String[2];
//		sex[0] = "M";
//		sex[1] = "G";
//		String []name = new String[3];
//		name[0] = "zqq";
//		name[1] = "lx";
//		name[2] = "luo";
//		for(int i =0; i < 1000; i ++){
//			employeeMapper.insertSelective(new Employee(null,name[r.nextInt(3)],sex[r.nextInt(2)],name[r.nextInt(3)]+"1123@qq.com",1));
//		}
//		System.out.println("批量完成");
		
	}
	
	
}

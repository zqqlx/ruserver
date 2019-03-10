package com.sf;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sf.bean.User;
import com.sf.dao.UserMapper;
import com.sf.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	private static Logger logger = Logger.getLogger(MapperTest.class);
	@Autowired
	private SqlSession sqlSession;
	
//	@Autowired
//	private DepartmentMapper departmentMapper;
//	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	@Test
	public void testCRUD(){
		User user = new User();
		user.setUserId(null);
		user.setLoginname("zm4 ");
		user.setPassword("abc1");
		user.setUsername("zqq1");
		//int result = userMapper.insertSelective(user);
	//	System.out.println("result: " + result);
		//int ret = userService.saveUserByLoginName(user);
		//System.out.println("result: " + ret);
	}
	
	
}

package cn.itcast.mybatis.test;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.dao.impl.UserDaoImpl;
import cn.itcast.mybatis.pojo.User;

public class UserDaoTest {
	SqlSessionFactory sqlSessionFactory= null;
	
	@Before
	public void init() throws Exception{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
	}
	
	@Test
	public void testFindUserById(){
		UserDao userDao  =  new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(30);
		System.out.println(user);
	}
	@Test
	public void testInsertUser(){
		UserDao userDao  =  new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setAddress("黑风洞");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("黑风怪");
		userDao.insertUser(user);
		System.out.println(user);
	}
}

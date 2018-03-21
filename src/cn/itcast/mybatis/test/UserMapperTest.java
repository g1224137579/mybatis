package cn.itcast.mybatis.test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.util.SecuritySupport;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.pojo.User;

public class UserMapperTest {

	SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() throws Exception {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
	}

	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(28);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testInsert() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setUsername("张三" + i);
			user.setSex("男");
			user.setBirthday(new Date());
			user.setAddress("北京");
			userList.add(user);
		}
		Long timeBefore = System.currentTimeMillis();
		int count = userMapper.insertUserList(userList);
		Long timeAfter = System.currentTimeMillis();
		Long time = timeAfter - timeBefore;
		System.out.println("count:" + count + "&&time:" + time);//10000:28055 1000:642 100:285
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testInsertOne() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		long timeBefore = 0L;
		long timeAfter = 0L;
		long time = 0L;
		for(int i = 0; i < 100; i++) {
			User user = new User();
			user.setUsername("张三2");
			user.setSex("男");
			user.setBirthday(new Date());
			user.setAddress("北京");
			timeBefore = System.currentTimeMillis();
			userMapper.insertUser(user);
			timeAfter = System.currentTimeMillis();
			time = time + ( timeAfter - timeBefore );
		}
		System.out.println("time:" + time);//10000:3563 1000:861 100:341
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testInsetList() {
		List<User> userList = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			User user = new User();
			//user.setTablename("user");
			user.setUsername("张三");
			user.setSex("男");
			user.setBirthday(new Date());
			user.setAddress("北京");
			userList.add(user);
		}
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		/*User user = new User();
		user.setUsername("张三");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("北京");
		userMapper.insert(user);*/
		userMapper.insertUserList(userList);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testCount() {
		float f = 2F / 25;
		System.out.println(f);
	}
}

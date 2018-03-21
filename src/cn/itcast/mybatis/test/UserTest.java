package cn.itcast.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import cn.itcast.mybatis.pojo.User;

public class UserTest {
	SqlSessionFactory sqlSessionFactory= null;
	@Before
	public void init() throws Exception{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(Resources.getResourceAsStream("sqlMapConfig.xml"));
	}

	@Test
	public void testFindUserById() throws Exception{
//		1、通过sqlMapConfig.xml创建sqlSessionFactory
//		创建sqlSessionFactory需要用到SqlSessionFactoryBuilder
		
//		2、使用sqlSessionFactory创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
//		3、使用sqlSession执行查询
//		p1:statementId  p2:传入的参数
		User user = sqlSession.selectOne("findUserById", 10);
//		4、打印结果
		System.out.println(user);
//		5、sqlSession关闭
		sqlSession.close();
	}
	
	
	@Test
	public void testFindUserByUsername() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User>  users = sqlSession.selectList("findUserByUsername", "张");
		System.out.println(users);
		sqlSession.close();
	}
	
	@Test
	public void testInsertUser() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setAddress("火云洞");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("红孩儿");
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
		System.out.println(user);
		sqlSession.close();

	}
	
	@Test
	public void testUpdateUser() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(30);
		user.setAddress("翠云山芭蕉洞");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setUsername("铁扇公主");
		sqlSession.update("updateUser", user);
		sqlSession.commit();
		System.out.println(user);
		sqlSession.close();
		
	}
	
	@Test
	public void testDeleteUser() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("deleteUser", 26);
		sqlSession.commit();
		sqlSession.close();
		int[] array = new int[100];
	}
	
	@Test
	public void testList() {
		List<String> strList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String str = "hello";
			List<String> strList2 = write(str, strList, i);
			//System.out.println(strList2.size());
		}
		System.out.println(strList.size());
	}
	
	public List<String> write(String str, List<String> strList, int i) {
		strList.add(str);
		return strList;
	}
	
	
	
	
}

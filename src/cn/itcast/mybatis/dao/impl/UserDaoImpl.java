package cn.itcast.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory  sqlSessionFactory = null;
	
	public UserDaoImpl(SqlSessionFactory  sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = null;
		try {
			user = sqlSession.selectOne("findUserById", id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return user;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

}

package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

public interface UserMapper {

	public User findUserById(int id);
	
	public int insert(User user);
	
	public int insertUser(User user);
	
	public int insertUserList(List<User> userList);
}

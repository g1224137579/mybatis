package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserJdbc {

	public static void main(String[] args) throws Exception {
//	   加载驱动
		Class.forName("com.mysql.jdbc.Driver");
//	     获取连接
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "root");
//	      获取预处理
		PreparedStatement stmt = connection.prepareStatement("select * from user where id=?");
//	      设置参数
		stmt.setInt(1, 10);
//	      执行
		ResultSet rs = stmt.executeQuery();
//	      获取结果
		while(rs.next()){
			System.out.println(rs.getInt(1)+rs.getString(2));
		}
//	      关闭资源
		rs.close();
		stmt.close();
		connection.close();

	}

}

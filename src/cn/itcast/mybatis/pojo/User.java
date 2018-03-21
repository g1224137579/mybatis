package cn.itcast.mybatis.pojo;

import java.util.Date;

public class User {
	//private String tablename;
	private int id; 
	private String username;  
	private Date birthday;  
	private String sex;  
	private String address;
	
	public User() {
		super();
	}
	public User(int id, String username, Date birthday, String sex, String address) {
		super();
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}
	@Override
	public String toString() {
		return "打印结果：User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}
	
	/*public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

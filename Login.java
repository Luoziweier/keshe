package com;

import java.sql.Connection;
import  com.JdbcUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author 沉睡的芭芭拉
 */
public class Login implements Idao {

	String id;
	String name;
	String password;
	Admin admin;
	Login(String id,String name,String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	void setAdmin(Admin admin) {
		this.admin=admin;
	}

	@Override
	public void register() {
		String sql="insert into admin (id, name, password) values (?,?,?)";
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.id);
			ps.setString(2, this.name);
			ps.setString(3, this.password);
			ps.executeUpdate();
			ps.close();
			conn.close();
			System.out.println("添加用户成功");
		}catch(SQLException ex) {
			System.out.println(ex);
		}
	}

	/**
	 * JudgeAdmin()方法
	 * 判断Admin的ID和密码是否正确，如果正确，显示登录成功
	 * 如果错误，弹出一个窗口，显示账号或密码错误
	 */

	 @Override
	 public boolean login(Admin admin) throws SQLException {
	    	String sql="select * from admin where id=? and password=?";

	    	Connection conn = JdbcUtils.getConnection();
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	
	        ps.setString(1, admin.getId());
	        ps.setString(2, admin.getPassword());
	        ResultSet rs = ps.executeQuery();
	        int ans = 0;
	        if(rs.next()) {
	        	ans = 1;
	        }  
	        rs.close();
	        ps.close();
	        conn.close();
	        if(ans == 1) {
	        	return true;
	        }
	        else {
				return false;
			}
	    }
	@Override
	public int judgeAdmin() {
		
		    try {
		        if(login(this.admin)) {
		        	System.out.println("登录成功");
		        	return 1;
		        }else {
		            return 0;
		        }
		    }catch(Exception e) {
		    }
		return 0;
		
	}	
}




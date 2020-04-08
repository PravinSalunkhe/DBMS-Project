package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import com.minipro.model.User;

public class profile_dao {
	
	public profile_dao() {
        super();
        // TODO Auto-generated constructor stub
    }


Connection con ;
Statement stm,stm2;  ResultSet rs;
PreparedStatement pstm;

public void connect()
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost/event_management";
		String uname="root";
		String passw="Pravin@271999";
		con = DriverManager.getConnection(url,uname,passw);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
	} 
}

public User get_user(int uid,int uno) throws SQLException
{
	
	 
	 connect();
	 
	 
	 String sql = "select ud.first_name,ud.last_name,ud.email,user.pwd,user.user_role,ud.mobileno,ud.org from user,user_details ud where user.uid=" +uid+ " and ud.user_no=" +uno ; 
	 stm = con.createStatement();
	    rs = stm.executeQuery(sql);
	    
	    
	    rs.next();
	    
	    	String fname = rs.getString(1);
	    	String lname = rs.getString(2);
	    	String email = rs.getString(3);
	    	String pwd = rs.getString(4);
	    	String role = rs.getString(5);
	    	long mob = rs.getLong(6);
	    	String org = rs.getString(7);
	    User	u = new User(fname,lname,email,pwd,role,mob,org);
	    	
	   con.close(); stm.close(); rs.close(); 	
	    
	return u;
}


public void update_user(int uid,int uno,User u) throws SQLException
{

	 
	 connect();
	 
	 System.out.println(u);
	 
	 String sql = " update user set pwd ='" + u.getPwd() +"' where uid=" +uid;
	 System.out.println(sql);
	 stm = con.createStatement();
	 stm.executeUpdate(sql);
	
	 sql="";
	 sql = " update user_details set first_name='"+u.getFirstName()+"',last_name='"+u.getLastName()+"',mobileno='"+u.getMobileno()+"',org='"+u.getOrganization()+"' where user_no="+uno;
	 System.out.println(sql);
	 stm2 = con.createStatement();
	 stm2.executeUpdate(sql);
	  con.close(); stm.close(); stm2.close(); rs.close(); 
	 
}

}






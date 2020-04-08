package com.minipro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class login_dao{
	
    public login_dao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	
	

	public int[] check_login(String uname, String pw,String role) throws ClassNotFoundException, SQLException 
	{
		System.out.println("YES\n");
		
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost/event_management";
			String usname="root";
			String passw="Pravin@271999";
			Connection con = DriverManager.getConnection(url,usname,passw);
			
		
		String sql = "select user.uid,user_details.user_no from user,user_details where "
				+ "'" + uname +  "'" + "=user_details.email and user.pwd="
				+  "'" + pw +  "'" +" and user_details.user_no=user.user_no and user.user_role='" + role +"'" ;
		System.out.println(sql);
		
		Statement stm = con.createStatement();
		
		
		System.out.println("\n hi,dao 2  ");

		
	   
			ResultSet rs = stm.executeQuery(sql);
		
    	int[] a = new int[2];
    	a[0]=-1; a[1]=-1; 
		System.out.println("\n hi,dao 1 "+a[0]+" "+a[1]);

	  
			if(rs.next())
			{
				a[0]=Integer.parseInt(rs.getString("uid"));
				a[1]=Integer.parseInt(rs.getString("user_no"));
			}
	
	    
	    
		System.out.println("\n hi,dao "+a[0]+" "+a[1]);

	    
		return a; 	
	    
	}

}

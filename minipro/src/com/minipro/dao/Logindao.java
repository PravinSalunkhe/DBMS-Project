package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logindao
{
	public int[] checklogin(String email,String pwd1,String role)
	{
		Connection con=null;
		PreparedStatement s=null;
		int[] a = new int[2];
		a[0] = a[1] = -1;
		try
		{
			//System.out.println(email + " " + pwd1 + " " + role);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			s=con.prepareStatement("select * from user_details where email=?");
			s.setString(1, email);
			ResultSet myRs=s.executeQuery();
			if(myRs.next())
			{
				int uno=myRs.getInt("user_no");
				System.out.println("uno " + uno);
				s=con.prepareStatement("select * from user where user_no=? and pwd=? and user_role=?");
				s.setInt(1,uno);
				s.setString(2,pwd1);
				s.setString(3, role);
				myRs=s.executeQuery();
				if(myRs.next())
				{
					a[0]=Integer.parseInt(myRs.getString("uid"));
			    	a[1]=Integer.parseInt(myRs.getString("user_no"));
					return a;
				}
			}
			System.out.println("no found");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return a;	
	}

}
package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.minipro.model.User;



public class Registerformdao 
{
	private int temp;

	public void insert_user(User u)
	{
		Connection con=null;
		//Statement myStmt = null;
		ResultSet myRs = null;
		PreparedStatement s=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			String sql0="select * from user_details where email=? and mobileno=?";
			s = con.prepareStatement(sql0);
			s.setString(1, u.getEmail());
			s.setLong(2,u.getMobileno());
			myRs=s.executeQuery();
			if(myRs.next())
			{
				System.out.println("already existing as either host or participant");
			}
			else
			{	
				String sql1 = new String();
				if(u.getRole()=="Host")
				{
				 sql1=	"insert into user_details "
						   + "(email,first_name, last_name, mobileno,org) "
						   + "values (?, ?, ? ,? ,? )";
				}
				else
				{
					 sql1=	"insert into user_details "
							   + "(email,first_name, last_name, mobileno) "
							   + "values (?, ?, ? ,? )";
				}
				System.out.println(u.toString());
				s = con.prepareStatement(sql1);
				s.setString(1, u.getEmail());
				s.setString(2, u.getFirstName());
				s.setString(3,u.getLastName());
				s.setLong(4,u.getMobileno());
				
				if(u.getRole()=="Host")
				s.setString(5,u.getOrganization());
				
				s.execute();
				//myStmt = con.createStatement();
			}

			s=con.prepareStatement("select user_no from user_details where email = ? and mobileno = ?");
			s.setString(1, u.getEmail());
			s.setLong(2, u.getMobileno());
			myRs=s.executeQuery();
			if(myRs.next())
			{
				temp=myRs.getInt("user_no");
			}
			String sql2=	"insert into user "
					   + "(user_role,pwd,user_no) "
					   + "values (? , ? ,?)";
			s = con.prepareStatement(sql2);
			s.setString(1, u.getRole());
			s.setString(2, u.getPwd());
			s.setInt(3, temp);
			s.execute();
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	}

}


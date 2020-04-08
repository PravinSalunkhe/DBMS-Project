package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Notification;
import com.minipro.model.Sport;

public class Notificationsdao 
{
	public List<Notification> create_notifi(int pid)
	{
		List<Notification> s= new ArrayList<Notification>();
		Connection con=null;
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select * from notification where pid=? order by id desc limit 20");
			p.setInt(1, pid);
			
			ResultSet rs=null;
			rs=p.executeQuery();
			System.out.print("while");
			while(rs.next())
			{
				System.out.print("while");
				Notification t= new Notification();
				t.setId(rs.getInt("id"));
				t.setPid(rs.getInt("pid"));
				t.setNote(rs.getString("note"));
				t.setN_date(rs.getString("n_date"));
				System.out.print(t);
				s.add(t);
				
			}
			
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
		return s;
		
	}
}

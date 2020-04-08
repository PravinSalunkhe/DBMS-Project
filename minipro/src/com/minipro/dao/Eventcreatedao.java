package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.minipro.model.Event;
import com.minipro.model.Sport;

public class Eventcreatedao
{
	public void insertdata(Event t,Sport s)
	{
		//System.out.println(s.getSport_date());
		String temp=t.getHost_id() + t.getEvent_name()+s.getSport_name();
		Connection con=null;
		PreparedStatement p=null;
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			p=con.prepareStatement("insert into event values(?,?,?,?)");
			p.setInt(1,t.getHost_id());
			p.setString(2, t.getEvent_name());
			p.setString(3, t.getCity());
			p.setString(4, t.getDesp());
			p.execute();
			p=con.prepareStatement("insert into sport values(?,?,?,?,?,?,?)");
			p.setInt(1, s.getHost_id());
			p.setString(2, s.getEvent_name());
			p.setString(3, s.getSport_name());
			p.setString(4, s.getSport_date());
			p.setInt(5, s.getFees());
			p.setInt(7, s.getmax_participation());
			p.setInt(6, s.gettotal_participation());
			p.execute();
			System.out.println("Insert Successful");
			
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
	
	public void insertdata1(Sport s)
	{
		String temp=s.getHost_id() + s.getEvent_name()+s.getSport_name();
		Connection con=null;
		PreparedStatement p=null;
		System.out.println(s.getEvent_name());
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			p=con.prepareStatement("insert into sport values(?,?,?,?,?,?,?)");
			p.setInt(1, s.getHost_id());
			p.setString(2, s.getEvent_name());
			p.setString(3, s.getSport_name());
			p.setString(4, s.getSport_date());
			p.setInt(5, s.getFees());
			p.setInt(7, s.getmax_participation());
			p.setInt(6, s.gettotal_participation());
			p.execute();
			System.out.println("Insert Successful");
			
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

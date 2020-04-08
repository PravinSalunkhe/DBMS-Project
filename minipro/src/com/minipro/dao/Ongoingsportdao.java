package com.minipro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Sport;

public class Ongoingsportdao {
	
	
	public List<Sport> getall(int pid)
	{
		
		List<Sport> s= new ArrayList<Sport>();
		Connection con=null;
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select s.uid,s.event_name,s.sport_name,s.sport_date,s.fees,s.total_participation,s.max_participation,e.city from sport s INNER JOIN event e on(s.uid=e.uid and s.event_name=e.event_name) where (s.uid,s.event_name,s.sport_name) not in(select p.uid,p.event_name,p.sport_name from participant p where p.participation_id=?) and (s.sport_date between (curdate() + INTERVAL 3 day) and (curdate() + INTERVAL 1 month));");
			p.setInt(1, pid);
			
			ResultSet rs=null;
			rs=p.executeQuery();
			while(rs.next())
			{
				Sport temp=new Sport();
				temp.setHost_id(rs.getInt("uid"));
				temp.setSport_name(rs.getString("sport_name"));
				temp.setSport_date(rs.getString("sport_date"));
				temp.setFees(rs.getInt("fees"));
				temp.settotal_participation(rs.getInt("total_participation"));
				temp.setmax_participation(rs.getInt("max_participation"));
				temp.setEvent_name(rs.getString("event_name"));
				temp.setCity(rs.getString("city"));
				System.out.println(temp.toString());
				s.add(temp);
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
	
	public List<Sport> getbycity(int pid,String city)
	{
		
		List<Sport> s= new ArrayList<Sport>();
		Connection con=null;
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select s.uid,s.event_name,s.sport_name,s.sport_date,s.fees,s.total_participation,s.max_participation,e.city from sport s INNER JOIN event e on(s.uid=e.uid and s.event_name=e.event_name) where (s.uid,s.event_name,s.sport_name) not in(select p.uid,p.event_name,p.sport_name from participant p where p.participation_id=?) and (s.sport_date between (curdate() + 3 day) and (curdate() + INTERVAL 1 month)) and city=?");
			p.setInt(1, pid);
			p.setString(2, city);
			
			ResultSet rs=null;
			rs=p.executeQuery();
			while(rs.next())
			{
				Sport temp=new Sport();
				temp.setHost_id(rs.getInt("uid"));
				temp.setSport_name(rs.getString("sport_name"));
				temp.setSport_date(rs.getString("sport_date"));
				temp.setFees(rs.getInt("fees"));
				temp.settotal_participation(rs.getInt("total_participation"));
				temp.setmax_participation(rs.getInt("max_participation"));
				temp.setEvent_name(rs.getString("event_name"));
				temp.setCity(rs.getString("city"));
				System.out.println(temp.toString());
				s.add(temp);
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
	
	public List<Sport> getbydate(int pid,String date)
	{
		
		List<Sport> s= new ArrayList<Sport>();
		Connection con=null;
		Date da = Date.valueOf(date);
		System.out.print(da);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select s.uid,s.event_name,s.sport_name,s.sport_date,s.fees,s.total_participation,s.max_participation,e.city from sport s INNER JOIN event e on(s.uid=e.uid and s.event_name=e.event_name) where (s.uid,s.event_name,s.sport_name) not in(select p.uid,p.event_name,p.sport_name from participant p where p.participation_id=?) and (s.sport_date between (curdate() + 3 day) and (?))");
			p.setInt(1, pid);
			p.setDate(2, da);
			
			ResultSet rs=null;
			rs=p.executeQuery();
			while(rs.next())
			{
				Sport temp=new Sport();
				temp.setHost_id(rs.getInt("uid"));
				temp.setSport_name(rs.getString("sport_name"));
				temp.setSport_date(rs.getString("sport_date"));
				temp.setFees(rs.getInt("fees"));
				temp.settotal_participation(rs.getInt("total_participation"));
				temp.setmax_participation(rs.getInt("max_participation"));
				temp.setEvent_name(rs.getString("event_name"));
				temp.setCity(rs.getString("city"));
				System.out.println(temp.toString());
				s.add(temp);
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
	
	public List<Sport> getbysport(int pid,String sport)
	{
		
		List<Sport> s= new ArrayList<Sport>();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select s.uid,s.event_name,s.sport_name,s.sport_date,s.fees,s.total_participation,s.max_participation,e.city from sport s INNER JOIN event e on(s.uid=e.uid and s.event_name=e.event_name) where (s.uid,s.event_name,s.sport_name) not in(select p.uid,p.event_name,p.sport_name from participant p where p.participation_id=?) and (s.sport_date between (curdate() + 3 day) and (curdate() + INTERVAL 1 month) and (s.sport_name=?)) ");
			p.setInt(1, pid);
			p.setString(2, sport);
			
			ResultSet rs=null;
			rs=p.executeQuery();
			while(rs.next())
			{
				Sport temp=new Sport();
				temp.setHost_id(rs.getInt("uid"));
				temp.setSport_name(rs.getString("sport_name"));
				temp.setSport_date(rs.getString("sport_date"));
				temp.setFees(rs.getInt("fees"));
				temp.settotal_participation(rs.getInt("total_participation"));
				temp.setmax_participation(rs.getInt("max_participation"));
				temp.setEvent_name(rs.getString("event_name"));
				temp.setCity(rs.getString("city"));
				System.out.println(temp.toString());
				s.add(temp);
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

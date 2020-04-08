package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Event;
import com.minipro.model.Sport;

public class Upcoming_dao
{
	public List<Event> getevents()
	{
		List<Event> event = new ArrayList<Event>();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select e.uid,e.event_name,e.city,e.description from event as e inner join sport as s on (s.uid=e.uid and e.event_name=s.event_name) group by s.uid,s.event_name having max(sport_date) > (curdate() + interval 2 day)");
			
			
			while(rs.next())
			{
				Event e = new Event();
				e.setHost_id(rs.getInt("uid"));
				e.setEvent_name(rs.getString("event_name"));
				e.setCity(rs.getString("city"));
				e.setDesp(rs.getString("description"));
				System.out.println(e);
				event.add(e);
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return event;
		
	}
	
	public List<Sport> sports_list(int uid, String event_name)	
	{ 	
		List<Sport> s= new ArrayList<Sport>();
		Connection con=null;
		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select * from sport where uid=? and event_name =? and sport_date > (curdate() + INTERVAL 3 day);");
			p.setInt(1, uid);
			p.setString(2,event_name);
			
			ResultSet rs=null;
			rs=p.executeQuery();
			while(rs.next())
			{
				Sport temp=new Sport();
				temp.setHost_id(uid);
				temp.setSport_name(rs.getString("sport_name"));
				temp.setSport_date(rs.getString("sport_date"));
				temp.setFees(rs.getInt("fees"));
				temp.settotal_participation(rs.getInt("total_participation"));
				temp.setmax_participation(rs.getInt("max_participation"));
				temp.setEvent_name(rs.getString("event_name"));
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
	
	public List<Event> geteventbycity(String city)
	{
		List<Event> event = new ArrayList<Event>();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement st=con.prepareStatement("select e.uid,e.event_name,e.city,e.description from event as e inner join sport as s on (s.uid=e.uid and e.event_name=s.event_name) where e.city=? group by s.uid,s.event_name having max(sport_date) > (curdate() + interval 2 day) ");
			st.setString(1, city);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				Event e = new Event();
				e.setHost_id(rs.getInt("uid"));
				e.setEvent_name(rs.getString("event_name"));
				e.setCity(rs.getString("city"));
				e.setDesp(rs.getString("description"));
				System.out.println(e);
				event.add(e);
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return event;
		
	}
	
	public List<Event> geteventbysport(String sport)
	{
		List<Event> event = new ArrayList<Event>();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement st=con.prepareStatement("select e.uid,e.event_name,e.city,e.description from event as e inner join sport as s on (s.uid=e.uid and e.event_name=s.event_name) where s.sport_name=? group by s.uid,s.event_name having max(sport_date) > (curdate() + interval 2 day) ");
			st.setString(1, sport);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				Event e = new Event();
				e.setHost_id(rs.getInt("uid"));
				e.setEvent_name(rs.getString("event_name"));
				e.setCity(rs.getString("city"));
				e.setDesp(rs.getString("description"));
				System.out.println(e);
				event.add(e);
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return event;
		
	}

}

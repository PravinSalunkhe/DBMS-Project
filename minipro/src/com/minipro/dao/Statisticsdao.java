package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Sport;

public class Statisticsdao {
	
	public List<Sport> getevent()
	{
		List<Sport> sport = new ArrayList<Sport>();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select e.event_name,sum(total_participation) total from event_history e inner join sport_history s on (e.uid = s.uid and e.event_name = s.event_name) where s.sport_date between (curdate() - interval 1 month) and curdate() group by e.event_name order by total desc limit 5 ;");
			
			ResultSet rs=p.executeQuery();
			
			while(rs.next())
			{
				Sport s = new Sport();
				s.setEvent_name(rs.getString("event_name"));
				s.settotal_participation(rs.getInt("total"));
				sport.add(s);
			}
			System.out.print(sport);
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
		return sport;
	}
	
	
	public List<Sport> getsport()
	{
		List<Sport> sport = new ArrayList<Sport>();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select s.sport_name,sum(total_participation) total from event_history e inner join sport_history s on (e.uid = s.uid and e.event_name = s.event_name) where s.sport_date between (curdate() - interval 1 month) and curdate() group by s.sport_name order by total desc limit 5");
			
			ResultSet rs=p.executeQuery();
			
			while(rs.next())
			{
				Sport s = new Sport();
				s.setSport_name(rs.getString("sport_name"));
				s.settotal_participation(rs.getInt("total"));
				sport.add(s);
			}
			System.out.println(sport);
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
		return sport;
	}
	
	

	public List<Sport> getuser()
	{
		List<Sport> sport = new ArrayList<Sport>();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select d.first_name,d.last_name,count(*) total from participant_history p inner join sport_history s inner join user u inner join user_details d on(s.uid=p.uid and s.event_name=p.event_name and s.sport_name=p.sport_name and p.participation_id=u.uid and u.user_no=d.user_no) where s.sport_date between (curdate() - interval 1 month) and curdate() group by p.participation_id order by  total desc limit 5");
			
			ResultSet rs=p.executeQuery();
			
			while(rs.next())
			{
				Sport s = new Sport();
				s.setEvent_name(rs.getString("first_name") + " "  + rs.getString("last_name"));
				s.settotal_participation(rs.getInt("total"));
				sport.add(s);
			}
			System.out.println(sport);
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
		return sport;
	}
	
}

package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Sport;

public class hostedsports_dao {

	public List<Sport> get_sports(int uid, String event_name)
	{
	
	List<Sport> s= new ArrayList<Sport>();
	Connection con=null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
		PreparedStatement p=con.prepareStatement("select s.event_name,s.sport_name,s.sport_date,s.fees,s.max_participation,s.total_participation,e.city  from sport s INNER JOIN event e on (s.uid=e.uid and s.event_name=e.event_name) where e.uid=? and e.event_name=? ");
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
			temp.setmax_participation(rs.getInt("max_participation"));
			temp.settotal_participation(rs.getInt("total_participation"));
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
	
	public void deletesport(int uid,String eventname,String sportname,int size,int fees,int tot_parti)
	{
		Connection con=null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("SELECT * from participant where uid=? and event_name=? and sport_name=?");
			p.setInt(1, uid); 
			p.setString(2, eventname);
			p.setString(3, sportname);

			rs = p.executeQuery();
			
			while(rs.next())
			{
				p=con.prepareStatement("INSERT into notification(pid,note,n_date) values(?,?,curdate())");
				p.setInt(1, rs.getInt("participation_id"));
				p.setString(2, "We are extreamely sorry that your registered sport " + sportname + " of event " + eventname + " is cancelled by the organizers.As per T&c the Total amount of fees Rs." + fees +" will be refunded to you");
				p.execute();
			}
			
			p=con.prepareStatement("DELETE from participant where uid=? and event_name=? and sport_name=?");
			p.setInt(1, uid); 
			p.setString(2, eventname);
			p.setString(3, sportname);

			boolean bs = false;
			bs = p.execute();
			
			p=con.prepareStatement("DELETE from sport where uid=? and event_name=? and sport_name=?");
			p.setInt(1, uid); 
			p.setString(2, eventname);
			p.setString(3, sportname);
			bs = p.execute();
			
			if(size == 1)
			{
				p=con.prepareStatement("DELETE from event where uid=? and event_name=?");
				p.setInt(1, uid); 
				p.setString(2, eventname);
				bs = p.execute();
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
	}
	
	public List<Sport> tobescheduledsports(int uid)
	{
	
	List<Sport> s= new ArrayList<Sport>();
	Connection con=null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
		  
		PreparedStatement p=con.prepareStatement("select s.event_name,s.sport_name,s.sport_date,s.fees,s.max_participation,s.total_participation,e.city from event as e inner join sport as s on (s.uid=e.uid and e.event_name=s.event_name) where (e.uid=? and s.sport_date <= curdate() + interval 2 day)");
		p.setInt(1, uid); 
		
		ResultSet rs=null;
		rs=p.executeQuery();
		while(rs.next())
		{
			Sport temp=new Sport();
			temp.setHost_id(uid);
			temp.setSport_name(rs.getString("sport_name"));
			temp.setSport_date(rs.getString("sport_date"));
			temp.setFees(rs.getInt("fees"));
			temp.setmax_participation(rs.getInt("max_participation"));
			temp.settotal_participation(rs.getInt("total_participation"));
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

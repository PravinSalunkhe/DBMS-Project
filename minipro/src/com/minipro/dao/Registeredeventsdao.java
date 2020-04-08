package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Participant;

public class Registeredeventsdao 
{
	public List<Participant> get_reg_events(int pid)
	{
System.out.println("entered dao");
		List<Participant> p= new ArrayList<Participant>();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement s=con.prepareStatement("select * from participant where participation_id=?");
			s.setInt(1,pid);
			ResultSet rs=null;
			rs=s.executeQuery();
			
			while(rs.next())
			{
				Participant temp=new Participant();
				temp.setPid(pid);
				temp.setUid(rs.getInt("uid"));
				temp.setEventName(rs.getString("event_name"));
				temp.setSportName(rs.getString("sport_name"));
				
				PreparedStatement m=con.prepareStatement("select city from event where uid=? and event_name=?");
				m.setInt(1,temp.getUid());
				m.setString(2, temp.getEventName());
				ResultSet x=m.executeQuery();
				while(x.next())
				{	
					temp.setCity(x.getString("city"));
				}
				PreparedStatement n=con.prepareStatement("select sport_date,fees from sport where uid=? and event_name=? and sport_name= ?");
				n.setInt(1, temp.getUid());
				n.setString(2, temp.getEventName());
				n.setString(3,temp.getSportName());
				ResultSet y=n.executeQuery();
				while(y.next())
				{
					temp.setSport_date(y.getString("sport_date"));
					temp.setFees(y.getInt("fees"));
				}
				System.out.println(temp.toString());
				p.add(temp);
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
				e.printStackTrace();
			}
		}
		return p;
		
	}
}

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

public class home_events_dao
{
	public List<Sport> sports_list()	
	{ 	
		List<Sport> s= new ArrayList<Sport>();
		Connection con=null;
		try
		{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p=con.prepareStatement("select s.uid,s.event_name,s.sport_name,s.fees,s.sport_date,s.total_participation,e.city from sport s,event e where s.uid = e.uid and s.event_name=e.event_name and (curdate() + INTERVAL 1 month);");
			
			
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

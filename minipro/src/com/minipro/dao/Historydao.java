package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Sport;

public class Historydao {
	
	private ResultSet rs,rs1;
	
	public List<Sport> gethostsporthistory(int uid)
	{
		List<Sport> sports = new ArrayList<Sport>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement ps = con.prepareStatement("select s.uid,s.event_name,e.city,s.sport_name,s.sport_date,s.fees,s.total_participation,s.max_participation from event_history e RIGHT OUTER JOIN sport_history s on (e.uid=s.uid and e.event_name=s.event_name) where s.uid=?");
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Sport s = new Sport();
				s.setEvent_name(rs.getString("event_name"));
				s.setSport_name(rs.getString("sport_name"));
				s.setHost_id(rs.getInt("uid"));
				s.setSport_date(rs.getString("sport_date"));
				s.settotal_participation(rs.getInt("total_participation"));
				s.setMax_participation(rs.getInt("max_participation"));
				s.setFees(rs.getInt("fees"));
				
				if(rs.getString("city") == null)
				{
					ps = con.prepareStatement("select e.city from event e where e.uid = ? and e.event_name=?");
					ps.setInt(1, uid);
					ps.setString(2, s.getEvent_name());
					rs1 = ps.executeQuery();
					while(rs1.next())
					{
						s.setCity(rs1.getString("city"));
						System.out.println(rs1.getString("city"));
					}	
				}
				else
					s.setCity(rs.getString("city"));
				sports.add(s);
				System.out.println(s);
			}	
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return sports;
		
	}
	
	public List<Sport> getpartisporthistory(int uid)
	{
		List<Sport> sports = new ArrayList<Sport>();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement ps = con.prepareStatement("select p.uid,p.event_name,p.sport_name,p.reg_date,s.sport_date,s.fees from participant_history p LEFT OUTER JOIN sport_history s on (p.uid=s.uid and p.event_name=s.event_name and p.sport_name=s.sport_name) where p.participation_id = ?");
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Sport s = new Sport();
				s.setHost_id(rs.getInt("uid"));
				s.setEvent_name(rs.getString("event_name"));
				s.setSport_name(rs.getString("sport_name"));
				s.setReg_date(rs.getString("reg_date"));
				s.setSport_date(rs.getString("sport_date"));
				s.setFees((rs.getInt("fees")));
				
				System.out.println("*"+s.getEvent_name()+ s.getHost_id());
				ps = con.prepareStatement("select e.city from event e where e.uid = ? and e.event_name=?");
				ps.setInt(1, s.getHost_id());
				ps.setString(2, s.getEvent_name());
				rs1 = ps.executeQuery();
				while(rs1.next())
				{
					s.setCity(rs1.getString("city"));
					System.out.println("aaaa");
				}
				
				if(s.getCity() == null)
				{
					ps = con.prepareStatement("select e.city from event_history e where e.uid = ? and e.event_name=?");
					ps.setInt(1, s.getHost_id());
					ps.setString(2, s.getEvent_name());
					rs1 = ps.executeQuery();
					while(rs1.next())
					{
						s.setCity(rs1.getString("city"));
						System.out.println(rs1.getString("city"));
					}	
				}
				
				
				sports.add(s);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return sports;
	}

}

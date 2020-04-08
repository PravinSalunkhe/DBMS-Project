    package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class reg_participant_dao 
{
	public void insert_data(String e,String s,int uid,String d,int pid,int total_participation,String team_name)
	{
		Connection con=null;
		try
		{
			System.out.println(uid);
			System.out.println(total_participation);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			PreparedStatement p = con.prepareStatement("insert into participant(participation_id,uid,event_name,sport_name,reg_date,team_name) values(?,?,?,?,curdate(),?)");
			p.setInt(1, pid);
			p.setInt(2, uid);
			p.setString(3, e);
			p.setString(4, s);
			p.setString(5, team_name);
			p.execute();
			PreparedStatement k = con.prepareStatement("update sport set total_participation=? where uid=? and event_name=? and sport_name=? ");
			k.setInt(1, total_participation+1);
			k.setInt(2, uid);
			k.setString(3, e);
			k.setString(4, s);
			k.execute();
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

    

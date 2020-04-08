package com.minipro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Cancelregdao {
	
	public void cancelreg(int pid,int uid,String eventname,String sportname,int fees,Date date)
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","Pravin@271999");
			
			//long time = System.currentTimeMillis();
			//Date da = new Date(time);
			Date da = Date.valueOf(LocalDate.now());
			
			 long diffInMillies = Math.abs(date.getTime() - da.getTime());
			 long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			
			PreparedStatement p=con.prepareStatement("INSERT into notification(pid,note,n_date) values(?,?,curdate())");
			p.setInt(1, pid); 
			if(diff <= 2)
				p.setString(2,"You have canceled registration for Sport " + sportname + " of Event " + eventname + ". As per T&c No amount will be refunded to you.");
			else if(diff <= 5)	
				p.setString(2,"You have canceled registration for Sport " + sportname + " of Event " + eventname + ". As per T&c Rs." + fees*0.2 + " will be refunded to you.");
			else if(diff <= 10)	  
				p.setString(2,"You have canceled registration for Sport " + sportname + " of Event " + eventname + ". As per T&c Rs." + fees*0.5 + " will be refunded to you.");
			else if(diff > 10)	  
				p.setString(2,"You have canceled registration for Sport " + sportname + " of Event " + eventname + ". As per T&c Rs." + fees*0.8 + " will be refunded to you.");  
			int rs = p.executeUpdate();
			
			p=con.prepareStatement("Delete from participant where participation_id=? and uid=? and event_name=? and sport_name=?");
			p.setInt(1, pid); 
			p.setInt(2, uid); 
			p.setString(3, eventname);
			p.setString(4, sportname);
			
			int r = p.executeUpdate();
			
			p=con.prepareStatement("update sport s set s.total_participation = s.total_participation - 1 where s.uid = ? and s.event_name=? and s.sport_name=?"); 
			p.setInt(1, uid); 
			p.setString(2, eventname);
			p.setString(3, sportname);
			
			r = p.executeUpdate();
			
			
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

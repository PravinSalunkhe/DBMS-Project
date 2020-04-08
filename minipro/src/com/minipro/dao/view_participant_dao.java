package com.minipro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.minipro.model.Participant;
import com.minipro.model.User;

public class view_participant_dao {

	

	Connection con ;
	Statement stm,stm2;  ResultSet rs;
	PreparedStatement pstm;
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost/event_management";
			String uname="root";
			String passw="Pravin@271999";
			con = DriverManager.getConnection(url,uname,passw);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		} 
	}
	
	
	public List<Participant> get_p_list(int uid,String event_name,String sport_name) throws SQLException
	{
		connect();
		
		List<Participant > p_list= new ArrayList<Participant >();

		 String sql = "select p.team_name,ud.first_name,ud.last_name,ud.email,ud.mobileno,p.reg_date from participant p,user_details ud,user u where p.uid="+uid+" and p.event_name='"+event_name + "' and p.sport_name='"+sport_name +"' and p.participation_id=u.uid and u.user_no=ud.user_no"; 
		
		 System.out.println(sql);
		 
		 stm = con.createStatement();
		    rs = stm.executeQuery(sql);
		    
		    while(rs.next())
		    {
		    	Participant p = new Participant();
		    	
		    	p.setEventName(event_name);
		    	p.setSportName(sport_name);
		    	p.setTeam_name(rs.getString(1));
		    	p.setEmail(rs.getString(4));
		    	p.setFname(rs.getString(2));
		    	p.setLname(rs.getString(3));
		    	p.setMobileno(rs.getLong(5));
		    	p.setReg_date(rs.getString(6));
		    	p_list.add(p);
		    }
		    			    
		   con.close(); stm.close(); rs.close(); 	
		
		return p_list;
		
	}
	
}

package com.minipro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.model.Event;


public class your_events_dao  {

    public your_events_dao() {
        super();
        // TODO Auto-generated constructor stub
    }



	Connection con = null;
	Statement stm=null;  ResultSet rs=null;
	PreparedStatement pstm=null;
	
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
	   
    
 public  List<Event> get_your_events(int uid) throws SQLException
 {
	 List<Event> events = new ArrayList<>();
	 
	 connect();
	 
	 
	 String sql = "select * from event,user where event.uid = " + uid + " and user.user_role='Host' and event.uid=user.uid";
		stm = con.createStatement();
	    rs = stm.executeQuery(sql);
	    
	    
	    while(rs.next())
	    {
	    	int id1 = rs.getInt("uid");
	    	String name1 = rs.getString("event_name");
	    	String city1 = rs.getString("city");
	    	String desp1 = rs.getString("description");
	    	events.add(new Event(id1,name1,city1,desp1));
	    }
	 
	 
	return events;
	 
 }
   
 
}
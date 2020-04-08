package com.minipro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minipro.dao.Upcoming_dao;
import com.minipro.model.Event;

/**
 * Servlet implementation class upcomingevents_controller
 */
@WebServlet("/upcomingevents_controller")
public class upcomingevents_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public upcomingevents_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		// TODO Auto-generated method stub
		
		Upcoming_dao upcomingdao = new Upcoming_dao();
		List<Event> event = new ArrayList<Event>();
		
		String filterby = request.getParameter("filerby");
		String value = null;
		
		if(filterby == null)
		{
			event = upcomingdao.getevents();
		}
		else if(filterby.equals("city"))
		{
			value = request.getParameter("city");
			event = upcomingdao.geteventbycity(value);
		}
		else if(filterby.equals("sport"))
		{
			value = request.getParameter("sport");
			event = upcomingdao.geteventbysport(value);
		}
		
		request.setAttribute("event", event);
		RequestDispatcher rd = request.getRequestDispatcher("upcoming_events.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

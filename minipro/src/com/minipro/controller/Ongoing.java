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

import com.minipro.dao.Ongoingdao;
import com.minipro.model.Event;

/**
 * Servlet implementation class Ongoing
 */
@WebServlet("/Ongoing")
public class Ongoing extends HttpServlet
{
	private static final long serialVersionUID = 1L;
 
    public Ongoing() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Ongoingdao ongoingdao = new Ongoingdao();
		List<Event> event = new ArrayList<Event>();
		
		String filterby = request.getParameter("filerby");
		String value = null;
		
		if(filterby == null)
		{
			event = ongoingdao.getevents();
		}
		else if(filterby.equals("city"))
		{
			value = request.getParameter("city");
			event = ongoingdao.geteventbycity(value);
		}
		else if(filterby.equals("sport"))
		{
			value = request.getParameter("sport");
			event = ongoingdao.geteventbysport(value);
		}
		
		request.setAttribute("event", event);
		RequestDispatcher rd = request.getRequestDispatcher("ongoing_events.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

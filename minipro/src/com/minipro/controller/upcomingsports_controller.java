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
import javax.servlet.http.HttpSession;

import com.minipro.dao.Upcoming_dao;
import com.minipro.model.Sport;

/**
 * Servlet implementation class upcomingsports_controller
 */
@WebServlet("/upcomingsports_controller")
public class upcomingsports_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public upcomingsports_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("end");
		String event_name=(String)request.getParameter("eventName");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String city=(String)request.getParameter("city");
		
		
		System.out.println(event_name);
		Upcoming_dao d=new Upcoming_dao();
		List<Sport> s= new ArrayList<Sport>();
		s=d.sports_list(uid, event_name);
		request.setAttribute("sports_list", s);
		request.setAttribute("city", city);
		RequestDispatcher rd = request.getRequestDispatcher("upcoming_sports.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

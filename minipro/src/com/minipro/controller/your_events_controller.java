package com.minipro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.your_events_dao;
import com.minipro.model.Event;

/**
 * Servlet implementation class your_events_controller
 */
@WebServlet("/your_events_controller")
public class your_events_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public your_events_controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		if(session.getAttribute("curr_uid") == null)
		{
			response.sendRedirect("login.jsp");
			return ;
		}
		int uid = (int) session.getAttribute("curr_uid");
		System.out.println(uid);

		List<Event> events = new ArrayList<Event>();
		your_events_dao dao = new your_events_dao();
		try {
			 events = dao.get_your_events(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		request.setAttribute("events",events );
		RequestDispatcher rd = request.getRequestDispatcher("your_events.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

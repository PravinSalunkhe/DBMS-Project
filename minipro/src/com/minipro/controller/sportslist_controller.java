package com.minipro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.minipro.dao.Ongoingdao;
import com.minipro.model.Event;
import com.minipro.model.Sport;

/**
 * Servlet implementation class sportslist_controller
 */
@WebServlet("/sportslist_controller")
public class sportslist_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public sportslist_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("end");
		String event_name=(String)request.getParameter("eventName");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String city=(String)request.getParameter("city");
		
		HttpSession session = request.getSession();
		int pid = (int) session.getAttribute("participant_id");
		System.out.println(event_name);
		Ongoingdao d=new Ongoingdao();
		List<Sport> s= new ArrayList<Sport>();
		s=d.sports_list(uid, event_name, pid);
		request.setAttribute("temp", s);
		request.setAttribute("city", city);
		RequestDispatcher rd = request.getRequestDispatcher("sports_list.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

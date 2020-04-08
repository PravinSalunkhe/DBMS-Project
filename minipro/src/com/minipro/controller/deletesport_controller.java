package com.minipro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.hostedsports_dao;

/**
 * Servlet implementation class deletesport_controller
 */
@WebServlet("/deletesport")
public class deletesport_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletesport_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		hostedsports_dao dao = new hostedsports_dao();
		
		HttpSession session = request.getSession();
		int size = (int)session.getAttribute("sportsize");
		
		String eventname = request.getParameter("eventName");
		String sportname = request.getParameter("sportName");
		int uid = Integer.valueOf(request.getParameter("uid"));
		int fees = Integer.valueOf(request.getParameter("fees"));
		int tot_parti = Integer.valueOf(request.getParameter("total_participant"));
		
		dao.deletesport(uid, eventname, sportname, size, fees, tot_parti);
		
		RequestDispatcher rd = request.getRequestDispatcher("your_events_controller");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

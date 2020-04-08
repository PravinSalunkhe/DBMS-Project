package com.minipro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.hostedsports_dao;
import com.minipro.model.Sport;

/**
 * Servlet implementation class schedule_event_controller
 */
@WebServlet("/schedule_event")
public class schedule_event_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public schedule_event_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		int uid =(int) ( session.getAttribute("curr_uid"));
		
		String city = request.getParameter("eventCity");
		hostedsports_dao dao = new hostedsports_dao();
		
		List<Sport> s = dao.tobescheduledsports(uid);
		
		request.setAttribute("sport_list", s);
		request.setAttribute("city", city);
		RequestDispatcher rd = request.getRequestDispatcher("schedule_event.jsp");
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

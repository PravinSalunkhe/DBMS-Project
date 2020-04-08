package com.minipro.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.Cancelregdao;

/**
 * Servlet implementation class cancelreg_controller
 */
@WebServlet("/cancelreg")
public class cancelreg_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancelreg_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Cancelregdao dao = new Cancelregdao();
		
		HttpSession session = request.getSession();
		
		String eventname = request.getParameter("eventName");
		String sportname = request.getParameter("sportName");
		int uid = Integer.valueOf(request.getParameter("uid"));
		int pid =(int)session.getAttribute("participant_id");
		int fees = Integer.valueOf(request.getParameter("fees"));
		Date date = Date.valueOf(request.getParameter("date"));
		
		dao.cancelreg(pid,uid, eventname, sportname, fees,date);
		
		RequestDispatcher rd = request.getRequestDispatcher("Ongoing");
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

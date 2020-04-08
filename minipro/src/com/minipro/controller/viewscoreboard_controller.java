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

import com.minipro.dao.Viewscheduledao;
import com.minipro.model.Match;

/**
 * Servlet implementation class viewscoreboard_controller
 */
@WebServlet("/viewscoreboard")
public class viewscoreboard_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewscoreboard_controller() {
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
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String eventname = (String)request.getParameter("eventname");
		String sportname = (String)request.getParameter("sportname");
		String city = (String)request.getParameter("city");
		int fees = Integer.parseInt(request.getParameter("fees"));
		String date = (String)request.getParameter("date");
		int totalparti=0;
		if(request.getParameter("totalparti") != null)
			totalparti = Integer.parseInt(request.getParameter("totalparti"));
		
		Viewscheduledao dao = new Viewscheduledao();
		int max_round = dao.getmax_round(uid, eventname, sportname);
		List<Match> match1 = dao.gelallmatches(uid, eventname, sportname);
		System.out.println(match1);
		
		request.setAttribute("eventname", eventname);
		request.setAttribute("sportname", sportname);
		request.setAttribute("city", city);
		request.setAttribute("fees", fees);
		request.setAttribute("date", date);
		request.setAttribute("totalparti", totalparti);
		request.setAttribute("max_round",max_round);
		request.setAttribute("match",match1);
		RequestDispatcher rd = null;
		System.out.print(session.getAttribute("curr_uid"));
		if(session.getAttribute("curr_uid") != null)
			rd = request.getRequestDispatcher("viewscoreboard.jsp");
		else
			rd = request.getRequestDispatcher("viewscoreboardparti.jsp");
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

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

import com.minipro.dao.Ongoingsportdao;
import com.minipro.model.Sport;

/**
 * Servlet implementation class ongoing_sport_controller
 */
@WebServlet("/ongoingsport")
public class ongoing_sport_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ongoing_sport_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Ongoingsportdao dao = new Ongoingsportdao();
		List<Sport> sport = new ArrayList<Sport>(); 
		
		HttpSession session = request.getSession();
		int pid = (int)session.getAttribute("participant_id");
		
		String filterby = request.getParameter("filerby");
		String value = null;
		
		if(filterby == null)
		{
			sport = dao.getall(pid);
			System.out.print(sport);
		}
		else if(filterby.equals("city"))
		{
			value = request.getParameter("city");	
			sport = dao.getbycity(pid,value);	
		}
		else if(filterby.equals("date"))
		{	
			value = request.getParameter("date");
			sport = dao.getbydate(pid,value);
		}
		else if(filterby.equals("sport"))
		{
			value = request.getParameter("sport");
			sport = dao.getbysport(pid,value);
		}
		
		request.setAttribute("sports", sport);
		RequestDispatcher rd = request.getRequestDispatcher("ongoing_sports.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

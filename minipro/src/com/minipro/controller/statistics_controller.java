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

import com.minipro.dao.Statisticsdao;
import com.minipro.model.Sport;

/**
 * Servlet implementation class statistics_controller
 */
@WebServlet("/statistics")
public class statistics_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public statistics_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Statisticsdao s = new Statisticsdao();
		List<Sport> sport = new ArrayList<Sport>();
		List<Sport> sport1 = new ArrayList<Sport>();
		List<Sport> sport2 = new ArrayList<Sport>();
		
		sport = s.getevent();
		sport1 = s.getsport();
		sport2 = s.getuser();
		
		
		request.setAttribute("sport", sport);
		request.setAttribute("sport1", sport1);
		request.setAttribute("sport2", sport2);
		RequestDispatcher rd = request.getRequestDispatcher("statistics.jsp");
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

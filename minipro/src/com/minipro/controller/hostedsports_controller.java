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

@WebServlet("/hostedsports_controller")
public class hostedsports_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public hostedsports_controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int uid =(int) ( session.getAttribute("curr_uid") );
		
		String ename = request.getParameter("eventName");
		String city = request.getParameter("eventCity");
		hostedsports_dao dao = new hostedsports_dao();
		
		List<Sport> s = dao.get_sports(uid, ename);
		System.out.println("returned from dao");
		request.setAttribute("sport_list", s);
		request.setAttribute("city", city);
		RequestDispatcher rd = request.getRequestDispatcher("hosted_sports.jsp");
		rd.forward(request,response);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

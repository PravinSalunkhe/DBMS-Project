    package com.minipro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.reg_participant_dao;
import com.minipro.model.Participant;

@WebServlet("/reg_participant_controller")
public class reg_participant_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reg_participant_controller()
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entered");
		Participant p= new Participant();
		
		String event_name=request.getParameter("eventName");
		String sport_name=request.getParameter("sportName");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String sdate=(String)request.getParameter("sdate");
		String team_name=request.getParameter("teamName");
		int total_participation=Integer.parseInt(request.getParameter("total_participation"));
		
		System.out.println(uid);
		System.out.println(total_participation);
		System.out.println(team_name);
		HttpSession session= request.getSession();
		int pid=(int)session.getAttribute("participant_id");
		
		reg_participant_dao d= new reg_participant_dao();
		d.insert_data(event_name, sport_name, uid,sdate,pid,total_participation,team_name);

		RequestDispatcher r = request.getRequestDispatcher("Ongoing");
		r.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

    

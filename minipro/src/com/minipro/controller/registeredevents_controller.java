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

import com.minipro.dao.Registeredeventsdao;
import com.minipro.model.Participant;

/**
 * Servlet implementation class registeredevents_controller
 */
@WebServlet("/registeredevents_controller")

public class registeredevents_controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public registeredevents_controller()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("start");
		HttpSession session =request.getSession(false);
		int pid=(int) session.getAttribute("participant_id");
		System.out.println(pid);
		List<Participant> p= new ArrayList<Participant>();
		Registeredeventsdao d = new Registeredeventsdao();
		p=d.get_reg_events(pid);
		
		System.out.println(p.toString());
		request.setAttribute("p", p);
		RequestDispatcher rd = request.getRequestDispatcher("reg_events.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}

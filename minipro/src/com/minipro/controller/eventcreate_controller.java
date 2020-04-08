package com.minipro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.Eventcreatedao;
import com.minipro.model.Event;
import com.minipro.model.Sport;

/**
 * Servlet implementation class eventcreate_controller
 */
@WebServlet("/eventcreate_controller")
public class eventcreate_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public eventcreate_controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("curr_uid") == null)
		{
			response.sendRedirect("login.jsp");
			return ;
		}
		int uid = (int) session.getAttribute("curr_uid");
		System.out.println(uid);
		
		String command=request.getParameter("command");
		String event_name=request.getParameter("eventName");
		System.out.print(command);
		if(command.equals("create_event"))
		{
			System.out.println("if");
		String event_city=request.getParameter("eventCity");
		String event_desc=request.getParameter("eventDesc");
		
		Event e=new Event(uid,event_name,event_city,event_desc);
		System.out.println(event_name);
		
		String sport_name=request.getParameter("sportName");
		String sport_date=request.getParameter("sportDate");
		int sport_fees=Integer.parseInt(request.getParameter("sportFees"));
		int max_parti=Integer.parseInt(request.getParameter("maxParticipation"));
		
		//System.out.println(sport_date);
		Sport s=new Sport(uid,event_name,sport_name,sport_date,sport_fees,max_parti,0);
		Eventcreatedao d=new Eventcreatedao();
		d.insertdata(e,s);
		System.out.println("Insert succsessful");
		request.setAttribute("event_name", event_name);
		RequestDispatcher r= request.getRequestDispatcher("more_sports.jsp");
		r.forward(request, response);
		}
		else
		{
			System.out.println("add more sport");
			System.out.println(event_name);
			String sport_name=request.getParameter("sportName");
			String sport_date=request.getParameter("sportDate");
			int sport_fees=Integer.parseInt(request.getParameter("sportFees"));
			int max_parti=Integer.parseInt(request.getParameter("maxParticipation"));
			
			//System.out.println(sport_date);
			Sport l=new Sport(uid,event_name,sport_name,sport_date,sport_fees,max_parti,0);
			Eventcreatedao k=new Eventcreatedao();
			k.insertdata1(l);
			System.out.println("Insert succsessful1");
			request.setAttribute("event_name", event_name);
			RequestDispatcher r;
			
			
			
			if(command.equals("add more sports"))
				r = request.getRequestDispatcher("more_sports.jsp");
			else
				r = request.getRequestDispatcher("your_events_controller");
			
			r.forward(request, response);
			
		}
	}

}

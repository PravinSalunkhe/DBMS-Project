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

import com.minipro.dao.Notificationsdao;
import com.minipro.model.Notification;

/**
 * Servlet implementation class notifications_controller
 */
@WebServlet("/notifications_controller")
public class notifications_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public notifications_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session= request.getSession();
		int pid=(int) session.getAttribute("participant_id");
		
		Notification n= new Notification();
		List<Notification> temp = new ArrayList<Notification>();
		Notificationsdao d=new Notificationsdao();
		temp=d.create_notifi(pid);
		
		request.setAttribute("notification_list", temp);
		RequestDispatcher rd = request.getRequestDispatcher("notifications.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}

package com.minipro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.profile_dao;
import com.minipro.model.User;

/**
 * Servlet implementation class profile_controller
 */
@WebServlet("/profile_controller")
public class profile_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int str1 = -1;
		int str2= -1;
		
		if(session.getAttribute("curr_uid") != null)
		{
			str1=(int) session.getAttribute("curr_uid"); 
			str2=(int)session.getAttribute("curr_user_no");
		}
		else if(session.getAttribute("participant_id") != null)
		{
			str1=(int) session.getAttribute("participant_id"); 
			str2=(int)session.getAttribute("participant_user_no");
		}
		else
		{
			response.sendRedirect("login.jsp");
			return;
		}
		
		 
		  
		int curr_uid = 0,curr_uno = 0;
		if(str1!=-1 && str2!=-1)
		{	
		 curr_uid =  (str1 );
		 curr_uno =  (str2 );
		}
		else
		{
			System.out.print("SOMEBODYS NULL\n");
		}
		User u=new User();
		profile_dao dao = new profile_dao();
		try {
			u = dao.get_user(curr_uid,curr_uno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
		
		System.out.print(u);
		
		request.setAttribute("usr", u);
		System.out.println(u);
		RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
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

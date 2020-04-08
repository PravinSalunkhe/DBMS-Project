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
 * Servlet implementation class edit_profile_controller
 */
@WebServlet("/edit_profile_controller")
public class edit_profile_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_profile_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		HttpSession session = request.getSession();
		int curr_uid , curr_uno;
			
			if(session.getAttribute("curr_uid") != null)
			{
				curr_uid=(int) session.getAttribute("curr_uid"); 
				curr_uno=(int)session.getAttribute("curr_user_no");
			}
			else if(session.getAttribute("participant_id") != null)
			{
				curr_uid=(int) session.getAttribute("participant_id"); 
				curr_uno=(int)session.getAttribute("participant_user_no");
			}
			else
			{
				response.sendRedirect("login.jsp");
				return;
			}
			
			//try {
				
			
			//}
//			catch(Exception e)
//			{
//				System.out.println(e);
//			}
		
			
		
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
			RequestDispatcher rd = request.getRequestDispatcher("edit_profile.jsp");
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

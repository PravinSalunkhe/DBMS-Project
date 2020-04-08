package com.minipro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.profile_dao;
import com.minipro.model.User;

/**
 * Servlet implementation class change_profile_controller
 */
@WebServlet("/change_profile_controller")
public class change_profile_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_profile_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("\nHIII\n");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("emailid");
		long mob = Long.parseLong(request.getParameter("mob"));
		String organization = request.getParameter("organization");
		String pwd = request.getParameter("pw");
		String role = request.getParameter("role");
		
		User u = new User(fname,lname,email,pwd,role,mob,organization);
		HttpSession session = request.getSession();
		
		int curr_uid = 0,curr_uno = 0;
//		curr_uid = (int)session.getAttribute("curr_uid"); 
//		curr_uno = (int)session.getAttribute("curr_user_no");
//		
//		int curr_uid , curr_uno;
			
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
	
		
		profile_dao dao = new profile_dao();
		try {
			dao.update_user(curr_uid,curr_uno,u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}

		response.sendRedirect("profile_controller");
		return;
//		RequestDispatcher rd = request.getRequestDispatcher("profile_controller");
//		rd.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

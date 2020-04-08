package com.minipro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.login_dao;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				String uname = request.getParameter("email");
				String pw = request.getParameter("passw");
				String role=request.getParameter("Role");

				System.out.println(uname); System.out.println(pw);
				
				login_dao dao = new login_dao();
				int[] a = new int[2];
				a[0]=-1;
				try {
					
					System.out.println("\n hi \n");

					
					a = dao.check_login(uname, pw,role);
					
					System.out.println("\n hi "+a[0]+" "+a[1]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
				
				System.out.println(a[0]);  System.out.println(a[1]);
				
				if(a[0]!=-1)
				{
					HttpSession session = request.getSession();
					session.setAttribute("curr_uid", a[0]);
					System.out.print("*" + a[0]);
					session.setAttribute("curr_user_no", a[1]);
					response.sendRedirect("your_events_controller");
					return;
				}
				else
				{
					response.sendRedirect("login.jsp");
					return;
				}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

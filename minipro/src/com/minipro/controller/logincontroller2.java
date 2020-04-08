package com.minipro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.Login2_dao;



@WebServlet("/logincontroller2")
public class logincontroller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public logincontroller2() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String role=request.getParameter("Admin");
		System.out.println(email + " " + pwd + " " + role);
		Login2_dao l= new Login2_dao();
		int[] a = new int[2];
		a[0]=-1;
		a = l.checklogin(email, pwd, role);
		
		if(a[0]!=-1)
		{
			System.out.println("data matched");
			HttpSession session= request.getSession();
			session.setAttribute("admin_id",a[0]);
			session.setAttribute("admin_user_no",a[1]);
			System.out.println("admin id : " + a[0]);
			RequestDispatcher r = request.getRequestDispatcher("upcomingevents_controller");
			r.forward(request,response);
		}
		else
		{
			System.out.println("data did not match");
			RequestDispatcher r = request.getRequestDispatcher("login2.jsp");
			r.forward(request,response);
		}
	}

}

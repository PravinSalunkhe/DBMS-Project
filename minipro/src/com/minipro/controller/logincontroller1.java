package com.minipro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.Logindao;

/**
 * Servlet implementation class logincontroller1
 */
@WebServlet("/logincontroller1")
public class logincontroller1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public logincontroller1() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		

		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String role=request.getParameter("Participant");
		System.out.println(email + " " + pwd + " " + role);
		Logindao l= new Logindao();
		int[] a = new int[2];
		a[0]=-1;
		a = l.checklogin(email, pwd, role);
		
		if(a[0]!=-1)
		{
			System.out.println("data matched");
			HttpSession session= request.getSession();
			session.setAttribute("participant_id",a[0]);
			session.setAttribute("participant_user_no",a[1]);
			System.out.println("uid : " + a[0]);
			RequestDispatcher r = request.getRequestDispatcher("Ongoing");
			r.forward(request,response);
		}
		else
		{
			System.out.println("data did not match");
			RequestDispatcher r = request.getRequestDispatcher("login1.jsp");
			r.forward(request,response);
		}
		
	}

}

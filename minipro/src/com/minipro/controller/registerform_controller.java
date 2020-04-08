package com.minipro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minipro.dao.Registerformdao;
import com.minipro.model.User;

@WebServlet("/registerform_controller")
public class registerform_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public registerform_controller() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		long mobileno=Integer.parseInt(request.getParameter("mobileno"));
		String organization=request.getParameter("organization");
		String role=request.getParameter("inlineradio");
		String a=request.getParameter("a");
		Registerformdao r =new Registerformdao();
		
		if(role=="Participant")
		{
			organization=null;
		}
		
		User u =new User( firstName, lastName, email,pwd,role,mobileno,organization);
		
		System.out.println(u.toString());
		r.insert_user(u);
		System.out.print("\nrecord inserted");
		
		RequestDispatcher rd = request.getRequestDispatcher("home");
		rd.forward(request,response);
		
	}

}

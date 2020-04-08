package com.minipro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minipro.dao.view_participant_dao;
import com.minipro.model.Participant;
import com.minipro.model.Sport;

/**
 * Servlet implementation class view_participants_controller
 */
@WebServlet("/view_participants_controller")
public class view_participants_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view_participants_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String event_name = request.getParameter("event_name");
		String sport_name =  request.getParameter("sport_name");
		int uid = Integer.parseInt( request.getParameter("uid") ) ;
		
		//System.out.println(event_name + "  " + uid+  "  "+ sport_name);
	
		List<Participant> p_list = new ArrayList<Participant>();
		view_participant_dao  dao = new view_participant_dao();
		try {
			p_list = dao.get_p_list(uid,event_name,sport_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("p_list", p_list);
		RequestDispatcher r = request.getRequestDispatcher("view_participants.jsp");
		r.forward(request,response);
		
	}

}

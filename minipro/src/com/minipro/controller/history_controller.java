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

import com.minipro.dao.Historydao;
import com.minipro.model.Sport;

/**
 * Servlet implementation class history_controller
 */
@WebServlet("/history_controller")
public class history_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public history_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
				Historydao history = new Historydao();
				List<Sport> sports = new ArrayList<Sport>();
				HttpSession session = request.getSession();
				int uid;
				RequestDispatcher rd = null;
				if(session.getAttribute("curr_uid") != null)
				{
					uid = (int) session.getAttribute("curr_uid");
					sports = history.gethostsporthistory(uid);
					System.out.println(session.getAttribute("curr_uid"));
					request.setAttribute("sports",sports );
					rd = request.getRequestDispatcher("history_host.jsp");
					
				}
				else
				{
					uid = (int) session.getAttribute("participant_id");
					sports = history.getpartisporthistory(uid);
					System.out.println(session.getAttribute("participant_id"));
					request.setAttribute("sports",sports );
					rd = request.getRequestDispatcher("history_participant.jsp");
				}
					System.out.println(sports);
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

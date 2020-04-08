package com.minipro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minipro.dao.Viewscheduledao;
import com.minipro.model.Match;

/**
 * Servlet implementation class viewschedule_controller
 */
@WebServlet("/viewschedule")
public class viewschedule_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewschedule_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Viewscheduledao dao = new Viewscheduledao();
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		
		int uid = (int)session.getAttribute("curr_uid");
		String eventname = (String)request.getParameter("eventname");
		String sportname = (String)request.getParameter("sportname");
		String city = (String)request.getParameter("city");
		int fees = Integer.parseInt(request.getParameter("fees"));
		String date = (String)request.getParameter("date");
		int totalparti = Integer.parseInt(request.getParameter("totalparti"));
		List<Match> match = (List<Match>)session.getAttribute("match1");
		System.out.println("**" );
		System.out.println(match);
		
		int final_match = 0;
		int max_round = dao.getmax_round(uid, eventname, sportname);
		
		if((match != null) && match.size()!=0 && max_round > 0)
		{
			int i;
			int size = match.size();
			for(i=0 ; i < match.size() ; i++)
			{
				if(max_round == match.get(i).getRound())
				{
					String a = String.valueOf(match.get(i).getMatch_id());
					String b = request.getParameter(a);
					System.out.println(b);
					if(b == "" || b == null)
						break;
					else
					{
						int x = dao.getpid(uid,eventname,sportname,b);
						System.out.println("%" + x);
						if(x == 0)
							break;
						match.get(i).setWinner_id(x);
					}
					final_match++;

				}
				System.out.println(match.get(i));
			}
			if(i == size)
				dao.updatewinner(uid,eventname,sportname,max_round,match);
			else
				final_match = 0;
		}
		
		if(match != null && match.size()!=0 && final_match ==  1)
		{
			dao.dropinhistory(uid,eventname,sportname);
			rd = request.getRequestDispatcher("history_controller");
		}
		else
		{
			max_round = dao.getschedule(uid,eventname,sportname);
			List<Match> match1 = dao.gelallmatches(uid,eventname,sportname);
			
			request.setAttribute("eventname", eventname);
			request.setAttribute("sportname", sportname);
			request.setAttribute("city", city);
			request.setAttribute("fees", fees);
			request.setAttribute("date", date);
			request.setAttribute("totalparti", totalparti);
			request.setAttribute("max_round",max_round);
			request.setAttribute("match",match1);
			session.setAttribute("match1", match1);
			rd = request.getRequestDispatcher("viewschedule.jsp");
		}

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

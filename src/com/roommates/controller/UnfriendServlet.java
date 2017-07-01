package com.roommates.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roommates.dao.DaoMVC;
import com.roommates.model.ModelUser;

@WebServlet(urlPatterns = "/Unfriend")
public class UnfriendServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		HttpSession session = request.getSession(false);
		ModelUser logged = new ModelUser();
		logged = (ModelUser) session.getAttribute("loggedInUser");

		int i = DaoMVC.unfriend(uname, logged.getUname());

		if (i != 0)
		{
			if(logged.getFriends().remove(uname))
			{
				request.setAttribute("msg", "Unfriend successful and updated.");
			}
			else
			{
				request.setAttribute("msg", "Unfriend successful but NOT updated.");
			}
		}
		else
		{
			request.setAttribute("msg", "Sorry, did NOT unfriend... Try again in some time.");
		}
		getServletContext().getRequestDispatcher("/Home?uname="+uname).forward(request, response);
	}

}
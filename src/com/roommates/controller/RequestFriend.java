package com.roommates.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roommates.dao.DaoMVC;
import com.roommates.model.ModelUser;

@WebServlet(urlPatterns = "/Request")
public class RequestFriend extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		HttpSession session = request.getSession();
		ModelUser logged = new ModelUser();
		logged = (ModelUser) session.getAttribute("loggedInUser");
		Calendar calendar = Calendar.getInstance();
		Date now = new Date(calendar.getTime().getTime());
		long time = now.getTime();

		int i = DaoMVC.requestFriend(uname, logged.getUname(), now);

		if(i != 0)
		{
			String sql = "UPDATE users SET notescheck = ? WHERE uname = ?";
			int t = DaoMVC.updateTime(sql, uname, time);

			if (t != 0)
			{
				request.setAttribute("user", logged);
				request.setAttribute("msg", "You have successfully send a friend request.");
			}
			else
			{
				request.setAttribute("user", logged);
				request.setAttribute("msg", "Friend request sent, but could NOT update notes check.");
			}
		}
		else
		{
			request.setAttribute("user", logged);
			request.setAttribute("msg", "Sorry we could not send a friend request.");
		}
		getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
	}

}
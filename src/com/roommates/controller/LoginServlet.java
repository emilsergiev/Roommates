package com.roommates.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roommates.dao.DaoMVC;
import com.roommates.model.ModelUser;

@WebServlet(urlPatterns = "/Login")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		if(uname.equals(null)||uname==""||pass.equals(null)||pass=="")
		{
			request.setAttribute("msg", "All fields with * are mandatory!");
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else
		{
			ModelUser user = new ModelUser();
			user = DaoMVC.loginUser(uname, pass);

			if(user != null)
			{
				Calendar calendar = Calendar.getInstance();
				Date now = new Date(calendar.getTime().getTime());
				long time = now.getTime();
				String sql = "UPDATE users SET lastlogin = ? WHERE uname = ?";
				int i = DaoMVC.updateTime(sql, uname, time);

				if(i == 0)
				{
					request.setAttribute("msg", "Welcome " + user.getUname() + " - Sorry we could not update your login time");
				}
				else
				{
					request.setAttribute("msg", "Welcome " + user.getUname() + " - It's a good day today!");
				}
				if(user.getNotesCheck() > user.getLastLogin())
				{
					user.setNotifications("images/note_flash.gif");
				}
				else
				{
					user.setNotifications("images/note_still.jpg");
				}
				List<String> pendingRequests = DaoMVC.findRequests2u(uname, 0);
				user.setPendingFriends(pendingRequests);
				user.setRequests(pendingRequests.size());

				List<String> pendingRequestsMade = DaoMVC.findYourRequests(uname, 0);
				user.setRequestedFriends(pendingRequestsMade);

				List<String> acceptedRequests = DaoMVC.findRequests2u(uname, 1);
				List<String> acceptedRequestsMade = DaoMVC.findYourRequests(uname, 1);
				List<String> madeFriends = new ArrayList<String>();
				madeFriends.addAll(acceptedRequests);
				madeFriends.addAll(acceptedRequestsMade);
				user.setFriends(madeFriends);

				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser", user);
				request.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "invalid username or password!");
				getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		}
	}

}
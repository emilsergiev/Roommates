package com.roommates.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roommates.dao.DaoMVC;
import com.roommates.model.ModelUser;

@WebServlet(urlPatterns = "/Home")
public class HomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		boolean friendCheck = false;
		String button;

		HttpSession session = request.getSession(false);
		ModelUser logged = new ModelUser();
		logged = (ModelUser) session.getAttribute("loggedInUser");

		ModelUser user = new ModelUser();
		user = DaoMVC.findUser(uname);

		if(user != null)
		{
			request.setAttribute("user", user);

			if(session == null || logged == null)
			{
				request.setAttribute("owner", "You are NOT logged in.");
				button = "<form action='Login' method='post'>"
						+ "<button type='submit' class='button'>Log In</button></form>";
				request.setAttribute("button", button);
			}
			else if(logged.getUname().equals(uname))
			{
				request.setAttribute("owner", "You are the owner of this profile.");
				button = "<form action='Avatar' method='post'>"
						+ "<button type='submit' class='button'>Change Profile Avatar</button></form>";
				request.setAttribute("button", button);
			}
			else
			{
				request.setAttribute("owner", "You are NOT the owner of this profile.");
				List<String> list = logged.getFriends();

				for(String friend : list)
				{
					if(friend.equals(uname))
					{
						friendCheck = true;
						break;
					}
				}
				if(friendCheck)
				{
					button = "<form action='Request' method='post'>"
							+ "<input type='hidden' name='uname' value='" + uname + "'>"
							+ "<button type='submit' class='button'>Unfriend</button></form>";
				}
				else
				{
					button = "<form action='Request' method='post'>"
							+ "<input type='hidden' name='uname' value='" + uname + "'>"
							+ "<button type='submit' class='button'>Request Friend</button></form>";
				}
				request.setAttribute("button", button);
			}
			getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "something smelly!");
			getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
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
		boolean pendingCheck = false;
		boolean requestedCheck = false;
		String button;
		String deny;

		HttpSession session = request.getSession(false);
		ModelUser logged = new ModelUser();
		logged = (ModelUser) session.getAttribute("loggedInUser");

		ModelUser user = new ModelUser();
		user = DaoMVC.findUser(uname);


		List<String> friends = DaoMVC.findFriends(uname);
		StringBuilder sb = new StringBuilder();
		for(String name : friends)
		{
			ModelUser friend = DaoMVC.findUser(name);
			sb.append(String.format("<span><a href='Home?uname=%s'><img src='%s' alt='avatar'></a>"
					+ "<br>%s</span>", friend.getUname(), friend.getAvatar(), friend.getUname()));
		}
		String result = sb.toString();

		request.setAttribute("friends", result);
		request.setAttribute("user", user);

		if(session == null || logged == null)
		{
			request.setAttribute("owner", "You are NOT logged in.");
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

			for(String friend : friends)
			{
				if(friend.equals(uname))
				{
					friendCheck = true;
					break;
				}
			}
			if(friendCheck)
			{
				button = "<form action='Unfriend' method='post'>"
						+ "<input type='hidden' name='uname' value='" + uname + "'>"
						+ "<button type='submit' class='button'>Unfriend</button></form>";
			}
			else
			{
				List<String> pendingFriends = logged.getPendingFriends();

				for(String pending : pendingFriends)
				{
					if(pending.equals(uname))
					{
						pendingCheck = true;
						break;
					}
				}
				if(pendingCheck)
				{
					button = "<form action='Accept' method='post'>"
							+ "<input type='hidden' name='uname' value='" + uname + "'>"
							+ "<button type='submit' class='button'>Accept Friend</button></form>";
					deny = "<form action='Unfriend' method='post'>"
							+ "<input type='hidden' name='uname' value='" + uname + "'>"
							+ "<button type='submit' class='button'>Deny Request</button></form>";
					request.setAttribute("deny", deny);
				}
				else
				{
					List<String> requestedFriends = logged.getRequestedFriends();

					for(String requested : requestedFriends)
					{
						if(requested.equals(uname))
						{
							requestedCheck = true;
							break;
						}
					}
					if(requestedCheck)
					{
						button = "Your friend request is pending...";
					}
					else
					{
						button = "<form action='Request' method='post'>"
								+ "<input type='hidden' name='uname' value='" + uname + "'>"
								+ "<button type='submit' class='button'>Request Friend</button></form>";
					}
				}
			}
			request.setAttribute("button", button);
		}
		getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
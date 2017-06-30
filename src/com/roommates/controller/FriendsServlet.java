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

@WebServlet(urlPatterns = "/Friends")
public class FriendsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		ModelUser loggedInUser = (ModelUser) session.getAttribute("loggedInUser");
		
		List<String> list = loggedInUser.getPendingFriends();
		StringBuilder sb = new StringBuilder();

		for(String name : list)
		{
			ModelUser friend = DaoMVC.findUser(name);
			sb.append(String.format("<span><a href='Home?uname=%s'><img src='%s' alt='avatar'></a>"
					+ "<br>%s</span>", friend.getUname(), friend.getAvatar(), friend.getUname()));
		}
		String result = sb.toString();

		if(list.size() > 0)
		{
			request.setAttribute("friendRequests", result);
		}
		else
		{
			request.setAttribute("friendRequests", "You have no new friend requests.");
		}
		getServletContext().getRequestDispatcher("/Notifications.jsp").forward(request, response);
	}

}
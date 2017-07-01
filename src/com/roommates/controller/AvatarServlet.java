package com.roommates.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roommates.model.ModelUser;

@WebServlet(urlPatterns = "/Avatar")
public class AvatarServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		ModelUser logged = new ModelUser();
		logged = (ModelUser) session.getAttribute("loggedInUser");
		
		request.setAttribute("msg", "Sorry this feature is not implemented yet :(");
		getServletContext().getRequestDispatcher("/Home?uname="+logged.getUname()).forward(request, response);
	}

}
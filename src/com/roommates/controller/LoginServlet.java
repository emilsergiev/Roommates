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
				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser", user);
				request.setAttribute("msg", "Welcome " + user.getUname());
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
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

@WebServlet(urlPatterns = "/Home")
public class HomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");

		String owner;
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
				request.setAttribute("logged", "login to check mailbox");
				owner = "login to update your info";
				request.setAttribute("owner", owner);
				button = "<form action='Login' method='post'>"
						+ "<input type='text' name='uname' placeholder='Username' required>"
						+ "<input type='password' name='pass' placeholder='Password' required>"
						+ "<input type='submit' value='Login'></form>";
				request.setAttribute("button", button);
			}
			else if(logged.getUname().equals(uname))
			{
				request.setAttribute("logged", "<a href='#'>check your mailbox</a>");
				owner = "<a href='UpdateUser.jsp'>click here to update your info</a><br>"
						+ "<a href='ResetPass.jsp'>click here to reset your password</a>";
				request.setAttribute("owner", owner);
				button = "<form action='Logout' method='post'>Hello " + logged.getUname()
						+ " <input type='submit' value='Logout'></form>";
				request.setAttribute("button", button);
			}
			else
			{
				request.setAttribute("logged", "<a href='#'>check your mailbox</a>");
				owner = "you are not the owner of this profile...";
				request.setAttribute("owner", owner);
				button = "<form action='Logout' method='post'>Hello " + logged.getUname()
						+ " <input type='submit' value='Logout'></form>";
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
package com.roommates.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		ModelUser user = new ModelUser();
		user.setUname(uname);
		
		HttpSession session = request.getSession(false);
		String logged = (String) session.getAttribute("loggedInUser");

		ResultSet rs = DaoMVC.findUser(user);
		try {
			if(rs.next())
			{
				request.setAttribute("uname", rs.getString(1));
				request.setAttribute("email", rs.getString(2));
				request.setAttribute("gender", rs.getString(4));
				request.setAttribute("city", rs.getString(5));
				request.setAttribute("country", rs.getString(6));
				request.setAttribute("phone", rs.getString(7));
				request.setAttribute("type", rs.getString(8));
				request.setAttribute("avatar", rs.getString(9));
				request.setAttribute("signup", rs.getString(10));
				request.setAttribute("lastlogin", rs.getLong(11));
				request.setAttribute("notescheck", rs.getLong(12));
				//if(session.getAttribute("loggedInUser").equals(null))
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
				else if(logged.equals(uname))
				{
					request.setAttribute("logged", "<a href='#'>check your mailbox</a>");
					owner = "<a href='UpdateUser.jsp'>click here to update your info</a><br>"
							+ "<a href='ResetPass.jsp'>click here to reset your password</a>";
					request.setAttribute("owner", owner);
					button = "<form action='Logout' method='post'>Hello " + logged
							+ " <input type='submit' value='Logout'></form>";
					request.setAttribute("button", button);
				}
				else
				{
					request.setAttribute("logged", "<a href='#'>check your mailbox</a>");
					owner = "you are not the owner of this profile...";
					request.setAttribute("owner", owner);
					button = "<form action='Logout' method='post'>Hello " + logged
							+ " <input type='submit' value='Logout'></form>";
					request.setAttribute("button", button);
				}
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("banner", "something smelly!");
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
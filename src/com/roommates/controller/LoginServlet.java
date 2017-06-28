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
			user.setUname(uname);
			user.setPass(pass);

			HttpSession session = request.getSession();

			ResultSet rs = DaoMVC.loginUser(user);

			try {
				if(rs.next())
				{
					session.setAttribute("uname", rs.getString(1));
					session.setAttribute("email", rs.getString(2));
					session.setAttribute("pass", rs.getString(3));
					session.setAttribute("gender", rs.getString(4));
					session.setAttribute("city", rs.getString(5));
					session.setAttribute("country", rs.getString(6));
					session.setAttribute("phone", rs.getString(7));
					session.setAttribute("type", rs.getString(8));
					session.setAttribute("avatar", rs.getString(9));
					session.setAttribute("loggedInUser", uname);
					//TODO Fetch status, notifications, and friend's list from database...
					// and forward them to the User.jsp page only (not in the session)
					String owner = "<a href='UpdateUser.jsp'>click here to update your info</a><br>"
							+ "<a href='ResetPass.jsp'>click here to reset your password</a>";
					request.setAttribute("owner", owner);
					request.setAttribute("logged", "<a href='#'>check your mailbox</a>");
					String button = "<form action='Logout' method='post'>Hello " + uname
							+ " <input type='submit' value='Logout'></form>";
					request.setAttribute("button", button);
					getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "invalid username or password!");
					getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
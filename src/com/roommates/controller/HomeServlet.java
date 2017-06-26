package com.roommates.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

		ModelUser user = new ModelUser();
		user.setUname(uname);

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
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
			}
			else
			{
				System.out.println("something smelly!");
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
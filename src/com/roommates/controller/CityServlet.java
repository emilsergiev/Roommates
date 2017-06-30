package com.roommates.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roommates.dao.DaoMVC;
import com.roommates.model.ModelUser;

@WebServlet(urlPatterns = "/City")
public class CityServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String city = request.getParameter("city");
		String sql = "SELECT * FROM users WHERE city = ?";
		String result;
		StringBuilder sb = new StringBuilder();

		try {
			List<ModelUser> list = DaoMVC.queryUsers(sql, city);

			if(list != null && list.size() > 0)
			{
				for(ModelUser user : list)
				{
					sb.append(String.format("<span><a href='Home?uname=%s'><img src='%s' alt='avatar'></a>"
							+ "<br>%s</span>", user.getUname(), user.getAvatar(), user.getUname()));
				}
				result = sb.toString();
			}
			else
			{
				result = "<p>Sorry we don't have any users from " + city + " yet :(</p>"
						+ "<p>Be the first one to <a href='Register.jsp'>register</a> from this city"
						+ " and we will send you a free T-shirt and a coffee mug!</p>";
			}
			request.setAttribute("byCity", result);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
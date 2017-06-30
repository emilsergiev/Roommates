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

@WebServlet(urlPatterns = "/Update")
public class UpdateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");

		HttpSession session = request.getSession();
		ModelUser loggedInUser = (ModelUser) session.getAttribute("loggedInUser");
		loggedInUser.setUname(uname);
		loggedInUser.setEmail(email);
		loggedInUser.setGender(gender);
		loggedInUser.setCity(city);
		loggedInUser.setCountry(country);
		loggedInUser.setPhone(phone);
		loggedInUser.setType(type);

		if(uname.equals(null)||uname==""||email.equals(null)||email==""||gender.equals(null)||gender==""
				||city.equals(null)||city==""||country.equals(null)||country==""||type.equals(null)||type=="")
		{
			request.setAttribute("msg", "All fields with * are mandatory!");
			getServletContext().getRequestDispatcher("/UpdateUser.jsp").forward(request, response);
		}
		else
		{
			int i = DaoMVC.updateUser(loggedInUser);

			if(i != 0)
			{
				request.setAttribute("msg", "User info updated successfully");
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "User info NOT updated");
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
			}
		}
	}

}
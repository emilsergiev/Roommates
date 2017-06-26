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
		session.setAttribute("uname", uname);
		session.setAttribute("email", email);
		session.setAttribute("gender", gender);
		session.setAttribute("city", city);
		session.setAttribute("country", country);
		session.setAttribute("phone", phone);
		session.setAttribute("type", type);

		ModelUser user = new ModelUser();
		user.setUname(uname);
		user.setEmail(email);
		user.setGender(gender);
		user.setCity(city);
		user.setCountry(country);
		user.setPhone(phone);
		user.setType(type);

		if(uname.equals(null)||uname==""||email.equals(null)||email==""||gender.equals(null)||gender==""
				||city.equals(null)||city==""||country.equals(null)||country==""||type.equals(null)||type=="")
		{
			request.setAttribute("msg", "All fields with * are mandatory!");
			getServletContext().getRequestDispatcher("/UpdateUser.jsp").forward(request, response);
		}
		else
		{
			int i = DaoMVC.updateUser(user);

			if(i != 0)
			{
				request.setAttribute("msg", "User info updated successfully");
				getServletContext().getRequestDispatcher("/UserMain.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "User info NOT updated");
				getServletContext().getRequestDispatcher("/UserMain.jsp").forward(request, response);
			}
		}
	}

}
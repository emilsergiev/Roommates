package com.roommates.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roommates.dao.DaoMVC;
import com.roommates.model.ModelUser;

@WebServlet(urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String rpass = request.getParameter("rpass");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");

		ModelUser user = new ModelUser();
		user.setUname(uname);
		user.setEmail(email);
		user.setPass(pass);
		user.setGender(gender);
		user.setCity(city);
		user.setCountry(country);
		user.setType(type);

		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		if(phone.equals(null)||phone==""){
			user.setPhone("no phone available");
		}
		else
		{
			user.setPhone(phone);
		}
		if(gender.equals("Male"))
		{
			user.setAvatar("images/male.png");
		}
		else
		{
			user.setAvatar("images/female.png");
		}

		Calendar calendar = Calendar.getInstance();
		Date now = new Date(calendar.getTime().getTime());

		user.setSignup(now);
		user.setLastLogin(now.getTime());
		user.setNotesCheck(now.getTime());

		ModelUser dup = DaoMVC.findUser(uname);

		if(dup != null){
			request.setAttribute("msg", "Sorry that username is taken... Try a different one");
			getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		else if(uname.equals(null)||uname==""||email.equals(null)||email==""||pass.equals(null)||pass==""
				||rpass.equals(null)||rpass==""||gender.equals(null)||gender==""||city.equals(null)||city==""
				||country.equals(null)||country==""||type.equals(null)||type=="")
		{
			request.setAttribute("msg", "All fields with * are mandatory!");
			getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		else if(!pass.equals(rpass))
		{
			request.setAttribute("msg", "Password does not match!");
			getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		else
		{
			int i = DaoMVC.registerUser(user);

			if(i != 0)
			{
				request.setAttribute("msg", "Registration successful... Login here");
				getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "sorry that username already exists!");
				getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
			}
		}
	}

}
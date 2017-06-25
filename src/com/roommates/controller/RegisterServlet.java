package com.roommates.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roommates.dao.DaoMVC;
import com.roommates.model.ModelRoommate;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String rpass = request.getParameter("rpass");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String sques = request.getParameter("sques");
		String ans = request.getParameter("ans");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");

		ModelRoommate m = new ModelRoommate();
		m.setUname(uname);
		m.setPass(pass);
		m.setFname(fname);
		m.setLname(lname);
		m.setEmail(email);
		m.setSques(sques);
		m.setAns(ans);
		m.setPhone(phone);
		m.setType(type);
		m.setAvatar("blank.png");

		if(uname.equals(null)||uname==""||pass.equals(null)||pass==""||rpass.equals(null)
				||rpass==""||fname.equals(null)||fname==""||lname.equals(null)||lname==""
				||email.equals(null)||email==""||sques.equals(null)||sques==""||ans.equals(null)
				||ans==""||phone.equals(null)||phone=="")
		{
			request.setAttribute("msg", "All fields are mandatory!");
			getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		else if(!pass.equals(rpass))
		{
			request.setAttribute("msg", "Password does not match!");
			getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		else
		{
			String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?,?)";
			int i = DaoMVC.registerUser(m, sql);

			if(i != 0)
			{
				System.out.println("value inserted");
				request.setAttribute("msg", "Registration successful... Login here");
				getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			}
			else
			{
				System.out.println("value not inserted");
			}
		}
	}

}

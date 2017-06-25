package com.roommates.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roommates.dao.DaoMVC;
import com.roommates.model.ModelRoommate;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uname = request.getParameter("uname");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String sques = request.getParameter("sques");
		String ans = request.getParameter("ans");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");

		HttpSession session = request.getSession();
		ModelRoommate m = new ModelRoommate();
		m.setUname(uname);
		m.setFname(fname);
		m.setLname(lname);
		m.setEmail(email);
		m.setSques(sques);
		m.setAns(ans);
		m.setPhone(phone);
		m.setType(type);

		if(uname.equals(null)||uname==""||fname.equals(null)||fname==""||lname.equals(null)||lname==""
				||email.equals(null)||email==""||sques.equals(null)||sques==""||ans.equals(null)
				||ans==""||phone.equals(null)||phone=="")
		{
			request.setAttribute("msg", "All fields are mandatory!");
			getServletContext().getRequestDispatcher("/UpdateUser.jsp").forward(request, response);
		}
		else
		{
			String sql = "UPDATE users SET fname=?, lname=?, email=?, sques=?, ans=?, phone=?, type=?"
					+ " WHERE uname=?";

			int i = DaoMVC.updateUser(m, sql);

			if(i != 0)
			{
				session.setAttribute("uname", uname);
				session.setAttribute("fname", fname);
				session.setAttribute("lname", lname);
				session.setAttribute("email", email);
				session.setAttribute("sques", sques);
				session.setAttribute("ans", ans);
				session.setAttribute("phone", phone);
				session.setAttribute("type", type);

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

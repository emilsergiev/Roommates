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

@WebServlet("/ResetPassServlet")
public class ResetPassServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String renewpass = request.getParameter("renewpass");
		HttpSession session = request.getSession();
		String cpass = (String)session.getAttribute("pass");
		String uname = (String)session.getAttribute("uname");
		
		if(oldpass.equals(null)||oldpass==""||newpass.equals(null)||newpass==""
				||renewpass.equals(null)||renewpass=="")
		{
			request.setAttribute("msg", "All fields are mandatory!");
			getServletContext().getRequestDispatcher("/ResetPass.jsp").forward(request, response);
		}
		else if(!newpass.equals(renewpass))
		{
			request.setAttribute("msg", "Password does not match!");
			getServletContext().getRequestDispatcher("/ResetPass.jsp").forward(request, response);
		}
		else if(!cpass.equals(oldpass))
		{
			request.setAttribute("msg", "Old password is not correct!");
			getServletContext().getRequestDispatcher("/ResetPass.jsp").forward(request, response);
		}
		else
		{
			ModelRoommate m = new ModelRoommate();
			m.setUname(uname);
			m.setPass(newpass);
			
			String sql = "UPDATE users SET pass = ? WHERE uname = ?";
			int i = DaoMVC.resetPass(m, sql);
			
			if(i != 0)
			{
				request.setAttribute("msg", "New password updated successfully");
				getServletContext().getRequestDispatcher("/UserMain.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Password NOT updated... Try after some time");
				getServletContext().getRequestDispatcher("/UserMain.jsp").forward(request, response);
			}
		}
	}

}

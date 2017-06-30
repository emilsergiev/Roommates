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

@WebServlet(urlPatterns = "/ResetPass")
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
		ModelUser loggedInUser = new ModelUser();
		loggedInUser = (ModelUser) session.getAttribute("loggedInUser");
		String cpass = loggedInUser.getPass();

		if(oldpass.equals(null)||oldpass==""||newpass.equals(null)||newpass==""
				||renewpass.equals(null)||renewpass=="")
		{
			request.setAttribute("msg", "All fields with * are mandatory!");
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
			loggedInUser.setPass(newpass);			
			int i = DaoMVC.resetPass(loggedInUser);
			
			if(i != 0)
			{
//				session.setAttribute("loggedInUser", loggedInUser);
				request.setAttribute("msg", "New password updated successfully");
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Password NOT updated... Try after some time");
				getServletContext().getRequestDispatcher("/User.jsp").forward(request, response);
			}
		}
	}

}

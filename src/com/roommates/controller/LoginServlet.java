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
import com.roommates.model.ModelRoommate;

@WebServlet("/LoginServlet")
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
			request.setAttribute("msg", "All fields are mandatory!");
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else
		{
			ModelRoommate m = new ModelRoommate();
			m.setUname(uname);
			m.setPass(pass);
			
			String sql = "SELECT * FROM users WHERE uname = ? AND pass = ?";
			
			HttpSession session = request.getSession();
			
			ResultSet rs = DaoMVC.loginUser(m, sql);
			
			try {
				if(rs.next())
				{
					session.setAttribute("uname", rs.getString(1));
					session.setAttribute("pass", rs.getString(2));
					session.setAttribute("fname", rs.getString(3));
					session.setAttribute("lname", rs.getString(4));
					session.setAttribute("email", rs.getString(5));
					session.setAttribute("sques", rs.getString(6));
					session.setAttribute("ans", rs.getString(7));
					session.setAttribute("phone", rs.getString(8));
					session.setAttribute("type", rs.getString(9));
					session.setAttribute("avatar", rs.getString(10));
					getServletContext().getRequestDispatcher("/UserMain.jsp").forward(request, response);
				}
				else
				{
					getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

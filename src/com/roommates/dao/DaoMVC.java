package com.roommates.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.roommates.model.ModelRoommate;

public class DaoMVC
{
	private static Connection connect()
	{
		Connection con = null;

		try {
			String uri = "jdbc:mysql://localhost:3306/roommates";
			String user = "mate";
			String password = "M8s4Me&You";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(uri, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("connection to database failed!");
			e.printStackTrace();
		}
		return con;
	}

	public static int registerUser(ModelRoommate m, String sql)
	{
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getUname());
			ps.setString(2, m.getPass());
			ps.setString(3, m.getFname());
			ps.setString(4, m.getLname());
			ps.setString(5, m.getEmail());
			ps.setString(6, m.getSques());
			ps.setString(7, m.getAns());
			ps.setString(8, m.getPhone());
			ps.setString(9, m.getType());
			ps.setString(10, m.getAvatar());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static ResultSet loginUser(ModelRoommate m, String sql)
	{
		ResultSet rs = null;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getUname());
			ps.setString(2, m.getPass());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static int updateUser(ModelRoommate m, String sql)
	{
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getFname());
			ps.setString(2, m.getLname());
			ps.setString(3, m.getEmail());
			ps.setString(4, m.getSques());
			ps.setString(5, m.getAns());
			ps.setString(6, m.getPhone());
			ps.setString(7, m.getType());
			ps.setString(8, m.getUname());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int resetPass(ModelRoommate m, String sql)
	{
		int i = 0;
		Connection con = connect();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getPass());
			ps.setString(2, m.getUname());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}

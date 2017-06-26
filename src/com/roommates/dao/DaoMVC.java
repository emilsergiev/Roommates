package com.roommates.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.roommates.model.ModelUser;

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

	public static ResultSet findUser(ModelUser user)
	{
		ResultSet rs = null;
		Connection con = connect();
		String sql = "SELECT * FROM users WHERE uname = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			rs = ps.executeQuery();
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static int registerUser(ModelUser user)
	{
		int i = 0;
		Connection con = connect();
		String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getCity());
			ps.setString(6, user.getCountry());
			ps.setString(7, user.getPhone());
			ps.setString(8, user.getType());
			ps.setString(9, user.getAvatar());
			ps.setDate(10, user.getSignup());
			ps.setLong(11, user.getLastLogin());
			ps.setLong(12, user.getNotesCheck());
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static ResultSet loginUser(ModelUser user)
	{
		ResultSet rs = null;
		Connection con = connect();
		String sql = "SELECT * FROM users WHERE uname = ? AND pass = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPass());
			rs = ps.executeQuery();
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static int updateUser(ModelUser user)
	{
		int i = 0;
		Connection con = connect();
		String sql = "UPDATE users SET email = ?, gender = ?, city = ?, country = ?, phone = ?, type = ?"
				+ " WHERE uname = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getCity());
			ps.setString(4, user.getCountry());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getType());
			ps.setString(7, user.getUname());
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int resetPass(ModelUser user)
	{
		int i = 0;
		Connection con = connect();
		String sql = "UPDATE users SET pass = ? WHERE uname = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getPass());
			ps.setString(2, user.getUname());
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static List<ModelUser> queryUsers() throws SQLException
	{
		Connection con = connect();
		String sql = "SELECT uname, avatar FROM users";

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		List<ModelUser> list = new ArrayList<ModelUser>();

		while (rs.next())
		{
			String uname = rs.getString("uname");
			String avatar = rs.getString("avatar");
			ModelUser roommate = new ModelUser();
			roommate.setUname(uname);
			roommate.setAvatar(avatar);
			list.add(roommate);
		}
		con.close();
		return list;
	}

}
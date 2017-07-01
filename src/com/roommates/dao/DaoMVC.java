package com.roommates.dao;

import java.sql.Connection;
import java.sql.Date;
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

	public static ModelUser findUser(String uname)
	{
		ModelUser user = null;
		Connection con = connect();
		String sql = "SELECT * FROM users WHERE uname = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String username = rs.getString(1);
				String email = rs.getString(2);
				String gender = rs.getString(4);
				String city = rs.getString(5);
				String country = rs.getString(6);
				String phone = rs.getString(7);
				String type = rs.getString(8);
				String avatar = rs.getString(9);
				Date signup = rs.getDate(10);
				long lastLogin = rs.getLong(11);
				long notesCheck = rs.getLong(12);
				user = new ModelUser();
				user.setUname(username);
				user.setEmail(email);
				user.setGender(gender);
				user.setCity(city);
				user.setCountry(country);
				user.setPhone(phone);
				user.setType(type);
				user.setAvatar(avatar);
				user.setSignup(signup);
				user.setLastLogin(lastLogin);
				user.setNotesCheck(notesCheck);
			}
			con.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
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

	public static ModelUser loginUser(String uname, String pass)
	{
		ModelUser user = null;
		Connection con = connect();
		String sql = "SELECT * FROM users WHERE uname = ? AND pass = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String username = rs.getString(1);
				String email = rs.getString(2);
				String password = rs.getString(3);
				String gender = rs.getString(4);
				String city = rs.getString(5);
				String country = rs.getString(6);
				String phone = rs.getString(7);
				String type = rs.getString(8);
				String avatar = rs.getString(9);
				Date signup = rs.getDate(10);
				long lastLogin = rs.getLong(11);
				long notesCheck = rs.getLong(12);
				user = new ModelUser();
				user.setUname(username);
				user.setEmail(email);
				user.setPass(password);
				user.setGender(gender);
				user.setCity(city);
				user.setCountry(country);
				user.setPhone(phone);
				user.setType(type);
				user.setAvatar(avatar);
				user.setSignup(signup);
				user.setLastLogin(lastLogin);
				user.setNotesCheck(notesCheck);
			}
			con.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static int updateTime(String sql, String uname, long time)
	{
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, time);
			ps.setString(2, uname);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
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

	public static List<ModelUser> queryUsers(String sql, String x) throws SQLException
	{
		Connection con = connect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, x);
		ResultSet rs = ps.executeQuery();
		List<ModelUser> list = new ArrayList<ModelUser>();

		while(rs.next())
		{
			String uname = rs.getString("uname");
			String email = rs.getString("email");
			String gender = rs.getString("gender");
			String city = rs.getString("city");
			String country = rs.getString("country");
			String phone = rs.getString("phone");
			String type = rs.getString("type");
			String avatar = rs.getString("avatar");
			Date signup = rs.getDate("signup");
			long lastLogin = rs.getLong("lastlogin");
			long notesCheck = rs.getLong("notescheck");
			ModelUser user = new ModelUser();
			user.setUname(uname);
			user.setEmail(email);
			user.setGender(gender);
			user.setCity(city);
			user.setCountry(country);
			user.setPhone(phone);
			user.setType(type);
			user.setAvatar(avatar);
			user.setSignup(signup);
			user.setLastLogin(lastLogin);
			user.setNotesCheck(notesCheck);
			list.add(user);
		}
		con.close();
		return list;
	}

	public static List<String> findRequests2u(String uname, int x)
	{
		Connection con = connect();
		String sql = "SELECT user2 FROM friends WHERE user1 = ? AND accepted = ?";
		List<String> list = new ArrayList<String>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setInt(2, x);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String username = rs.getString("user2");
				list.add(username);
			}
			con.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}

	public static List<String> findYourRequests(String uname, int x)
	{
		Connection con = connect();
		String sql = "SELECT user1 FROM friends WHERE user2 = ? AND accepted = ?";
		List<String> list = new ArrayList<String>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setInt(2, x);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String username = rs.getString("user1");
				list.add(username);
			}
			con.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}

	public static int requestFriend(String uname, String logged, Date now) {
		int i = 0;
		Connection con = connect();
		String sql = "INSERT INTO friends (`user1`, `user2`, `datemade`, `accepted`) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, logged);
			ps.setDate(3, now);
			ps.setInt(4, 0);
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int unfriend(String uname, String lname)
	{
		int i = 0;
		Connection con = connect();
		String sql = "DELETE FROM friends WHERE (user1 = ? AND user2 = ?)"
				+ " OR (user2 = ? AND user1 = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, lname);
			ps.setString(3, uname);
			ps.setString(4, lname);
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int accept(String uname, String lname)
	{
		int i = 0;
		Connection con = connect();
		String sql = "UPDATE friends SET accepted = ? WHERE "
				+ "(user1 = ? AND user2 = ?) OR (user2 = ? AND user1 = ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, uname);
			ps.setString(3, lname);
			ps.setString(4, uname);
			ps.setString(5, lname);
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static List<String> findFriends(String uname)
	{
		Connection con = connect();
		String sql = "SELECT * FROM friends WHERE (user1 = ? OR user2 = ?) AND accepted = ?";
		List<String> list = new ArrayList<String>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, uname);
			ps.setInt(3, 1);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String user1 = rs.getString("user1");
				if(!user1.equals(uname)) list.add(user1);
				String user2 = rs.getString("user2");
				if(!user2.equals(uname)) list.add(user2);
			}
			con.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
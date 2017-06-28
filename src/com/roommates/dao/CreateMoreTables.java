package com.roommates.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMoreTables
{
	public static void main(String[] args)
	{
		createTableFriends();
		createTableNotifications();
		createTableBlockedusers();
		createTableStatus();
		createTablePhotos();
	}

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

	private static void createTableFriends()
	{
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS friends ("
					+ "id INT(11) NOT NULL AUTO_INCREMENT, "
					+ "user1 VARCHAR(16) NOT NULL, "
					+ "user2 VARCHAR(16) NOT NULL, "
					+ "datemade DATETIME NOT NULL, "
					+ "accepted INT(1) NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (id))";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("table friends NOT created :(");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("table friends created :)");
	}

	private static void createTableNotifications()
	{
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS notifications ("
					+ "id INT(11) NOT NULL AUTO_INCREMENT, "
					+ "username VARCHAR(16) NOT NULL, "
					+ "initiator VARCHAR(16) NOT NULL, "
					+ "app VARCHAR(255) NOT NULL, "
					+ "note VARCHAR(255) NOT NULL, "
					+ "did_read INT(1) NOT NULL DEFAULT 0, "
					+ "date_time DATETIME NOT NULL, "
					+ "PRIMARY KEY (id))";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("table notifications NOT created :(");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("table notifications created :)");
	}

	private static void createTableBlockedusers()
	{
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS blockedusers ("
					+ "id INT(11) NOT NULL AUTO_INCREMENT, "
					+ "user1 VARCHAR(16) NOT NULL, "
					+ "user2 VARCHAR(16) NOT NULL, "
					+ "datemade DATETIME NOT NULL, "
					+ "accepted INT(1) NOT NULL DEFAULT 0, "
					+ "PRIMARY KEY (id))";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("table blockedusers NOT created :(");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("table blockedusers created :)");
	}

	private static void createTableStatus()
	{
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS status ("
					+ "id INT(11) NOT NULL AUTO_INCREMENT, "
					+ "osid INT(11) NOT NULL, "
					+ "account VARCHAR(16) NOT NULL, "
					+ "author VARCHAR(16) NOT NULL, "
					+ "type INT(1) NOT NULL, "
					+ "data TEXT NOT NULL, "
					+ "postdate DATETIME NOT NULL, "
					+ "PRIMARY KEY (id))";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("table status NOT created :(");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("table status created :)");
	}

	private static void createTablePhotos()
	{
		Connection con = connect();
		try {
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS photos("
					+ "id INT(11) NOT NULL AUTO_INCREMENT, "
					+ "user VARCHAR(16) NOT NULL, "
					+ "gallery VARCHAR(16) NOT NULL, "
					+ "filename VARCHAR(255) NOT NULL, "
					+ "description VARCHAR(255) NULL, "
					+ "uploaddate DATETIME NOT NULL, "
					+ "PRIMARY KEY (id))";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println("table photos NOT created :(");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("table photos created :)");
	}

}

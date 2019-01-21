package com.mouadkommir.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager instance;
	
	private ConnectionManager() {
		
	}
	
	public static ConnectionManager getInstance() {
		
		if(instance == null)
			instance = new ConnectionManager();
		return instance;
		
	}
	
	
	
	public Connection getConnection(String type) {
		
		String driver = "";
		String url = "";
		String user = "";
		String password = "";
		
		if(type == "mysql") {
			driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://localhost:3306/sgli_db";
			user = "sysSGLI";
			password = "";
		}
		
		else if(type == "sqlserver") {
			driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
			url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=sgli_db";
			user = "sysSGLI";
			password = "";
		}
		
		Connection cn = null;
		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public void closeConnection(Connection cn) {
		try {
			if(cn != null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

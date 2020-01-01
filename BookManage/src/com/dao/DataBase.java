package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	
	private  static String url = "jdbc:sqlserver://localhost:1433;databaseName=BookSystem";
	private  static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private  static String user = "sa";
	private  static String password = "w.lrfc.c13";
	
	public static java.sql.Connection getConnection(){// 
		Connection cnn=null;
		try {
			
			Class.forName(driver);// 
			cnn= DriverManager.getConnection(url, user, password);
						
		} catch (java.sql.SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return cnn;
	}

}
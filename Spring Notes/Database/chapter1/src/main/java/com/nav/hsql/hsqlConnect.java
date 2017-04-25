package com.nav.hsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class hsqlConnect {

	public static void main(String[] args) {
		 try {
		     Class.forName("org.hsqldb.jdbc.JDBCDriver" );
		 } catch (Exception e) {
		     System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
		     e.printStackTrace();
		     return;
		 }

		 try {
			Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

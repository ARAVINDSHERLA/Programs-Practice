package com.dell.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDeleteDemoProgram {
	
	public static void main(String[] args) throws Exception {
	    Connection conn = getOracleConnection();//getHSQLConnection();//getMySqlConnection();
	    System.out.println("Got Connection.");
	    String deleteCommand="DELETE FROM employee where employee_id=1001";//sql querys
	    Statement stm=conn.createStatement();
		   int count=stm.executeUpdate(deleteCommand);
		   System.out.println(count +"rows deleted");
		   stm.close();
	       conn.close();
}
	public static Connection getHSQLConnection() throws Exception {
	    Class.forName("org.hsqldb.jdbcDriver");
	    System.out.println("Driver Loaded.");
	    String url = "jdbc:hsqldb:data/tutorial";
	    return DriverManager.getConnection(url, "sa", "");
	  }

	  public static Connection getMySqlConnection() throws Exception {
	    String driver = "org.gjt.mm.mysql.Driver";
	    String url = "jdbc:mysql://localhost/demo2s";
	    String username = "oost";
	    String password = "oost";

	    Class.forName(driver);
	    Connection conn = DriverManager.getConnection(url, username, password);
	    return conn;
	  }

	  public static Connection getOracleConnection() throws Exception {
	    String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:dev123";
	    String username = "system";
	    String password = "JAVAc123";

	    Class.forName(driver); // load Oracle driver
	    Connection conn = DriverManager.getConnection(url, username, password);
	    return conn;
	  }
}

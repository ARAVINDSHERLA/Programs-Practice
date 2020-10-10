package com.dell.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBInsertDemoProgram
{
	public static void main(String[] args) throws Exception
	{
	    Connection conn = getOracleConnection();//getHSQLConnection();//getMySqlConnection();
	    System.out.println("Got Connection.");
	     String insertCommand="insert into employee values(111,'TEST','HYDTEST',80)";
	    Statement stm=conn.createStatement();
	 // Set auto-commit to false
	       conn.setAutoCommit(false);
		   int count=stm.executeUpdate(insertCommand);
		   System.out.println(count +"rows inserted");
		   conn.commit();
		   stm.close();
	       conn.close();//
}
	public static Connection getHSQLConnection() throws Exception
	{
	    Class.forName("org.hsqldb.jdbcDriver");
	    System.out.println("Driver Loaded.");
	    String url = "jdbc:hsqldb:data/tutorial";
	    return DriverManager.getConnection(url, "sa", "");
	  }

	  public static Connection getMySqlConnection() throws Exception 
	  {
	    String driver = "org.gjt.mm.mysql.Driver";
	    String url = "jdbc:mysql://localhost/demo2s";
	    String username = "oost";
	    String password = "oost";

	    Class.forName(driver);
	    Connection conn = DriverManager.getConnection(url, username, password);
	    return conn;
	  }

	  public static Connection getOracleConnection() throws Exception 
	  {
	    String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:dev123";
	    String username = "system";
	    String password = "JAVAc123";

	    Class.forName(driver); // load Oracle driver
	    Connection conn = DriverManager.getConnection(url, username, password);
	    return conn;
	  }
}
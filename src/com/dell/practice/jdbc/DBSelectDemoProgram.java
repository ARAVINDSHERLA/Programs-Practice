package com.dell.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBSelectDemoProgram {
	public static void main(String[] args) throws Exception {
	    Connection conn = getOracleConnection();//getHSQLConnection();//getMySqlConnection();
	    System.out.println("Got Connection.");
	    Statement stm=conn.createStatement();
		String query="select employee_name from employee"; //where employee_id=1003";
		ResultSet rs=stm.executeQuery(query);
		System.out.println("rs:"+rs);//set of rows which match query criteria
		ResultSetMetaData rm=rs.getMetaData();
		int cols=rm.getColumnCount();
		System.out.println("cols:"+cols);
		
		while(rs.next())
		{
			for(int i=1;i<=cols;i++)
			{System.out.print(rm.getColumnName(i)+"\t");
			}
			//System.out.println("Result----------->"+rs.getString("eno"));
			System.out.println();
			for(int i=1;i<=cols;i++)
			{
				System.out.print(rs.getString(i)
						+"\t");
				
			}
			System.out.println();
		}
		rs.close();
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

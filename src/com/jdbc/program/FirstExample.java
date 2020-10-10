package com.jdbc.program;


//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FirstExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=ausmg10cdedbscn.us.dell.com)(PORT=1521))(CONNECT_DATA=(SERVER=dedicated)(SERVICE_NAME=DF11I_DEFAULT.dev.amer.dell.com)))";

   //  Database credentials
  /* static final String USER = "system";
   static final String PASS = "system";*/
   
   static final String USER = "SERVICE_BOSS_UDM";
   static final String PASS = "fdr_d3v_s3rv1c3";
   
   
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
       Class.forName(JDBC_DRIVER);
      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      /*String sql;
      sql = "select deptno,dname,loc from dept";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String deptno  = rs.getString("deptno");
         String dname = rs.getString("dname");
         String loc = rs.getString("loc");
         

         //Display values
         System.out.print("Deptno: " + deptno);
         System.out.print(", Dname: " + dname);
         System.out.print(", Loc: " + loc);
         
      }
      //STEP 6: Clean-up environment
      rs.close();*/
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample
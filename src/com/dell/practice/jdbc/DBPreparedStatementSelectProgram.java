package com.dell.practice.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBPreparedStatementSelectProgram {
	public static String retrievalCommand="SELECT AGE,EMPLOYEE_ID,EMPLOYEE_NAME as ename,ADDRESS FROM employee WHERE EMPLOYEE_ID=?";
	public static void main(String[] args) throws Exception{
			Connection conn=DBTestConnectionProgram.getOracleConnection();
			
			//Alernate using string replcement as similar functionality as prepared statement
			/*Statement stm=conn.createStatement();
			String s=retrievalCommand.replace("?","444");
			ResultSet rs=stm.executeQuery(s);
			*/
			//using prepard statement
			PreparedStatement ps=conn.prepareStatement(retrievalCommand);
			ps.setInt(1, 1003);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println("AGE= rs.getInt(AGE)--->"+rs.getInt("AGE")+",rs.getInt(1)--> "+rs.getInt(1));
				System.out.println("EMPLOYEE_ID= rs.getString(EMPLOYEE_ID)-->"+rs.getString("EMPLOYEE_ID") +", rs.getString(2)-->"+
						  rs.getString(2)); //3-->sal
				System.out.println("EMPLOYEE_NAME="+rs.getString("ename"));
				System.out.println("ADDRESS="+rs.getString("ADDRESS"));
			}					
			rs.close();
			conn.close();
	}
}

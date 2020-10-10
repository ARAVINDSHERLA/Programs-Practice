package com.dell.practice.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class DBBatchProcessingStatement {
	

	
	public static void main(String[] args) throws Exception{
			Connection conn=DBTestConnectionProgram.getOracleConnection();
			// Create statement object
			Statement stmt = conn.createStatement();

			// Set auto-commit to false
			conn.setAutoCommit(false);

			// Create SQL statement
			String SQL = "INSERT INTO Employee (EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, age) " +
			             "VALUES(200,'Zia', 'Ali', 30)";
			// Add above SQL statement in the batch.
			stmt.addBatch(SQL);

			// Create one more SQL statement
			 SQL = "INSERT INTO Employee (EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, age) " +
			             "VALUES(201,'Raj', 'Kumar', 35)";
			// Add above SQL statement in the batch.
			stmt.addBatch(SQL);

			// Create one more SQL statement
			 SQL = "INSERT INTO STUDENT (STUDENT_ROLLNO, STUDENTNAME, ADDRESS, CITY) " +
			             "VALUES(201,'Praveen', 'yousufguda', 'hyderab ad')";
			// Add above SQL statement in the batch.
			stmt.addBatch(SQL);
			

			// Create one more SQL statement
			 SQL = "UPDATE Employee SET age = 35 " +
			             "WHERE EMPLOYEE_ID = 101";
			// Add above SQL statement in the batch.
			stmt.addBatch(SQL);

			// Create an int[] to hold returned values
			int[] count = stmt.executeBatch();
            System.out.println("count:::"+count.length);
			//Explicitly commit statements to apply changes
			conn.commit();
	}


}

package com.dell.practice.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBBatchProcessingPreparedStatement {
	

	

	
	public static void main(String[] args) throws Exception{
			Connection conn=DBTestConnectionProgram.getOracleConnection();
			// Create SQL statement
			String SQL = "INSERT INTO Employee (EMPLOYEE_ID, EMPLOYEE_NAME, ADDRESS, age) " +
			             "VALUES(?, ?, ?, ?)";

			// Create PrepareStatement object
			PreparedStatement pstmt = conn.prepareStatement(SQL);

			//Set auto-commit to false
			conn.setAutoCommit(false);

			// Set the variables
			pstmt.setInt( 1, 400 );
			pstmt.setString( 2, "Pappu" );
			pstmt.setString( 3, "Singh" );
			pstmt.setInt( 4, 33 );
			// Add it to the batch
			pstmt.addBatch();

			// Set the variables
			pstmt.setInt( 1, 401 );
			pstmt.setString( 2, "Pawan" );
			pstmt.setString( 3, "Singh" );
			pstmt.setInt( 4, 31 );
			// Add it to the batch
			pstmt.addBatch();

			//add more batches
			
			//Create an int[] to hold returned values
			int[] count = pstmt.executeBatch();

			//Explicitly commit statements to apply changes
			conn.commit();
			pstmt.close();
			conn.close();
	}




}

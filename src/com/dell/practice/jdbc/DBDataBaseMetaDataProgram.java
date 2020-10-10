package com.dell.practice.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DBDataBaseMetaDataProgram {
			public static void main(String[] args) throws Exception{
			Connection conn=DBTestConnectionProgram.getOracleConnection();
			// Create SQL statement
			DatabaseMetaData dbmd=conn.getMetaData();  
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			  
			conn.close();  
			  
			  
			
	}
}

package com.dell.practice.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBPreparedStatementProgram {
	public static  String insertCommand="insert into employee values(?,?,?,?)";
	public static void main(String[] args) throws Exception{
			Connection conn=DBTestConnectionProgram.getOracleConnection();
									PreparedStatement ps=conn.prepareStatement(insertCommand);
			ps.setInt(1,444);
			ps.setString(2,"swaraj");
			ps.setString(3,"yousufguda");
			ps.setInt(4,20);
			int count=ps.executeUpdate();
			System.out.println(count+"Rows inserted");
			ps.setInt(1,555);
			ps.setString(2,"raj");
			ps.setString(3,"Ammerpet");
			ps.setInt(4,25);
			count=ps.executeUpdate();
			System.out.println(count+"Rows inserted");
			ps.close();
			conn.close();
	}
}


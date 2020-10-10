package com.dell.practice.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class ScrollableandUpdatableResultSet {

	
	public static void main(String a[]) throws Exception{

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	 con=DBTestConnectionProgram.getOracleConnection();
	// Create SQL statement
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	ResultSet.CONCUR_READ_ONLY);
	rs = st.executeQuery("select employee_name from employee");
	System.out.println("ResultSet Curson is at before first: "+rs.isBeforeFirst());
	while(rs.next()){
	System.out.println(rs.getString(1));
	}
	//now result set cursor reached the last position
	System.out.println("Is After Last: "+rs.isAfterLast());
	while(rs.previous()){
	System.out.println(rs.getString(1));
	}
 
	}
}

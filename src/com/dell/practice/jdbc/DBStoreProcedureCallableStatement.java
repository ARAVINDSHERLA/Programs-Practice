package com.dell.practice.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class DBStoreProcedureCallableStatement {
	public static void main(String[] args) throws Exception{
		Connection conn=DBTestConnectionProgram.getOracleConnection();
		CallableStatement cs=conn.prepareCall("{call getEmpName(?,?)}");
		cs.setInt(1,1003);
		cs.registerOutParameter(2,Types.VARCHAR);
		System.out.println("value of Type.VARCHAR="+Types.VARCHAR);
		cs.execute();
		String result=cs.getString(2);
		System.out.println("EMPLOYEE_NAME="+result);
		cs.close();
		conn.close();
	}
}

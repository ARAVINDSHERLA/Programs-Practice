package com.dell.persistance.serializable;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;


//Get Parameter Count From Parameter MetaData

public class TestConnection {
  public static void main(String[] args) throws Exception {
    Connection conn = getOracleConnection();//getMySqlConnection();//getOracleConnection();//getHSQLConnection();
    System.out.println("Got Connection.");
    Statement st = conn.createStatement();
   /* st.executeUpdate("create table survey (id int,name varchar);");
    st.executeUpdate("create view surveyView as (select * from survey);");
    st.executeUpdate("insert into survey (id,name ) values (1,'nameValue')");*/
    
    PreparedStatement pstmt = null;
    ParameterMetaData paramMetaData = null;
    String query = "select * from vendor where vendor_id=? and create_by =?";
    pstmt = conn.prepareStatement(query);
    paramMetaData = pstmt.getParameterMetaData();
    if (paramMetaData == null) {
      System.out.println("db vendor does NOT support ParameterMetaData");
    } else {
      System.out.println("db vendor supports ParameterMetaData");
      // find out the number of dynamic parameters
      
      int paramCount = paramMetaData.getParameterCount();
      System.out.println("paramCount=" + paramCount);
      System.out.println("-------------------");
      for (int param = 1; param <= paramCount; param++) {
        System.out.println("param number=" + param);
        int nullable = paramMetaData.isNullable(param);
        if (nullable == ParameterMetaData.parameterNoNulls) {
          System.out.println("parameter will not allow NULL values.");
        } else if (nullable == ParameterMetaData.parameterNullable) {
          System.out.println("parameter will allow NULL values.");
        } else {
          System.out.println("nullability of a parameter is unknown.");
        }

        
        int paramMode = paramMetaData.getParameterMode(param);
        System.out.println("param mode=" + paramMode);
        if (paramMode == ParameterMetaData.parameterModeOut) {
          System.out.println("the parameter's mode is OUT.");
        } else if (paramMode == ParameterMetaData.parameterModeIn) {
          System.out.println("the parameter's mode is IN.");
        } else if (paramMode == ParameterMetaData.parameterModeInOut) {
          System.out.println("the parameter's mode is INOUT.");
        } else {
          System.out.println("the mode of a parameter is unknown.");
        }
        
        String paramTypeName = paramMetaData.getParameterTypeName(param);
        System.out.println("param SQL type name=" + paramTypeName);
        
        int sqlTypeCode = paramMetaData.getParameterType(param);
        System.out.println("param SQL type code=" + sqlTypeCode);
        
        String paramClassName = paramMetaData.getParameterClassName(param);
        System.out.println("param class name=" + paramClassName);
        
    


      }

    }

    pstmt.close();
   conn.close();

  }

  private static Connection getHSQLConnection() throws Exception {
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
   // String url = "jdbc:oracle:thin:@localhost:1521:caspian";
    String url="jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=ausmg10ddedbscn.us.dell.com)(PORT=1521))(CONNECT_DATA=(SERVER=dedicated)(SERVICE_NAME=df11s_default.sit.amer.dell.com)))";
    String username = "SERVICE_BOSS_UDM";
    String password = "fdr_b0ss_s3cur3";

    Class.forName(driver); // load Oracle driver
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }
}


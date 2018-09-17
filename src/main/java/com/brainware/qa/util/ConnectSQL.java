package com.brainware.qa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class ConnectSQL {
	
  
	
  @Test
  public void conDB() throws ClassNotFoundException, SQLException {
	  
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  System.out.println("SQL Driver loaded");
	  
	  Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.208.218.58:1433;databaseName=BFI_Config","sa","welcome$123");
	  System.out.println("Data loaded");
	  
	  //Executing SQL query and fetching the result
	  Statement st = conn.createStatement(
              ResultSet.TYPE_SCROLL_INSENSITIVE,
              ResultSet.CONCUR_READ_ONLY, 
              ResultSet.HOLD_CURSORS_OVER_COMMIT);
	  String sqlStr = "select * from sys.Tables";
	  ResultSet rs = st.executeQuery(sqlStr);
	  System.out.println(rs);
	  ArrayList<String> ar= new ArrayList<String>();
	  ArrayList<Object> resultSetArray= new ArrayList<Object>();
	   

	  
	  while (rs.next()) {
		  System.out.println("Print data from Table "+rs.getString("name"));
		  ar.add(rs.getString("name"));
		  System.out.println("ar:"+ar);
	  	  String sqlStr1 = "select * from "+rs.getString("name");
		  ResultSet rs1 = st.executeQuery(sqlStr1);
		  
		  //System.out.println("rs1: "+rs1);
		  while(rs1.next()) {
              StringBuilder sb = new StringBuilder();
              int numCols = rs1.getMetaData().getColumnCount();
              System.out.println("Number of Columns "+numCols);
              
              
              ResultSetMetaData metadata = rs1.getMetaData();
           
              for (int i=1; i<=numCols; i++) 
              {
                  String columnName = metadata.getColumnName(i);
                  System.out.println(columnName);
                  resultSetArray.add(columnName.toString());
              }
              
              
           /*   for (int i = 1; i <= numCols; i++) {
            	  System.out.println("Inside for loop");
            	  String sqlStr2 = "select * from "+rs1.getString(i);
        		  ResultSet rs2 = st.executeQuery(sqlStr2);
                  sb.append(String.format(String.valueOf(rs2.getString(i))) + " ");

              }
              resultSetArray.add(sb.toString());*/

          }
		  		  
		}	
	  conn.close();
	  System.out.println(resultSetArray);
	  
	  //return ar;
	  
	
	  
	}
  }

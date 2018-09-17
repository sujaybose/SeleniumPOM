package com.brainware.qa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadWriteExcel {
   public static void ReadWrite() throws Exception {
     Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");

     Connection m_Connection = DriverManager.getConnection("jdbc:sqlserver://10.208.218.58:1433;databaseName=BFI_Config","sa","welcome$123");

     Statement m_Statement = m_Connection.createStatement();
     String query = "SELECT * FROM MyTable";

     ResultSet m_ResultSet = m_Statement.executeQuery(query);

     while (m_ResultSet.next()) {
       System.out.println(m_ResultSet.getString(1) + ", " + m_ResultSet.getString(2) + ", "
           + m_ResultSet.getString(3));

     }
   }
 }
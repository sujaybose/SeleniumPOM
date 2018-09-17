package com.brainware.qa.util;

import org.testng.annotations.Test;


import org.testng.annotations.Test;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

public class DataOp {

 private static final String file_name = (System.getProperty("user.dir")+ "/src/main/java/com/brainware"
			+ "/qa/config/dbdata.csv");
 private static List<String> resultSetArray=new ArrayList<String>();
 public static String username ="sa";     // Enter DB Username
 public static String password = "welcome$123";    // Enter DB password
 public static String url = "jdbc:sqlserver://10.208.218.58:1433;databaseName=BFI_Config";         // Enter DB URL

   

 public static void main(String args[]) throws Exception{
	 	Connection connection=DriverManager.getConnection(url,username,password); 
        fetchDataFromDatabase("SQL queries", connection);
        printToCsv(resultSetArray);                

 }
//fetchDataFromDatabase

//The code below count the number of columns in a table, and store in a result array.

public static void fetchDataFromDatabase(String selectQuery,Connection connection) throws  Exception{
            try {


                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(selectQuery);
                int numCols = rs.getMetaData().getColumnCount();

                while(rs.next()) {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 1; i <= numCols; i++) {
                        sb.append(String.format(String.valueOf(rs.getString(i))) + " ");

                    }
                    resultSetArray.add(sb.toString());

                }

            } catch (SQLException e) {
                //LOGGER.error("Sql exception " + e.getMessage());
            }

        }

//printToCsv

 public static void printToCsv(List<String> resultArray) throws Exception{

        File csvOutputFile = new File(file_name);
        FileWriter fileWriter = new FileWriter(csvOutputFile, false);


        for(String mapping : resultArray) {
            fileWriter.write(mapping + "\n");
         }

        fileWriter.close();

    }
}

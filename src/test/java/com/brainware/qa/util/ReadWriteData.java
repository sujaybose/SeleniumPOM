package com.brainware.qa.util;

import org.testng.annotations.Test;

public class ReadWriteData {
	@Test
	public void readExcel() throws Exception {
		Xls_Reader reader = new Xls_Reader(
				"C:\\eclipse\\workspace\\BFISCM\\src\\main\\java\\com\\brainware\\qa\\testdata\\BFI_Config.xlsx");

		int rowCount = reader.getRowCount("BRWAMT");
		System.out.println("rowcount:" + rowCount);
		int colCount = reader.getColumnCount("BRWAMT");
		System.out.println("colcount:" + colCount);

		// for (int colNum = 1; colNum <= colCount; colNum++) 
		String Format = reader.getCellData("BRWAMT", "Format", 2);
		String IgnoreCharacters = reader.getCellData("BRWAMT", "IgnoreCharacters", 2);
		String ExportThousandSeparator = reader.getCellData("BRWAMT", "ExportThousandSeparator", 2);
		String ExportDecimalSeparator = reader.getCellData("BRWAMT", "ExportDecimalSeparator", 2);


	}
}

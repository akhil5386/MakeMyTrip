package com.qa.makemytrip.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadCredentials {
	public String username;
	public String password;
	
	public HashMap hm;
	
	public ReadCredentials() throws BiffException, IOException {
		hm = new HashMap();
		
		FileInputStream file = new FileInputStream("InputFiles/Credentials.xls");
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sh = wb.getSheet(0);
		username=sh.getCell(0,1).getContents();
		password=sh.getCell(1,1).getContents();
		
		
		FileInputStream testCase = new FileInputStream("InputFiles/TestCases.xls");
		Workbook wbTestCase = Workbook.getWorkbook(testCase);
		Sheet shTestCase = wbTestCase.getSheet("TestCase");
		int rowSize = shTestCase.getRows();
		for(int i=1;i<rowSize;i++) {
			String testCaseName=shTestCase.getCell(0,i).getContents();
			String testCaseRunmode=shTestCase.getCell(1,i).getContents();
			hm.put(testCaseName, testCaseRunmode);
		}
		}
	
}

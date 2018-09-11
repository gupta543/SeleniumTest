package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Data {
	
	public static HashMap<String, String> readExcelRow(String fName, int shtNum, int rowNum) throws IOException{
		
		HashMap<String, String> cellData = new HashMap<String, String>();
		File file = new File(fName);
		FileInputStream fis = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(shtNum);
		XSSFRow row = ws.getRow(rowNum);
		
		for(Cell cell : row){
			cellData.put(cell.getAddress().toString().split("[0-9]")[0], cell.getStringCellValue());
		}
		return cellData;
	}
	
	public static ArrayList<String> getColumnValue(String fName,int sheetNum, String address ) throws IOException
	{
		ArrayList<String> cellData = new ArrayList<String>();
		File file = new File(fName);
		FileInputStream fis = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(sheetNum);
		for (int i = 0 ;i<ws.getPhysicalNumberOfRows(); i++)
		{
			for(Cell cell: ws.getRow(i))
			{
				if(cell.getAddress().toString().split("[0-9]")[0].equals(address))
				{
					cellData.add(cell.getStringCellValue());
				}
			}
		}
		
		return cellData;
	}
	
	public static HashMap<String, String> tcData(String xfName, String tcName, int shtNum) throws IOException
	{
		HashMap<String,String> tcData = new HashMap<String,String>();
		HashMap<String,String> columnHeaders = readExcelRow(xfName,shtNum,0);
		String addressForTC = "";
		for(String key: columnHeaders.keySet())
		{
			if(columnHeaders.get(key).equals("Test Case"))
			{
				addressForTC = key;
			}
		}
		ArrayList<String> tcs = getColumnValue(xfName,shtNum,addressForTC);
		int tcNameIndex = tcs.indexOf(tcName);
//		System.out.println(tcNameIndex);
		if(tcNameIndex>-1)
		{
			HashMap<String,String> rowData = readExcelRow(xfName,shtNum,tcs.indexOf(tcName));
			for (String key: rowData.keySet())
			{
				tcData.put(columnHeaders.get(key), rowData.get(key));
			}
		}else
		{
//			System.out.println("No value found.");
		}
			
		return tcData;
	}

}



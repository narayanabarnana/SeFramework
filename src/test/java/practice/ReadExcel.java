package practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception, IOException {
		
		
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		Cell cell;
		Row row;
		
		File src=new File("C:\\Users\\Nbarnana\\Desktop\\CasePoint Updated Status.xlsx");
		workbook=new XSSFWorkbook(src);
		sheet=workbook.getSheet("Sheet1");
		//System.out.println("Sheet name is " + workbook.getSheetName(0));
		
		int NoOfSheets=workbook.getNumberOfSheets();
		System.out.println("Number of sheets are " + NoOfSheets);
		
		//To get the sheet names
		//List<String> sheetlist=new ArrayList<String>();
		for(int i=0;i<NoOfSheets;i++)
		{
			
			String sheetnames= workbook.getSheetName(i);
			System.out.println("Sheet Names are " +   sheetnames);
			
		}
		
		System.out.println("Number of rows in Excel " + workbook.getSheetName(0) + " is " + sheet.getLastRowNum());
		
		row=sheet.getRow(0);
		System.out.println(row.getCell(0));
		
		int colIndex=0;
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase("TestCase Name")) {
				colIndex=row.getCell(i).getColumnIndex();
				System.out.println("Column Index " + colIndex);
			}
		}
		
		

	}

}

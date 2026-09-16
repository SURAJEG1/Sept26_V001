package sept10_TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtility {

	
	public static Object[][] excelDriven(String filename, String sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream(filename);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowCount-1][columnCount];
		
		for(int i=1; i<rowCount; i++) 
		{
			Row row = sheet.getRow(i);
			
			//nested Loop
			for(int j=0; j<columnCount; j++) 
			{
				Cell cell = row.getCell(j);
				data[i-1][j] = cell.toString();
			}
		}
		workbook.close();
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

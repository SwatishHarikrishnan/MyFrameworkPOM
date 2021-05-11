package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xpath.objects.XStringForFSB;

public class ReadExcel {

	public static String[][] ExcelRead(String filename) throws IOException {
		//1.set up excel document path
		XSSFWorkbook Readinput = new XSSFWorkbook("D:\\SWAT_DOCUMENTS\\SELF_LEARN\\imp\\softwares\\eclipse_64bit\\pageObjectModel\\src\\data/"+filename+".xlsx");
		
		//2.set up worksheet
		XSSFSheet sheet=Readinput.getSheet("Sheet1");
				
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		
		String data[][]=new String[lastRowNum][lastCellNum];
		//5.iterating all data's inside row and column
		for(int i=1;i<=lastRowNum;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				String text = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=text;
			}
		}
		Readinput.close();
		return data;
		
	}

}

package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static FileInputStream file;
	static XSSFWorkbook wb;
	static String[] names;
	static String[] field;
	static String[] exp;
	static String[] practiseLoc;
	
	public static void setData(String[] n, String[] f, String[] e, String[] p) {
		names = n;
		field = f;
		exp = e;
		practiseLoc = p;
		
	}
	
	public static void writeIntoExcel(String[] surgeries) throws IOException {

		file = new FileInputStream(System.getProperty("user.dir") + "//testFiles//TestData.xlsx");
		wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Doctors");
		XSSFRow r = sheet.createRow(0);
		r.createCell(0).setCellValue("Doctors Names");
		r.createCell(1).setCellValue("Field");
		r.createCell(2).setCellValue("Experience");
		r.createCell(3).setCellValue("Practise Location");
		r.createCell(4).setCellValue("Surgeries List");
		r.createCell(5).setCellValue("Status");
		for(int i=0;i<surgeries.length;i++) {
			XSSFRow r1 = sheet.createRow(i+1);
			if(i<names.length) {
				r1.createCell(0).setCellValue(names[i]);
				r1.createCell(1).setCellValue(field[i]);
				r1.createCell(2).setCellValue(exp[i]);
				r1.createCell(3).setCellValue(practiseLoc[i]);
			}
			r1.createCell(4).setCellValue(surgeries[i]);
		}
		FileOutputStream fo =new FileOutputStream(System.getProperty("user.dir") + "//testFiles//TestData.xlsx");
		wb.write(fo);
		
	}
	
	public static String getData(int r, int c ) throws IOException {
		
		XSSFSheet sheet = wb.getSheet("Demo");
		XSSFCell cell = sheet.getRow(r).getCell(c);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(cell);
		return data;
		
	}
	
	
}

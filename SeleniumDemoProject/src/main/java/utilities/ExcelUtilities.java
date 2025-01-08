package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtilities {

	static FileInputStream f;
	static XSSFWorkbook wb;
	
	static XSSFSheet xs;

	public static String getStringData(int a, int b, String sheet) throws IOException {

		String filepath = Constant.TESTPATH;
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		xs = wb.getSheet(sheet);
		XSSFRow r = xs.getRow(a);
		XSSFCell c = r.getCell(b);

		return c.getStringCellValue();
	}

	public static String getIntegerData(int a, int b, String sheet) throws IOException {
		String filepath = Constant.TESTPATH;
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		xs = wb.getSheet(sheet);
		XSSFRow r = xs.getRow(a);
		XSSFCell c = r.getCell(b);
		int var = (int) c.getNumericCellValue(); // convert to integer (typecasting)
		return String.valueOf(var); // return value as string
		// to call return type : assign variable as string

	}

}
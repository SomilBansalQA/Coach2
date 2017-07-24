package org.qait.coach.Actions.coach2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelFile {
	static String giftCardFileName;
    static String creditCardFileName;
	public ExcelFile() {
		giftCardFileName = "C:"+File.separator+"Users"+File.separator+"somilbansal"+File.separator+"Desktop"+File.separator+"US.xls";
		creditCardFileName="C:"+File.separator+"Users"+File.separator+"somilbansal"+File.separator+"Desktop"+File.separator+"USCreditCardDetails.xls";
	}

	private Sheet readExcelFile(String path) {

		FileInputStream fin = null;
		try {
			fin = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(fin);
		} catch (BiffException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		Sheet sh = workbook.getSheet(0);
		return sh;
	}

	public String getGiftCardNumber(int cursor) {
		ExcelFile xls = new ExcelFile();
		Sheet sh = xls.readExcelFile(giftCardFileName);
		return sh.getCell(0, cursor).getContents();
	}

	public String getGiftCardPinNumber(int cursor) {
		ExcelFile xls = new ExcelFile();
		Sheet sh = xls.readExcelFile(giftCardFileName);
		return sh.getCell(1, cursor).getContents();
	}

	public int getNoOfRows() {
		ExcelFile xls = new ExcelFile();
		Sheet sh = xls.readExcelFile(giftCardFileName);
		return sh.getRows();

	}

	public int getNoOfColumns() {
		ExcelFile xls = new ExcelFile();
		Sheet sh = xls.readExcelFile(giftCardFileName);
		return sh.getColumns();

	}
	
	public int getNoOfRowsOfCreditCardFile() {
		ExcelFile xls = new ExcelFile();
		Sheet sh = xls.readExcelFile(giftCardFileName);
		return sh.getRows();

	}

	protected int getNoOfColumnsOfCreditCardFile() {
		ExcelFile xls = new ExcelFile();
		Sheet sh = xls.readExcelFile(giftCardFileName);
		return sh.getColumns();

	}
	
	public String getCreditCardNumber(int cursor) {
		ExcelFile xls = new ExcelFile();
		Sheet sh = xls.readExcelFile(creditCardFileName);
		return sh.getCell(0, cursor).getContents();
	}

	public String getCreditCardSecurityNumber(int cursor) {
		ExcelFile xls = new ExcelFile();
		Sheet sh = xls.readExcelFile(creditCardFileName);
		return sh.getCell(1, cursor).getContents();
	}
	
}

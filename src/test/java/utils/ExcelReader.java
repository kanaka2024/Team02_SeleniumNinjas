package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.AllArgsConstructor;
import lombok.Data;
//import utils.batchRecords;

public class ExcelReader {
	
	 @Data
	    @AllArgsConstructor
	    public static class batchRecords {
	        private String programName;
	        private String batchName;
	        private String description;
	        private String noOfClass;
			
	    }

	
/*
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public List<Map<String, String>> getData(String excelFilePath, String sheetName){
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);
	}
	public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
		return readSheet(sheet);
	}
	private Sheet getSheetByName(String excelFilePath, String sheetName)  {
		Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
	}
	private Sheet getSheetByIndex(String excelFilePath, int sheetNumber)  {
		Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
		return sheet;
	}
	private Workbook getWorkBook(String excelFilePath)  {
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(new File(excelFilePath));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		return workbook;
	}
	private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		int totalRow = sheet.getPhysicalNumberOfRows();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		int headerRowNumber = getHeaderRowNumber(sheet);
		if (headerRowNumber != -1) {
			int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
			int setCurrentRow = 1;
			for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
				row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
				}
				excelRows.add(columnMapdata);
			}
		}
		return excelRows;
	}
	private int getHeaderRowNumber(Sheet sheet) {
		Row row;
		int totalRow = sheet.getLastRowNum();
		for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
			row = getRow(sheet, currentRow);
			if (row != null) {
				int totalColumn = row.getLastCellNum();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					Cell cell;
					cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell.getCellType() == CellType.STRING) {
						return row.getRowNum();
					} else if (cell.getCellType() == CellType.NUMERIC) {
						return row.getRowNum();
					} else if (cell.getCellType() == CellType.BOOLEAN) {
						return row.getRowNum();
					} else if (cell.getCellType() == CellType.ERROR) {
						return row.getRowNum();
					}
				}
			}
		}
		return (-1);
	}
	private Row getRow(Sheet sheet, int rowNumber) {
		return sheet.getRow(rowNumber);
	}
	private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
		Cell cell;
		if (row == null) {
			if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
					.getCellType() != CellType.BLANK) {
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, "");
			}
		} else {
			cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cell.getCellType() == CellType.STRING) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				}
			} else if (cell.getCellType() == CellType.NUMERIC) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
				}
			} else if (cell.getCellType() == CellType.BLANK) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, "");
				}
			} else if (cell.getCellType() == CellType.BOOLEAN) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
				}
			} else if (cell.getCellType() == CellType.ERROR) {
				if (sheet.getRow(sheet.getFirstRowNum())
						.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
						.getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
							.getStringCellValue();
					columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
				}
			}
		}
		return columnMapdata;
	}
	
	*/
	
	//------------------------------Add New Batch read from Excel ----------------------//
	
	// Batch Module

		public List<batchRecords> readExcel_LMSPrograms(String SheetName) throws IOException {

			
			String path = System.getProperty("user.dir") + "/src/test/resources/TestData/Testdata2.xlsx";

			File Excelfile = new File(path);
			List<batchRecords> batchRecordlist = new ArrayList<>();
			FileInputStream Fis = new FileInputStream(Excelfile);
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(Fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Entered sheet in excel:" + SheetName);

			if (SheetName != null && SheetName.trim().equalsIgnoreCase("Batch")) {

				batchRecordlist = getbatchRecordlist(workbook, SheetName);
			}

			else if (SheetName != null && SheetName.trim().equalsIgnoreCase("Class")) {
				batchRecordlist = getbatchRecordlist(workbook, SheetName);
			} else {
				System.out.println("Enter valid Sheetname");
			}
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("read batch list values : " + batchRecordlist);
			return batchRecordlist;
		}
		
		
		// commom methed to Fetch the List from Data excel----- Batch Module

		private List<batchRecords> getbatchRecordlist(XSSFWorkbook workbook, String sheetName) throws IOException {
			List<batchRecords> batchRecordlist = new ArrayList<>();
			sheetName = sheetName.trim();

			XSSFSheet sheet = workbook.getSheet(sheetName);
			System.out.println("Last row index: " + sheet.getLastRowNum());

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				if (row != null) {
					String ProgramName = row.getCell(0) != null ? row.getCell(0).getStringCellValue().trim() : "";
					String BatchNo = row.getCell(1) != null ? getCellData(row.getCell(1)) : "";
					String Description = row.getCell(2) != null ? row.getCell(2).getStringCellValue().trim() : "";
					String Classcount = row.getCell(3) != null ? getCellData(row.getCell(3)) : "";
					batchRecordlist.add(new batchRecords(ProgramName, BatchNo, Description, Classcount));
				}
			}

			workbook.close();
			return batchRecordlist;
		}
		
		
		//sub method for numeric cell
		private String getCellData(Cell cell) {
			if (cell.getCellType() == CellType.NUMERIC) {
				return String.valueOf((int) cell.getNumericCellValue());
			} else {
				return cell.getStringCellValue().trim();
			}
		}
	
}

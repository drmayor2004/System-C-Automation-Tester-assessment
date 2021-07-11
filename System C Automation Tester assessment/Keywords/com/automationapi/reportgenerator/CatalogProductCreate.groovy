package com.automationapi.reportgenerator
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFSheet
import com.automationapi.utils.CellExcelFormatters
import com.kms.katalon.keyword.excel.ExcelKeywords
import internal.GlobalVariable

public class CatalogProductCreate {
	public String createProductExcelFile() {
		LocalDateTime date = LocalDateTime.now()
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss")
		String dateStr = date.format(formatters).toString()
		String fileName = "Q3 - Product Catalog - "
		String dir = "F:\\"
		GlobalVariable.excelReport = System.getProperty("user.dir") + File.separator + "ExcelReports" + File.separator + "Q3 Catalog Product" + File.separator + fileName + dateStr + ".xlsx"
		println(GlobalVariable.excelReport)
		//Create excel file
		ExcelKeywords.createExcelFile(GlobalVariable.excelReport)
		//verify excel file is created
		File excelFile = new File(GlobalVariable.excelReport)
		assert excelFile.exists().equals(true)

		//Create Authorisation Workbook
		Workbook workbook01 = ExcelKeywords.getWorkbook(GlobalVariable.excelReport)
		//Create  Excelsheet
		ExcelKeywords.createExcelSheets(workbook01, ['Create Product'])
		ExcelKeywords.saveWorkbook(GlobalVariable.excelReport, workbook01)
		workbook01 = ExcelKeywords.getWorkbook(GlobalVariable.excelReport)

		//Remove Sheet0 from excel file
		for(int i = 0; i < workbook01.getNumberOfSheets(); i++) {
			XSSFSheet tmpSheet = workbook01.getSheetAt(i)
			if(i == 0) {
				workbook01.removeSheetAt(i)
				ExcelKeywords.saveWorkbook(GlobalVariable.excelReport, workbook01)
			}
		}

		//verify excel sheets are created
		String[]expectedListSheet = ["Create Product"]
		workbook01 = ExcelKeywords.getWorkbook(GlobalVariable.excelReport)
		assert ExcelKeywords.getSheetNames(workbook01).equals(expectedListSheet)

		//Write Test Report Header
		workbook01 = ExcelKeywords.getWorkbook(GlobalVariable.excelReport)
		CellStyle cellStyle = workbook01.createCellStyle()
		cellStyle.setAlignment(HorizontalAlignment.CENTER)
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER)
		cellStyle.setFillForegroundColor(IndexedColors.GOLD.getIndex())
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND)
		//cellStyle.setBorder(BorderType.BOTTOM_BORDER, CellBorderType.THIN, Color.getBlack());
		cellStyle.setBorderBottom(BorderStyle.THIN)
		cellStyle.setBorderTop(BorderStyle.THIN)
		cellStyle.setBorderLeft(BorderStyle.THIN)
		cellStyle.setBorderRight(BorderStyle.THIN)

		for(int i = 0; i < workbook01.getNumberOfSheets(); i++) {
			Sheet sheet01 = ExcelKeywords.getExcelSheet(workbook01, workbook01.getSheetName(i))
			ExcelKeywords.setValueToCellByAddress(sheet01, "A1", "TC#")
			Row row = sheet01.getRow(0)
			Cell cell = row.getCell(0)
			cell.setCellStyle(cellStyle)
			row.setHeight((short)700) //set default height

			//Set Testcase description
			ExcelKeywords.setValueToCellByAddress(sheet01, 'B1', 'Test Case Description')
			sheet01.autoSizeColumn(1)
			row = sheet01.getRow(0)
			cell = row.getCell(1)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'C1', 'Url Endpoint')
			sheet01.autoSizeColumn(2)
			row = sheet01.getRow(0)
			cell = row.getCell(2)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'D1', 'Header Test Data' )
			sheet01.autoSizeColumn(3)
			row = sheet01.getRow(0)
			cell = row.getCell(3)
			cell.setCellStyle(cellStyle)
			ExcelKeywords.setValueToCellByAddress(sheet01, 'E1', 'JSON Body' )
			//    sheet01.autoSizeColumn(4)
			row = sheet01.getRow(0)
			cell = row.getCell(4)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'F1', 'Actual Endpoint(Url)')
			//    sheet01.autoSizeColumn(5)
			row = sheet01.getRow(0)
			cell = row.getCell(5)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'G1', 'Expected Response Code' )
			sheet01.autoSizeColumn(6)
			row = sheet01.getRow(0)
			cell = row.getCell(6)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'H1', 'Actual Response Code' )
			sheet01.autoSizeColumn(7)
			row = sheet01.getRow(0)
			cell = row.getCell(7)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'I1', 'Response Header' )
			sheet01.autoSizeColumn(8)
			row = sheet01.getRow(0)
			cell = row.getCell(8)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'J1', 'Response Body' )
			//    sheet01.autoSizeColumn(9)
			row = sheet01.getRow(0)
			cell = row.getCell(9)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'K1', 'Status' )
			sheet01.autoSizeColumn(10)
			row = sheet01.getRow(0)
			cell = row.getCell(10)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'L1', 'Release Candidate' )
			sheet01.autoSizeColumn(11)
			row = sheet01.getRow(0)
			cell = row.getCell(11)
			cell.setCellStyle(cellStyle)

			ExcelKeywords.setValueToCellByAddress(sheet01, 'M1', 'Comments' )
			sheet01.autoSizeColumn(12)
			row = sheet01.getRow(0)
			cell = row.getCell(12)
			cell.setCellStyle(cellStyle)


		}

		ExcelKeywords.saveWorkbook(GlobalVariable.excelReport, workbook01)

	}
}

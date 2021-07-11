import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.ComparisonOperator
import org.apache.poi.ss.usermodel.ConditionalFormattingRule
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.ss.usermodel.PatternFormatting
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.SheetConditionalFormatting
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.util.CellRangeAddress
import com.automationapi.utils.CellExcelFormatters
import com.kms.katalon.keyword.excel.ExcelKeywords

class Automation_API_Listener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def BeforeTestCase(TestCaseContext testCaseContext) {
		GlobalVariable.currentTestCaseId = testCaseContext.getTestCaseId();
		GlobalVariable.testCaseStatus = testCaseContext.getTestCaseStatus();
		
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def AfterTestCase(TestCaseContext testCaseContext) {
		
		//Write test result to Excel
		GlobalVariable.testStepPassedFailed = testCaseContext.getTestCaseStatus().toString();
		GlobalVariable.testCaseStatus = testCaseContext.getTestCaseStatus();
		println testCaseContext.getTestCaseStatus();
		Workbook workbook01 = ExcelKeywords.getWorkbook(GlobalVariable.excelReport);
		Sheet sheet = ExcelKeywords.getExcelSheet(workbook01, GlobalVariable.testName )
		
		//Centre cell with border
		CellStyle cellStyleCAB= workbook01.createCellStyle();
		CellExcelFormatters cellStyleCAB1 = new CellExcelFormatters();
		cellStyleCAB = cellStyleCAB1.cellCentreAlignedBorder(cellStyleCAB);
		
		//Warp Cell and Centre with border
		CellStyle cellWrap = workbook01.createCellStyle();
		CellExcelFormatters cellStyleWCAB = new CellExcelFormatters();
		cellWrap = cellStyleWCAB.cellWarpCentredBorder(cellWrap)
		
		//Write values into cells
		//ExcelKeywords.setValueToCellByIndex(sheet, 18, 10, "TEST")
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 0, GlobalVariable.tc)
				sheet.autoSizeColumn(0);
		Row row = sheet.getRow(GlobalVariable.i)
		Cell cell = row.getCell(0);
		cell.setCellStyle(cellStyleCAB);
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 1, GlobalVariable.testCase);
		//sheet.autoSizeColumn(1)
		sheet.setColumnWidth(1, 15000);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(1);
		cell.setCellStyle(cellWrap);
		
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 2, GlobalVariable.endPointData);
		sheet.autoSizeColumn(2)
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(2);
		cell.setCellStyle(cellStyleCAB);
		
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 3, GlobalVariable.headerTestData);
		sheet.autoSizeColumn(3)
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(3);
		cell.setCellStyle(cellStyleCAB);
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 4, GlobalVariable.jsonBody);
		sheet.setColumnWidth(4, 15000);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(4);
		cell.setCellStyle(cellWrap);
				
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 5, GlobalVariable.actualUrl);
		//sheet.autoSizeColumn(5)
		sheet.setColumnWidth(5, 8000);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(5);
		cell.setCellStyle(cellWrap);
		
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 6, GlobalVariable.expectedResponseCode);
		sheet.autoSizeColumn(6)
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(6);
		cell.setCellStyle(cellStyleCAB);
		
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 7, GlobalVariable.actualResponseCode);
		sheet.autoSizeColumn(7);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(7);
		cell.setCellStyle(cellStyleCAB);
		
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 8, GlobalVariable.responseHeader);
		sheet.setColumnWidth(8, 15000);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(8);
		cell.setCellStyle(cellWrap);
			
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 9, GlobalVariable.bodyMessage);
		sheet.setColumnWidth(9, 15000);
		row.setHeight((short) 1000);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(9);
		cell.setCellStyle(cellWrap);
		
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 10, GlobalVariable.testCaseStatus);
		sheet.setColumnWidth(10, 2500);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(10);
		cell.setCellStyle(cellStyleCAB);
		
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 11, GlobalVariable.releaseCandidate);
		sheet.autoSizeColumn(11);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(11);
		cell.setCellStyle(cellStyleCAB);
		
		ExcelKeywords.setValueToCellByIndex(sheet, GlobalVariable.i, 12, GlobalVariable.comment);
		sheet.autoSizeColumn(12);
		row = sheet.getRow(GlobalVariable.i);
		cell = row.getCell(12);
		cell.setCellStyle(cellStyleCAB);
		
		ExcelKeywords.saveWorkbook(GlobalVariable.excelReport, workbook01)

		//Set conditional Formatting for PASSED, FAILED and NOT Executed
		Workbook workbook = ExcelKeywords.getWorkbook(GlobalVariable.excelReport);
		Sheet sheet01 = workbook.getSheet(GlobalVariable.testName);
		
		SheetConditionalFormatting sheetConditionalFormatting = sheet01.getSheetConditionalFormatting();
		
		//Rule Passed
		ConditionalFormattingRule rulePassed = sheetConditionalFormatting.createConditionalFormattingRule(ComparisonOperator.EQUAL, "\"PASSED\"");
		PatternFormatting fill1 = rulePassed.createPatternFormatting();
		fill1.setFillBackgroundColor(IndexedColors.GREEN.index);
		fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
				
		//Rule Failed
		ConditionalFormattingRule ruleFailed = sheetConditionalFormatting.createConditionalFormattingRule(ComparisonOperator.EQUAL, "\"FAILED\"");
		PatternFormatting fill2 = ruleFailed.createPatternFormatting();
		fill2.setFillBackgroundColor(IndexedColors.DARK_RED.index);
		fill2.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
				
		//Rule Not Executed
		ConditionalFormattingRule ruleNotExecuted = sheetConditionalFormatting.createConditionalFormattingRule(ComparisonOperator.EQUAL, "\"NOT EXECUTED\"");
		PatternFormatting fill3 = ruleNotExecuted .createPatternFormatting();
		fill3.setFillBackgroundColor(IndexedColors.ORANGE.index);
		fill3.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
		CellRangeAddress[] regions = [CellRangeAddress.valueOf("K1:K1000")];
		sheetConditionalFormatting.addConditionalFormatting(regions, rulePassed, ruleFailed, ruleNotExecuted);
		
		//save workbook
		ExcelKeywords.saveWorkbook(GlobalVariable.excelReport, workbook)
		
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def BeforeTestSuite(TestSuiteContext testSuiteContext) {
	
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def AfterTestSuite(TestSuiteContext testSuiteContext) {

	}
}
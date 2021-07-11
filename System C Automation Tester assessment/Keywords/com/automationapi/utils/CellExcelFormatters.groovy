package com.automationapi.utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.poi.ss.usermodel.BorderStyle
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.ss.usermodel.VerticalAlignment
import org.apache.poi.xssf.usermodel.XSSFColor

import internal.GlobalVariable

public class CellExcelFormatters {
	/**cell Centre and Aligned Border
	 *
	 * @param cellStyleCAB
	 * @return
	 */

	public CellStyle cellCentreAlignedBorder(CellStyle cellStyleCAB) {
		cellStyleCAB.setAlignment(HorizontalAlignment.CENTER)
		cellStyleCAB.setVerticalAlignment(VerticalAlignment.CENTER)
		cellStyleCAB.setBorderBottom(BorderStyle.THIN)
		cellStyleCAB.setBorderTop(BorderStyle.THIN)
		cellStyleCAB.setBorderLeft(BorderStyle.THIN)
		cellStyleCAB.setBorderRight(BorderStyle.THIN)
		return cellStyleCAB
	}

	/**Warping text within a cell
	 *
	 * @param cellWrap
	 * @return
	 */
	public CellStyle cellWarpCentredBorder(CellStyle cellWrap) {
		cellWrap.setWrapText(true)
		cellWrap.setVerticalAlignment(VerticalAlignment.CENTER)
		cellWrap.setBorderBottom(BorderStyle.THIN)
		cellWrap.setBorderTop(BorderStyle.THIN)
		cellWrap.setBorderLeft(BorderStyle.THIN)
		cellWrap.setBorderRight(BorderStyle.THIN)
		return cellWrap
	}


	/** Fill Cell with grey
	 *
	 * @param greyFilled25
	 * @return
	 */
	public CellStyle cell25GreyFilledCentred(CellStyle greyFilled25) {
		greyFilled25.setAlignment(HorizontalAlignment.CENTER)
		greyFilled25.setVerticalAlignment(VerticalAlignment.CENTER)
		greyFilled25.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex())
		greyFilled25.setFillPattern(FillPatternType.SOLID_FOREGROUND)
		greyFilled25.setBorderBottom(BorderStyle.THIN)
		greyFilled25.setBorderTop(BorderStyle.THIN)
		greyFilled25.setBorderLeft(BorderStyle.THIN)
		greyFilled25.setBorderRight(BorderStyle.THIN)

		//	greyfilled25.setBorderBottom(BorderStyle.THIN)
		//	cellStyle01.setBorderTop(BorderStyle.THIN)
		//	cellStyle01.setBorderLeft(BorderStyle.THIN)
		//	cellStyle01.setBorderRight(BorderStyle.THIN)

		return greyFilled25
	}

	/**Fill cell with light blue
	 *
	 * @param lightBlueFilled
	 * @return
	 */
	public CellStyle cellLightBlueFilled(CellStyle lightBlueFilled){
		lightBlueFilled.setAlignment(HorizontalAlignment.CENTER)
		lightBlueFilled.setVerticalAlignment(VerticalAlignment.CENTER)
		lightBlueFilled.setFillForegroundColor(new XSSFColor(new java.awt.Color(135,206,250)))
		lightBlueFilled.setFillPattern(FillPatternType.SOLID_FOREGROUND)
		lightBlueFilled.setBorderBottom(BorderStyle.THIN)
		lightBlueFilled.setBorderTop(BorderStyle.THIN)
		lightBlueFilled.setBorderLeft(BorderStyle.THIN)
		lightBlueFilled.setBorderRight(BorderStyle.THIN)

		//	style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(128, 0, 128)));
		//	style1.setFillPattern(CellStyle.SOLID_FOREGROUND);

		return lightBlueFilled

	}
}

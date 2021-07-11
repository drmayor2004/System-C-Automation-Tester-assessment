package com.automationapi.testcasecounter

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
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


import internal.GlobalVariable as GlobalVariable


@Singleton
public class ProductCatalogTestcaseCounter {

	//Count Create user account test case
	public createProductTestcaseCounter() {
		//Get excel test data file location
		String projectPath  = System.getProperty("user.dir")
		File openExcelPath = new File(projectPath + File.separator + "Data Driven Files" +
				File.separator + "Test Data.xlsx" )
		FileInputStream openExcelFile = new FileInputStream(openExcelPath)

		//Open excel and get all sheets
		XSSFWorkbook workbook = new XSSFWorkbook(openExcelFile)

		//CreateProduct
		XSSFSheet createProduct = workbook.getSheet("Modify Product - Put")
		GlobalVariable.totalCreateProduct = createProduct.getLastRowNum()

		//Modify Product
		XSSFSheet modifyProduct = workbook.getSheet("Create Product - Post")
		GlobalVariable.totalModifyProduct = modifyProduct.getLastRowNum()

		//Get All Product
		XSSFSheet getAllProduct = workbook.getSheet("Retrieve - All Products")
		GlobalVariable.totalGetAllProduct = getAllProduct.getLastRowNum()
		
		//Get Single Product
		XSSFSheet getSingleProduct = workbook.getSheet("Retrieve - Single Product")
		GlobalVariable.totalGetSingleProduct = getSingleProduct.getLastRowNum()
		
		//Get Single Product
		XSSFSheet removeProduct = workbook.getSheet("Remove Product")
		GlobalVariable.totalRemoveProduct = removeProduct.getLastRowNum()
		
		



		//count total number of Testcases
		GlobalVariable.totalNumberOfTestCase = GlobalVariable.totalCreateProduct + GlobalVariable.totalModifyProduct + GlobalVariable.totalGetAllProduct + GlobalVariable.totalGetSingleProduct + GlobalVariable.totalRemoveProduct 
	}

}

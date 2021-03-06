import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.automationapi.testcasecounter.ProductCatalogTestcaseCounter as ProductCatalogTestcaseCounter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.keyword.builtin.VerifyElementPropertyValueKeyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.transform.Field
import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject


//Count total number of Testcases in Create Product
ProductCatalogTestcaseCounter createProductTcCounter = ProductCatalogTestcaseCounter.instance;
createProductTcCounter.createProductTestcaseCounter();


GlobalVariable.testCaseName = "Create Product";  //Set testName

//Reset Global Varibale to null
GlobalVariable.actualResponseBody = null;
GlobalVariable.actualResponseCode = null;
GlobalVariable.actualUrl = null;
GlobalVariable.expectedResponseCode = null;
GlobalVariable.tc = null;
GlobalVariable.testCase = null;
GlobalVariable.endPointData = null;
GlobalVariable.headerTestData = null;
GlobalVariable.jsonBody = null;
GlobalVariable.releaseCandidate = null;
GlobalVariable.comment = null;

//Setting up default values
GlobalVariable.testName = 'Create Product';
GlobalVariable.testCase = testCases
GlobalVariable.tc = tc
GlobalVariable.endPointData = GlobalVariable.endPointUrl;
GlobalVariable.headerTestData = 'N/A';
String description = description
String price = price
String itemCount = itemCount
Boolean isActive = isActive
String productName
//getting expectedResponse code to Excel
GlobalVariable.expectedResponseCode = expectedResponseCode;

//
long parseCreatedDateDay = Long.parseLong(createdDateDay)
long parseCreatedDateHour = Long.parseLong(createdDateHour )
long parseCreatedDateMinute = Long.parseLong(createdDateMinute)
long parseCreatedDateSecond = Long.parseLong(createdDateSecond )
long parseModifiedDateDay = Long.parseLong(modifiedDateDay)
long parseModifiedDateHour = Long.parseLong(modifiedDateHour)
long parseModifiedDateMinute = Long.parseLong(modifiedDateMinute)
long parseModifiedDateSecond = Long.parseLong(modifiedDateSecond )

getCreatedDateTime = ZonedDateTime.now().plusDays(parseCreatedDateDay).plusHours(parseCreatedDateHour).plusMinutes(parseCreatedDateMinute).plusSeconds(parseCreatedDateMinute)
getModifiedDateTime = ZonedDateTime.now().plusDays(parseModifiedDateDay).plusHours(parseModifiedDateHour).plusMinutes(parseModifiedDateMinute).plusSeconds(parseModifiedDateSecond)
createdDateTime = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss\'Z\'').format(getCreatedDateTime)
modifiedDateTime = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss\'Z\'').format(getModifiedDateTime)

//Generate Random number
Random rand = new Random(); //instance of random class
int upperbound = 500;
  //generate random values from 0-24
int int_random = rand.nextInt(upperbound);

if (name.equals("")){
	productName = ""
}
else {
	productName = name + int_random
}

//Setting up request body
RequestObject request = findTestObject('Create Product', [('url'): GlobalVariable.endPointUrl, ("id"): id,
	("name"): productName, ("description"): description, ("price"): price, ("itemCount"): itemCount, ("isActive"): isActive, ("createdDateTime"): createdDateTime, ("modifiedDateTime"): modifiedDateTime])


//Getting the actual url and jsonBody values to spreadsheet
GlobalVariable.actualUrl = request.getRestUrl();
GlobalVariable.jsonBody = request.getHttpBody();

//Sending request body to endpoint url
response = WS.sendRequest(request);

int actualResponseCode = Integer.valueOf(response.getStatusCode());
int expectedResponseCode = Integer.valueOf(expectedResponseCode)




//Verify Response body and Response Code
if(expectedResponseCode == actualResponseCode) {
	GlobalVariable.actualResponseCode = actualResponseCode;
	GlobalVariable.bodyMessage = response.getResponseBodyContent();
	GlobalVariable.responseHeader = response.getHeaderFields();
	//verify reponse code
	WS.verifyResponseStatusCode(response, expectedResponseCode);
	WS.verifyElementPropertyValue(response, "name", productName)
	WS.verifyElementPropertyValue(response, "description", description)
	WS.verifyElementPropertyValue(response, "price", price)
	WS.verifyElementPropertyValue(response, "itemCount", itemCount )
	WS.verifyElementPropertyValue(response, "isActive", isActive)
	
}
else {
	GlobalVariable.actualResponseCode = actualResponseCode;
	GlobalVariable.bodyMessage = response.getResponseBodyContent();
	GlobalVariable.responseHeader = response.getHeaderFields();
	WS.verifyResponseStatusCode(response, expectedResponseCode);
	WS.verifyElementPropertyValue(response, "name", productName)
	WS.verifyElementPropertyValue(response, "description", description)
	WS.verifyElementPropertyValue(response, "price", price)
	WS.verifyElementPropertyValue(response, "itemCount", itemCount)
	WS.verifyElementPropertyValue(response, "isActive", isActive)
	
}




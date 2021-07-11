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

import groovy.json.JsonSlurper
import groovy.transform.Field
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject


//Count total number of Testcases in Create Product
ProductCatalogTestcaseCounter createProductTcCounter = ProductCatalogTestcaseCounter.instance;
createProductTcCounter.createProductTestcaseCounter();


GlobalVariable.testCaseName = "Remove Product";  //Set testName

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
GlobalVariable.testName = 'Remove Product';
GlobalVariable.testCase = testCases
GlobalVariable.tc = tc
GlobalVariable.endPointData = GlobalVariable.endPointUrl;
GlobalVariable.headerTestData = 'N/A';


//getting expectedResponse code to Excel
GlobalVariable.expectedResponseCode = expectedResponseCode;



String itemId
String deleteUrl
if (productStatus.equals("invalid")) {
	itemId = "aab45096-e8d7-45ff-8996-70f14d3ff160"
	deleteUrl = GlobalVariable.endPointUrl + itemId

}
else {

	//Generate Random number
	Random rand = new Random(); //instance of random class
	int upperbound = 500;
	  //generate random values from 0-24
	int int_random = rand.nextInt(upperbound);
	String randName = name + int_random
	//Setting up request body
	RequestObject createRequest = findTestObject('Create Product-DEL', [('url'): GlobalVariable.endPointUrl, ("name"): randName])		
	createResponse = WS.sendRequest(createRequest);
	int createResponseCode = createResponse.getStatusCode();
	println createResponseCode

	def jsonSlurper = new JsonSlurper();
	def tokenObject = jsonSlurper.parseText(createResponse.getResponseBodyContent());
	println(tokenObject.id);
	itemId = tokenObject.id
	println(itemId);
	deleteUrl = GlobalVariable.endPointUrl + itemId
	
}


RequestObject deleteRequest = findTestObject('Delete Product', [('url'): deleteUrl])

//Getting the actual url and jsonBody values to spreadsheet
GlobalVariable.actualUrl = deleteRequest.getRestUrl();
GlobalVariable.jsonBody = "N/A"



//Sending Delete request body to endpoint url
deleteResponse = WS.sendRequest(deleteRequest);

int actualResponseCode = Integer.valueOf(deleteResponse.getStatusCode());
int expectedResponseCode = Integer.valueOf(expectedResponseCode)

//Verify Response body and Response Code
if(expectedResponseCode == actualResponseCode) {
	GlobalVariable.actualResponseCode = actualResponseCode;
	GlobalVariable.bodyMessage = deleteResponse.getResponseBodyContent();
	GlobalVariable.responseHeader = deleteResponse.getHeaderFields();
	//verify reponse code
	WS.verifyResponseStatusCode(deleteResponse, expectedResponseCode);
	
	//confirm Deletion
	String endpointActualUrl = deleteUrl
	//Send the request to get products
	RequestObject getSingleProducts = findTestObject('Get All Product', [('url') : endpointActualUrl, ('itemId'): itemId]);
	//Sending request body to endpoint url
	confirmDeletedResponse = WS.sendRequest(getSingleProducts);
    GlobalVariable.releaseCandidate = confirmDeletedResponse.getResponseBodyContent();
	GlobalVariable.comment = confirmDeletedResponse.getHeaderFields();
}
else {
	GlobalVariable.actualResponseCode = actualResponseCode;
	GlobalVariable.bodyMessage = deleteResponse.getResponseBodyContent();
	GlobalVariable.responseHeader = deleteResponse.getHeaderFields();
	WS.verifyResponseStatusCode(deleteResponse, expectedResponseCode);
}




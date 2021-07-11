import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.automationapi.testcasecounter.ProductCatalogTestcaseCounter as ProductCatalogTestcaseCounter
import com.kms.katalon.core.testobject.RequestObject

//Count total number of Testcases in Retrieve Single Product
if (GlobalVariable.totalNumberOfTestCase == 0) {
	ProductCatalogTestcaseCounter modifyProductTcCounter = ProductCatalogTestcaseCounter.instance;
	modifyProductTcCounter.createProductTestcaseCounter();
	}
	
GlobalVariable.testCaseName = "Retrieve - Single Product";  //Set testName
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
GlobalVariable.bodyMessage = null;
GlobalVariable.responseHeader = null;

//Setting up default values
GlobalVariable.testName = 'Retrieve - Single Product';
GlobalVariable.testCase = testCases
GlobalVariable.tc = tc
GlobalVariable.endPointData = enpointURL;
GlobalVariable.headerTestData = 'N/A';


//getting expectedResponse code to Excel
GlobalVariable.expectedResponseCode = expectedResponseCode;

String endpointActualUrl = enpointURL + itemId
//Send the request to get products
RequestObject getSingleProducts = findTestObject('Get All Product', [('url') : endpointActualUrl, ('itemId'): itemId]);
//Getting the actual url and jsonBody values to spreadsheet

//Getting the actual url and jsonBody values to spreadsheet
GlobalVariable.actualUrl = getSingleProducts.getRestUrl();
GlobalVariable.jsonBody = "N/A"

//Sending request body to endpoint url
response = WS.sendRequest(getSingleProducts);

int actualResponseCode = Integer.valueOf(response.getStatusCode());
int expectedResponseCode = Integer.valueOf(expectedResponseCode)

//Verify Response body and Response Code
if(expectedResponseCode == actualResponseCode) {
	GlobalVariable.actualResponseCode = actualResponseCode;
	GlobalVariable.bodyMessage = response.getResponseBodyContent();
	GlobalVariable.responseHeader = response.getHeaderFields();
	//verify reponse code
	WS.verifyResponseStatusCode(response, expectedResponseCode);
}
else {
	GlobalVariable.actualResponseCode = actualResponseCode;
	GlobalVariable.bodyMessage = response.getResponseBodyContent();
	GlobalVariable.responseHeader = response.getHeaderFields();
	WS.verifyResponseStatusCode(response, expectedResponseCode);
}




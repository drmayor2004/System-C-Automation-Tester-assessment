import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import com.automationapi.testcasecounter.ProductCatalogTestcaseCounter
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable


//Count total number of Testcases in Catalog Create Product
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

//Setting up default values for variables
GlobalVariable.testName = 'Create Product';
GlobalVariable.testCase = testCases
GlobalVariable.tc = tc;
GlobalVariable.endPointData = GlobalVariable.endPointUrl;
GlobalVariable.headerTestData = 'N/A';
String description = description;
String price = price;
String itemCount = itemCount;
Boolean isActive = isActive;
String productName;

//getting expectedResponse code to Excel
GlobalVariable.expectedResponseCode = expectedResponseCode;

//Formatting date and time
long parseCreatedDateDay = Long.parseLong(createdDateDay);
long parseCreatedDateHour = Long.parseLong(createdDateHour );
long parseCreatedDateMinute = Long.parseLong(createdDateMinute);
long parseCreatedDateSecond = Long.parseLong(createdDateSecond );
long parseModifiedDateDay = Long.parseLong(modifiedDateDay);
long parseModifiedDateHour = Long.parseLong(modifiedDateHour);
long parseModifiedDateMinute = Long.parseLong(modifiedDateMinute);
long parseModifiedDateSecond = Long.parseLong(modifiedDateSecond );
getCreatedDateTime = ZonedDateTime.now().plusDays(parseCreatedDateDay).plusHours(parseCreatedDateHour).plusMinutes(parseCreatedDateMinute).plusSeconds(parseCreatedDateMinute);
getModifiedDateTime = ZonedDateTime.now().plusDays(parseModifiedDateDay).plusHours(parseModifiedDateHour).plusMinutes(parseModifiedDateMinute).plusSeconds(parseModifiedDateSecond);
createdDateTime = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss\'Z\'').format(getCreatedDateTime);
modifiedDateTime = DateTimeFormatter.ofPattern('yyyy-MM-dd\'T\'HH:mm:ss\'Z\'').format(getModifiedDateTime);

//Generate Random number to make product name unique
Random rand = new Random(); //instance of random class
int upperbound = 5000;
  //generate random values from 0-24
int int_random = rand.nextInt(upperbound);

//Remove generated random number from the name when testing name = ""
if (name.equals("")){
	productName = "";
	}
else {
	productName = name + int_random;
	}

//Setting up requestbody/json payload
RequestObject request = findTestObject('Create Product', [('url'): GlobalVariable.endPointUrl, ("id"): id,
	("name"): productName, ("description"): description, ("price"): price, ("itemCount"): itemCount, ("isActive"): isActive, ("createdDateTime"): createdDateTime, ("modifiedDateTime"): modifiedDateTime]);

//Getting the actual url and jsonBody values to spreadsheet
GlobalVariable.actualUrl = request.getRestUrl();
GlobalVariable.jsonBody = request.getHttpBody();

//Sending request body or payload to endpoint url
response = WS.sendRequest(request);
//convert responsecode to integer
int actualResponseCode = Integer.valueOf(response.getStatusCode());
int expectedResponseCode = Integer.valueOf(expectedResponseCode);

//Verify Response body and Response Code
if(expectedResponseCode == actualResponseCode) {
	GlobalVariable.actualResponseCode = actualResponseCode;
	GlobalVariable.bodyMessage = response.getResponseBodyContent();
	GlobalVariable.responseHeader = response.getHeaderFields();
	//verify response code
	WS.verifyResponseStatusCode(response, expectedResponseCode);
	//verify response body content
	WS.verifyElementPropertyValue(response, "name", productName);
	WS.verifyElementPropertyValue(response, "description", description);
	WS.verifyElementPropertyValue(response, "price", price);
	WS.verifyElementPropertyValue(response, "itemCount", itemCount );
	WS.verifyElementPropertyValue(response, "isActive", isActive);
	}
else {
	GlobalVariable.actualResponseCode = actualResponseCode;
	GlobalVariable.bodyMessage = response.getResponseBodyContent();
	GlobalVariable.responseHeader = response.getHeaderFields();
	//verify response code
	WS.verifyResponseStatusCode(response, expectedResponseCode);
	//verify response body content
	WS.verifyElementPropertyValue(response, "name", productName);
	WS.verifyElementPropertyValue(response, "description", description);
	WS.verifyElementPropertyValue(response, "price", price);
	WS.verifyElementPropertyValue(response, "itemCount", itemCount);
	WS.verifyElementPropertyValue(response, "isActive", isActive);
	}




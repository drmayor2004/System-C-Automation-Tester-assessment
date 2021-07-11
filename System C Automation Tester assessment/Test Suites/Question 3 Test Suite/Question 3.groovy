import com.automationapi.reportgenerator.CatalogProductCreate
import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase
import internal.GlobalVariable

/**
 * Some methods below are samples for using SetUp/TearDown in a test suite.
 */

/**
 * Setup test suite environment.
 */
@SetUp(skipped = false) // Please change skipped to be false to activate this method.
def setUp() {
	CatalogProductCreate createReports = new CatalogProductCreate()
	createReports.createProductExcelFile();	
}

/**
 * Clean test suites environment.
 */
@TearDown(skipped = false) // Please change skipped to be false to activate this method.
def tearDown() {
		
	//Reset GlobalVariable i to zero after test suite execution is completed
	GlobalVariable.i = 0; 
}

/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = true) // Please change skipped to be false to activate this method.
def setupTestCase() {
	// Put your code here.
}

/**
 * Run after each test case ends.
 */
@TearDownTestCase(skipped = false) // Please change skipped to be false to activate this method.
def tearDownTestCase() {
	
	println("GlobalVariable.i = " + GlobalVariable.i )	
	println("GlobalVariable.totalNumberOfTestCase " + GlobalVariable.totalNumberOfTestCase )	
	if (GlobalVariable.i <= GlobalVariable.totalNumberOfTestCase) {		
		GlobalVariable.i = GlobalVariable.i + 1;
		println("GlobalVariable.i for IF= " + GlobalVariable.i )		
	}
	else {
		GlobalVariable.i = 1;
		println("GlobalVariable.i for Else  = " + GlobalVariable.i )		
   }   
}

/**
 * References:
 * Groovy tutorial page: http://docs.groovy-lang.org/next/html/documentation/
 */
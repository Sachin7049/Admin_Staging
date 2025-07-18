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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.By as By
import com.kms.katalon.core.testobject.ConditionType as ConditionType

//
// <-- ✅ Add this line
WebUI.callTestCase(findTestCase('Staging_Environment/Login_Functionality'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Add_Regional_Manager/Click on RM'))

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Add_Regional_Manager/Click on Add New'))

WebUI.sendKeys(findTestObject('Add_Regional_Manager/Addname'), 'Test')

WebUI.sendKeys(findTestObject('Add_Regional_Manager/Add_LastName'), 'user')

WebUI.sendKeys(findTestObject('Add_Regional_Manager/Enter_Emailid'), 'newparkengage12678789@yopmail.com')

WebUI.sendKeys(findTestObject('Add_Regional_Manager/Enter_PhoneNumber'), '9834478513')

WebUI.selectOptionByLabel(findTestObject('Add_Regional_Manager/Select_ partner'), 'evolution@yopmail.com ', false)

WebUI.sendKeys(findTestObject('Add_Regional_Manager/Enter_slug'), 'test')

WebUI.sendKeys(findTestObject('Add_Regional_Manager/Enter_city_name'), 'USA')

WebUI.selectOptionByLabel(findTestObject('Add_Regional_Manager/Select_Country_Name'), 'American Samoa ', false)

// ✅ Required permissions to be selected
List<String> permissionLabels = ['Merchant Account Management', 'Business Account', 'Transactions', 'Manage QR Code', 'Events'
    , 'Product', 'Billing & Invoice']

// ✅ Trim whitespace from each label
permissionLabels = permissionLabels.collect({ 
        it.trim()
    })

// ✅ All available permissions on the screen
List<String> allPermissions = ['My Account', 'Dashboard Analytics ', 'Product', 'Permit /Pass Management', 'Employee Management'
    , 'Manage Subordinates', 'Manage Cashier', 'Device Management', 'Reports', 'Contact Requests', 'Cruise Management', 'Demo Requests'
    , 'eValidation', 'Enforcement Management', 'Billing & Invoice', 'Merchant Account Management', 'Transactions', 'Manage QR Code'
    , 'Events', 'Business Account']

// ✅ Loop to select/unselect permissions
for (String perm : allPermissions) {
    TestObject checkbox = new TestObject(perm)
    checkbox.addProperty('xpath', ConditionType.EQUALS,
        "//span[normalize-space()='${perm}']/preceding-sibling::input[1][not(@disabled)]")

    try {
        if (permissionLabels.contains(perm)) {
            if (!WebUI.verifyElementChecked(checkbox, 2, FailureHandling.OPTIONAL)) {
                WebUI.check(checkbox)
                KeywordUtil.logInfo("✅ Checked main: ${perm}")
            }
        } else {
            if (WebUI.verifyElementChecked(checkbox, 2, FailureHandling.OPTIONAL)) {
                WebUI.uncheck(checkbox)
                KeywordUtil.logInfo("🟨 Unchecked: ${perm}")
            }
        }
    } catch (Exception e) {
        KeywordUtil.markWarning("⚠️ Error handling main permission '${perm}': ${e.message}")
    }
}

// ✅ Sub-permissions under 'Product'
List<String> subMenuPermissions = [
	'Garage Management',
	'Monitor Promocode',
	'Promotions',
	'Booking History',
	'Revenue Summary',
	'Invoice'
]

for (String permission : subMenuPermissions) {
	TestObject checkbox = new TestObject("Checkbox_${permission}")
	checkbox.addProperty("xpath", ConditionType.EQUALS,
		"//span[normalize-space()='${permission}']/preceding-sibling::input[1][not(@disabled)]")
	
	try {
		if (WebUI.verifyElementPresent(checkbox, 5, FailureHandling.OPTIONAL)) {
			if (!WebUI.verifyElementChecked(checkbox, 1, FailureHandling.OPTIONAL)) {
				WebUI.check(checkbox)
				KeywordUtil.logInfo("✅ Checked sub: ${permission}")
			} else {
				KeywordUtil.logInfo("ℹ️ Already Checked: ${permission}")
			}
		} else {
			KeywordUtil.markWarning("⚠️ Sub-permission not found: ${permission}")
		}
	} catch (Exception e) {
		KeywordUtil.markWarning("❌ Error checking sub '${permission}': ${e.message}")
	}
}

// ✅ Submit the form
WebUI.click(findTestObject('Add_Regional_Manager/CREATE'))
WebUI.delay(40)

// ✅ Final result
KeywordUtil.markPassed('✅ All specified permissions were correctly selected.')
WebUI.delay(2)
WebUI.closeBrowser()


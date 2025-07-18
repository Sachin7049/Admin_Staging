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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://staging-admin.parkengage.com/')

WebUI.waitForElementPresent(findTestObject('Login_Page_Objects/Login_Button'), 20)

WebUI.click(findTestObject('Login_Page_Objects/Login_Button'))

WebUI.waitForElementPresent(findTestObject('Login_Page_Objects/Email_Password_Field'), 20)

WebUI.setText(findTestObject('Login_Page_Objects/Email_Input_Field'), email)

WebUI.setEncryptedText(findTestObject('Login_Page_Objects/Email_Password_Field'), '8ONjX3ggx5TCf8aO14KwWA==')

WebUI.click(findTestObject('Login_Page_Objects/Login_Submit_Button'))

WebUI.delay(10)

WebUI.click(findTestObject('Dashboard_Analytics/Dashboard_Analytics_Menu'))

WebUI.waitForElementPresent(findTestObject('Dashboard_Analytics/Partner_Selection'), 20)

WebUI.click(findTestObject('Dashboard_Analytics/Partner_Selection'))

WebUI.delay(2)

WebUI.click(findTestObject('Dashboard_Analytics/Partner_USM'))

WebUI.delay(2)

WebUI.click(findTestObject('Dashboard_Analytics/Go_Button_Partner'))

WebUI.switchToWindowIndex(1)

WebUI.acceptAlert()


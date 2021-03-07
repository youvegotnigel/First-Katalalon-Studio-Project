package orrageHRM.login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Before
	def open_browser() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
	}
	
	@Given("I navigate to orrage HRM page")
	def navigate_to_login() {
		
//		if(WebUI.callTestCase(findTestCase('Test Cases/UI Tests/Page Objects/Is_Logged_In'), [:], FailureHandling.OPTIONAL)) {
//			return true
//		}
		WebUI.navigateToUrl(GlobalVariable.LOGIN_URL)
	}

	@When('I enter invalid username "(.+)"')
	def enter_username(String un) {
		WebUI.setText(findTestObject('Object Repository/Login/Page_OrangeHRM/username'), un)
	}
	
	@And('I enter invalid password "(.+)"')
	def enter_password(String pw) {
		WebUI.setText(findTestObject('Object Repository/Login/Page_OrangeHRM/password'), pw)
	}
	
	@And('I click on login button')
	def click_login() {
		WebUI.click(findTestObject('Object Repository/Login/Page_OrangeHRM/login_btn'), FailureHandling.STOP_ON_FAILURE)
	}
	
	@Then('System should display error message "(.+)"')
	def display_error_msg(String msg) {
		
		String expected_result = GlobalVariable.LOGIN_ERROR_MSG;
		WebUI.verifyEqual(expected_result, msg)	
	}
	
	@After
	def close_browser() {
		WebUI.closeBrowser()
	}
}
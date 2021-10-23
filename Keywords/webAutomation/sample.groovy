package webAutomation

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.ConcurrentHashMap.KeySetView

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

import internal.GlobalVariable

public class sample {

	WebActions actions = new WebActions();
	Verifications verifications = new Verifications();

	@Keyword
	def searchForApplication(def searchText) {
		actions.sendKeys(findTestObject('Object Repository/searchBox'), searchText);

		actions.click(findTestObject('Object Repository/searchbutton'));
	}

	@Keyword
	def clickOnApplicationUrl() {
		actions.click(findTestObject('Object Repository/appUrl'));
	}

	@Keyword
	def clickOnContact() {
		actions.click(findTestObject('Object Repository/contactButton'));
	}

	@Keyword
	def fillTheDetails(def name, def email, def number, def companyName) {
		enterName(name);
		enterEmail(email);
		enterContact(number);
		enterCompanyName(companyName);
	}

	@Keyword
	def enterName(def name) {
		actions.sendKeys(findTestObject('Object Repository/nameField'), name);
	}

	@Keyword
	def enterEmail(def email) {
		actions.sendKeys(findTestObject('Object Repository/emailField'), email);
	}
	@Keyword
	def enterContact(def number) {
		actions.sendKeys(findTestObject('Object Repository/contactNumber'), number);
	}

	@Keyword
	def enterCompanyName(def companyName) {
		actions.sendKeys(findTestObject('Object Repository/companyName'), companyName);
	}
	
	@Keyword
	def clickOnYesTellUsMore() {
		actions.click(findTestObject('Object Repository/submitTheForm'));
		verifications.verifyElementPresent(findTestObject('Object Repository/confirmMessage'), "The form not submitted successfullly");
	}
}

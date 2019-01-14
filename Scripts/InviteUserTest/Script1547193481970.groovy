import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat as SimpleDateFormat
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.callTestCase(findTestCase('LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('NavigateToInvitePageTest'), [:], FailureHandling.STOP_ON_FAILURE)

String emailAddress = ('angelino+' + getDateTime()) + '@staff.com'

WebUI.waitForElementVisible(findTestObject('Invite Team Page/Text Fields/emailField'), 60)

WebUI.setText(findTestObject('Invite Team Page/Text Fields/emailField'), emailAddress)

'Select by clicking Manager access level'
WebUI.click(findTestObject('Invite Team Page/Radio Buttons/managerAccessLevel'))

'Scroll to view Invite button'
WebUI.scrollToElement(findTestObject('Invite Team Page/Buttons or Links/submitButtonForExpandedForm'), 0)

'Click Invite button'
WebUI.click(findTestObject('Invite Team Page/Buttons or Links/submitButtonForExpandedForm'))

'Wait for success message to display'
WebUI.waitForElementPresent(findTestObject('Invite Team Page/Notifications/successMessage'), 0)

'Verify success message is present'
WebUI.verifyElementPresent(findTestObject('Invite Team Page/Notifications/successMessage'), 0)

WebUI.click(findTestObject('Invite Team Page/Buttons or Links/Manage Users Link'))

WebUI.waitForElementVisible(findTestObject('Manage Users Page/Text/Name Column'), 60)

WebUI.verifyTextPresent(emailAddress, false)

WebUI.closeBrowser()

String getDateTime() {
    SimpleDateFormat nowDateTime = new SimpleDateFormat('yyyyMMddHHmmsss')

    Date now = new Date()

    String strDate = nowDateTime.format(now)

    return strDate
}


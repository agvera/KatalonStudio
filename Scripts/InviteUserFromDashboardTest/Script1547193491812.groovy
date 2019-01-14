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

String emailAddress = ('angelino+' + getDateTime()) + '@staff.com'

WebUI.waitForElementVisible(findTestObject('Dashboard Page/Text Fields/inviteUserField'), 0)

WebUI.setText(findTestObject('Dashboard Page/Text Fields/inviteUserField'), emailAddress)

WebUI.click(findTestObject('Dashboard Page/Buttons/inviteButton'))

WebUI.waitForPageLoad(0)

not_run: WebUI.waitForElementVisible(findTestObject('Text Fields/emailField'), 60)

WebUI.verifyElementText(findTestObject('Text Fields/emailField'), emailAddress)

WebUI.verifyElementText(findTestObject('Invite Team Page/Text Fields/emailField'), emailAddress)

'Select by clicking Manager access level'
not_run: WebUI.click(findTestObject('Radio Buttons/managerAccessLevel'))

'Scroll to view Invite button'
not_run: WebUI.scrollToElement(findTestObject('Buttons or Links/submitButtonForExpandedForm'), 0)

'Click Invite button'
not_run: WebUI.click(findTestObject('Buttons or Links/submitButtonForExpandedForm'))

'Wait for success message to display'
not_run: WebUI.waitForElementPresent(findTestObject('Notifications/successMessage'), 0)

'Verify success message is present'
not_run: WebUI.verifyElementPresent(findTestObject('Notifications/successMessage'), 0)

not_run: WebUI.click(findTestObject('Buttons or Links/Manage Users Link'))

not_run: WebUI.waitForElementVisible(findTestObject('Text/Name Column'), 60)

not_run: WebUI.verifyTextPresent(emailAddress, false)

not_run: WebUI.closeBrowser()

not_run: WebUI.openBrowser('')

not_run: WebUI.setText(findTestObject('Dashboard Page/inviteUserField'), 'angelino+invited@staff.com')

not_run: WebUI.click(findTestObject('Dashboard Page/input_Oops_invite-user-btn'))

String getDateTime() {
    SimpleDateFormat nowDateTime = new SimpleDateFormat('yyyyMMddHHmmsss')

    Date now = new Date()

    String strDate = nowDateTime.format(now)

    return strDate
}


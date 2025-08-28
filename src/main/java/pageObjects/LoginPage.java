package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reUsableComponent.SeleniumHelper;

public class LoginPage extends SeleniumHelper {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private final By TEXT_USERNAME = By.xpath("//input[@id='user-name']");
	private final By TEXT_PASSWORD = By.xpath("//input[@id='password']");
	private final By BTN_LOGIN = By.xpath("//input[@id='login-button']");
	private final By VALIDATION_MESSAGE_LOGIN_ERROR = By.xpath("//h3");
	private final By VALIDATION_PRODUCT_LABEL = By.xpath("//div[@class='product_label']");



	public void loginWithValidCredentials(){
		waitForElementToBeVisible(TEXT_USERNAME);
		enterText(TEXT_USERNAME, FileReaderManager.getInstance().getConfigReader().getValidUserId());
		waitForElementToBeVisible(TEXT_PASSWORD);
		enterText(TEXT_PASSWORD, FileReaderManager.getInstance().getConfigReader().getValidPassword());
	}

	public void loginWithLockedOutUser(){
		waitForElementToBeVisible(TEXT_USERNAME);
		enterText(TEXT_USERNAME, FileReaderManager.getInstance().getConfigReader().getLockedOutUserId());
		waitForElementToBeVisible(TEXT_PASSWORD);
		enterText(TEXT_PASSWORD, FileReaderManager.getInstance().getConfigReader().getValidPassword());
	}

	public void loginWithProblemOutUser(){
		waitForElementToBeVisible(TEXT_USERNAME);
		enterText(TEXT_USERNAME, FileReaderManager.getInstance().getConfigReader().getLockedOutUserId());
		waitForElementToBeVisible(TEXT_PASSWORD);
		enterText(TEXT_PASSWORD, FileReaderManager.getInstance().getConfigReader().getValidPassword());
	}

	public void validationMessage(String expected){
		verifyContainsText(VALIDATION_MESSAGE_LOGIN_ERROR, expected);
	}

	public void validationMessagePRODUCTLABEL(String expected){
		verifyContainsText(VALIDATION_PRODUCT_LABEL, expected);
	}

	public void clickLogin(){
		waitForElementToBeVisible(BTN_LOGIN);
		click(BTN_LOGIN);
	}


}

package org.vaadin.test.webinar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vaadin.testbench.TestBenchTestCase;

public class LoginPageObject extends TestBenchTestCase {

	@FindBy(id = "login-uname-field")
	private WebElement userNameField;
	
	@FindBy(id = "login-passwd-field")
	private WebElement passwordField;
	
	@FindBy(id = "login-login-btn")
	private WebElement loginButton;

	public LoginPageObject(WebDriver driver) {
		setDriver(driver);
		open();
	}
	
	public void open() {
		getDriver().get("http://localhost:8080/?restartApplication");
	}

	public MainViewPageObject logUserIn(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginButton.click();

		return PageFactory.initElements(getDriver(), MainViewPageObject.class);
	}

}

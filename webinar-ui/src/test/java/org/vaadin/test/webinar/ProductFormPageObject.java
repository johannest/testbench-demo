package org.vaadin.test.webinar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vaadin.testbench.TestBenchTestCase;

public class ProductFormPageObject extends TestBenchTestCase {

	@FindBy(id = "pform-pname")
	private WebElement nameField;
	
	@FindBy(id = "pform-save")
	private WebElement saveButton;
	
	public ProductFormPageObject(WebDriver driver) {
		setDriver(driver);
	}
	
	public void fillProductForm(String testbookname) {
		nameField.sendKeys(testbookname);
		nameField.sendKeys(Keys.ENTER);
	}

	public void saveProduct() {
		saveButton.click();
	}

	public WebElement getProductNameField() {
		return nameField;
	}

}

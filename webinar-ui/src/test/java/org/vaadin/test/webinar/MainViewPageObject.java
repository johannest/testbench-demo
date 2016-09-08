package org.vaadin.test.webinar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.GridElement;

public class MainViewPageObject extends TestBenchTestCase {

	@FindBy(id = "crud-filterfield")
	private WebElement filterField;
	
	public MainViewPageObject(WebDriver driver) {
		setDriver(driver);
	}
	
	public GridElement getProductGrid() {
		return $(GridElement.class).first();
	}
	
	public ButtonElement getNewProductButton() {
		return $(ButtonElement.class).id("new-product-bttn");
	}

	public ProductFormPageObject clickNewProductButton() {
		getNewProductButton().click();
		return PageFactory.initElements(getDriver(), ProductFormPageObject.class);
	}

	public String getProductGridsCellsText(int row, int col) {
		return getProductGrid().getCell(row, col).getText();
	}
	
	public boolean thereIsExactlyNRows(int n) {
		try {
			// nth row should exists
			getProductGrid().getRow(n-1).isDisplayed();
		} catch (Exception e) {
			return false;
		}
		
		try {
			// but (n+1)th row should not exist
			getProductGrid().getRow(n).isDisplayed();
		} catch (Exception e) {
			return true;
		}
		
		// also (n+1)th row existed
		return false;
	}

	public void filterProducts(String filterText) {
		filterField.sendKeys(filterText);
        filterField.sendKeys(Keys.ENTER);
	}
	
}

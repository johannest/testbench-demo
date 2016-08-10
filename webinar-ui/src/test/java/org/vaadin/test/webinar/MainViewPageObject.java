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

	public void filterProducts(String filterText) {
		filterField.sendKeys(filterText);
        filterField.sendKeys(Keys.ENTER);
	}
	
}

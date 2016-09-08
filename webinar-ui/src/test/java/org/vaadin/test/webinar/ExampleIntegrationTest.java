package org.vaadin.test.webinar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;

public class ExampleIntegrationTest  extends TestBenchTestCase {

	private static final String TESTUSERNAME = "uname";
	private static final String TESTPASSWORD = "pword";
	private static final String TESTBOOKNAME = "Chasm city";
	
	private LoginPageObject login;
	
	@Before
    public void setUp() throws Exception {
        driver = TestBench.createDriver(new ChromeDriver());

		// Use PageFactory to automatically initialize fields
		login = PageFactory.initElements(driver, LoginPageObject.class);
	}
	
	@Test
    public void testInsertNewBook() throws Exception {
		MainViewPageObject mainView = login.logUserIn(TESTUSERNAME, TESTPASSWORD);
		verifyMainView(mainView);
		
		ProductFormPageObject productForm = mainView.clickNewProductButton();
		verifyProductForm(productForm);
		
		productForm.fillProductForm(TESTBOOKNAME);
		productForm.saveProduct();
		verifyThatBookExistsInTheProductGrid(mainView);
		
		// ...
	}

	private void verifyMainView(MainViewPageObject mainView) {
		Assert.assertEquals("1", mainView.getProductGridsCellsText(0,0));
		Assert.assertEquals("New product", mainView.getNewProductButton().getCaption());
		// ...
	}

	private void verifyProductForm(ProductFormPageObject productForm) {
		WebElement productNameField = productForm.getProductNameField();
        productNameField.isDisplayed();
		// ...
	}
	
	private void verifyThatBookExistsInTheProductGrid(MainViewPageObject mainView) {
		mainView.filterProducts(TESTBOOKNAME);
		Assert.assertEquals(TESTBOOKNAME, mainView.getProductGridsCellsText(0,1));
		Assert.assertTrue(mainView.thereIsExactlyNRows(1));
		// ...
	}
	
	@After
	public void tearDown() throws Exception {
	    driver.quit();
	}
}

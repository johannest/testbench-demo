//
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.vaadin.johannest.loadtestdriver.LoadTestDriver;
//
//import com.vaadin.testbench.ScreenshotOnFailureRule;
//import com.vaadin.testbench.TestBenchTestCase;
//import com.vaadin.testbench.elements.ButtonElement;
//import com.vaadin.testbench.elements.GridElement;
//import com.vaadin.testbench.elements.TextFieldElement;
//
//
//public class MyUITest extends TestBenchTestCase {    
//    
//	@Rule
//    public ScreenshotOnFailureRule screenshotOnFailureRule =
//            new ScreenshotOnFailureRule(this, true);
//    
//	@Before
//	public void setUp() throws Exception {
//		WebDriver driver = new LoadTestDriver.LoadTestDriverBuilder().
//				withIpAddress(LoadTestDriver.getLocalIpAddress()).
//				withNumberOfConcurrentUsers(1).
//				withRampUpTimeInSeconds(1).
//				withProxyPort(9999).
//				withPath("/Users/jotatu/Desktop/gatling").
//				withStaticResourcesIngnoring().
//				//withTestRefactoring().
//				build();
//		setDriver(driver);
////		setDriver(new ChromeDriver());	
//	}
//
//    /**
//     * Opens the URL where the application is deployed.
//     */
//    private void openTestUrl() {
//        getDriver().get("http://"+LoadTestDriver.getLocalIpAddress()+":8080/ui");
//    }
//
//    @Test
//    public void testClickButton() throws Exception {
//        openTestUrl();
//
//    	List<ButtonElement> buttons = $(ButtonElement.class).all();
//        assertEquals(2, buttons.size());
//        
//        assertEquals("Username", $(TextFieldElement.class).first().getCaption());
//        
//        ButtonElement loginButton = $(ButtonElement.class).caption("Login").first();
//        loginButton.click();
//
//        assertEquals("1", $(GridElement.class).first().getCell(0, 0).getText());
//                
//        TextFieldElement filterField = $(TextFieldElement.class).first();
//        filterField.sendKeys("galaxy");
//        filterField.sendKeys(Keys.ENTER);
//        
//        assertEquals("11", $(GridElement.class).first().getCell(0, 0).getText());
//        
//        filterField.clear();
//        assertEquals("1", $(GridElement.class).first().getCell(0, 0).getText());
//        
//        $(ButtonElement.class).caption("New product").first().click();
//        
//        TextFieldElement productNameField = $(TextFieldElement.class).caption("Product name").first();
//        productNameField.sendKeys("qwerty");
//        productNameField.sendKeys(Keys.ENTER);
//        
//        $(ButtonElement.class).caption("Save").first().click();
//        
//        assertEquals("1", $(GridElement.class).first().getCell(0, 0).getText());
//        
//        filterField = $(TextFieldElement.class).first();
//        filterField.sendKeys("qwerty");
//        filterField.sendKeys(Keys.ENTER);
//        
//        assertEquals("qwerty", $(GridElement.class).first().getCell(0, 1).getText());
//        
//       // $(MenuBarElement.class).first().clickItem("Logout");
//    }
//}

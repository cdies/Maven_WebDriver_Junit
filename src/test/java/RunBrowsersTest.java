import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RunBrowsersTest {
	
	WebDriver driver;
	public static final String WebUrl = "http://google.com"; 
	
	@Test
	public void isThatGooglePageTest() {
		FireFoxBrowser();
		OperationForisThatGoogleTest();
		
		ChromeBrowser();
		OperationForisThatGoogleTest();
		
		InternetExplorerBrowser();
		OperationForisThatGoogleTest();
	}
	
	@Test 
	public void FindWorkTest() {
		FireFoxBrowser();
		OperationForFindWork();
	}
	
	private void OperationForFindWork() {
		driver.navigate().to(WebUrl);
		driver.findElement(By.className("gsfi")).sendKeys("работа программистом в москве");
		driver.findElement(By.name("btnG")).click();
		(new WebDriverWait(driver,10)).until(
				ExpectedConditions.elementToBeClickable(By.linkText("HH.ru")));
		driver.findElement(By.linkText("*Работа*"));
		driver.findElement(By.name("text")).sendKeys("Программист стажёр");
		driver.close();
	}

	private void OperationForisThatGoogleTest(){
		System.out.println("Work!");
		driver.navigate().to(WebUrl);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		assertEquals("Google",driver.getTitle());
		Assert.assertTrue("This is not a google page!", driver.getTitle().startsWith("Google"));
		Assert.assertTrue("Isn't google", driver.getTitle().contains("Google"));
		driver.close();
	}
	
	protected void FireFoxBrowser(){
		driver = new FirefoxDriver();
	}
	
	protected void ChromeBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:/Work/Selenium_Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	protected void InternetExplorerBrowser(){
		System.setProperty("webdriver.ie.driver", "C:/Work/Selenium_Drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	 @Before
	   public void beforeEveryTest() {
	       System.out.println("Start test!");
	   }
		   
	   @After
	   public void afterEveryTest() {
	      System.out.println("Finish test!");
	   }
	   
	   @BeforeClass
	   public static void beforeClass() {
	      System.out.println("Tests is running!");
	   }

	   @AfterClass
	   public static void  afterClass() {
	      System.out.println("All test have been finished!");
	   }

}

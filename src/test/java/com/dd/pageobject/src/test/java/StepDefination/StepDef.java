package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AddCertification;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDef extends BaseClass{

	@Before
public void setup() {
		//readConfig = new Properties();
		//readConfig - new ReadConfig();
		readConfig = new ReadConfig();
		/*try {
			FileInputStream file = new FileInputStream("config.properties");
			readConfig.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		log = LogManager.getLogger("StepDef");
		String browser = readConfig.getBrowser();

		//launch browser
				switch(browser.toLowerCase())
				{
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;

				/*case "msedge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;*/

				/*case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;*/
				
				
			
				//log.fatal("Setup1 executed...");
			//break;
		default:
			driver=null;
			break;
		}
	
		/*
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * log.fatal("Setup1 executed..."); System.out.println("Driver Setup");
		 */
}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	
		loginPg = new LoginPage(driver);
		addCertification = new AddCertification(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		System.out.print("Launch URL");
		log.info("User opens URL...");
	}

	@When("Click on Maximize")
	public void click_on_maximize() {
		driver.manage().window().maximize();
		log.info("Click on Maximize...");
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
		log.info("Click on Login...");

		System.out.println("Click on Login");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String enterPassword) throws InterruptedException {
		loginPg.enterEmail(email);
		log.info("User enters Email...");

		loginPg.enterPassword(enterPassword);
		log.info("User enters Password...");
		System.out.println("Email");

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String string) {
		String Title = driver.getTitle();
		log.info("Page Title should be String...");
		System.out.println(Title);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		Thread.sleep(5000);
		loginPg.clickOnLogOutButton();
		log.info("User click on Log out link...");
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
		System.out.print("Close Browser");
		log.info("close browser...");
	}
	@When("User click on Profile")
	public void user_click_on_profile() throws InterruptedException {
		Thread.sleep(5000);
	   addCertification.clickOnProfile();
	   log.info("User click on Profile...");
	}

	@When("Click on View Profile")
	public void click_on_view_profile() throws InterruptedException {
		Thread.sleep(5000);
		addCertification.clickOnViewProfile();
		log.info("Click on View Profile...");
	
	}

	@When("Click on Course and Certification")
	public void click_on_course_and_certification() throws InterruptedException {
		Thread.sleep(5000);
		addCertification.clickCourse();
		log.info("Click on Course and Certification...");
	 
	}

	@When("Click on Add")
	public void click_on_add() throws InterruptedException {
		Thread.sleep(5000);
		addCertification.CourseAndCertificate();
		log.info("Click on Add...");
	 
	}

	@When("User enter Certification details")
	public void user_enter_certification_details() throws InterruptedException {
		Thread.sleep(5000);
		addCertification.CourseName("Hurutu");
		addCertification.IssuedBy("Prasad");
		log.info("User enter Certification details...");
	
	}

	@When("click on close button")
	public void click_on_close_button() {
	 	}
	
	@After
	public void teardown(Scenario sc) {
		System.out.println("Driver Quit");
		if(sc.isFailed()==true) {
			{
				//Convert web driver object to TakeScreenshot

				String fileWithPath = "C:\\Users\\Dell\\eclipse-workspace\\Cucumber\\screenshot\\failedScreenshot.png";
				TakesScreenshot scrShot =((TakesScreenshot)driver);

				//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

				//Move image file to new destination
				File DestFile=new File(fileWithPath);

				//Copy file at destination

				try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		driver.quit();
	}
	@AfterStep 
	public void addScreenShot(Scenario scenario) {
		if(scenario.isFailed())
		{
		final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot,"image/png",scenario.getName());
		
	}
	}
	/*
	 * @AfterStep public void afterStep() {
	 * System.out.println("After every step..........."); }
	 */
	@BeforeStep
	public void beforeStep() {
		System.out.println("Before every step ..........");
	}

}

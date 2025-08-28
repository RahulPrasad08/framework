package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//input[@id=\"signInName\"]")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement login;

	@FindBy(xpath = "//div[@class='loginWith']")
	WebElement loginPswd;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement LoginBtn;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement clickonPswd;

	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;

	@FindBy(linkText = "Logout")
	WebElement logout;

	@FindBy(xpath = "//input[@id='signInbtn']")
	WebElement signInbtn;

	@FindBy(xpath = "//*[@id=\"searchForm\"]/div/button/span")
	WebElement profile;

	// -----------------

	@FindBy(xpath = "//*[@id='seekerHeader']/div/div[2]/div/div/div/span")
	//@FindBy(xpath= "//*[@id='seekerHeader']/div/div[4]/div/div/div/span")
	WebElement clickProfile;
	
	@FindBy(xpath = "//*[@id=\"seekerHeader\"]/div/div[4]/div/div/div/div[2]/a[1]")
	
	WebElement clickViewProfile;

	
	
	
	@FindBy(id = "acceptAll")
	WebElement accept;

	public void enterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
		loginPswd.click();
	}

	public void enterPassword(String pwdEnter) throws InterruptedException {
		pwd.clear();
		pwd.sendKeys(pwdEnter);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		signInbtn.click();
		accept.click();
	}

	public void clickOnLoginButton() {
		login.click();

	}

	public void clickOnLogOutButton() {

		clickProfile.click();
		logout.click();
		System.out.println("Step pass");
	}

}

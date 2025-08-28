package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCertification {
	WebDriver ldriver;

	public AddCertification(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//*[@id='seekerHeader']/div/div[2]/div/div/div/span")
	// @FindBy(xpath = "//*[@id='seekerHeader']/div/div[2]/div/div/div/span")
	WebElement clickProfile;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//*[@id='seekerHeader']/div/div[2]/div/div/div/div/a[1]")
	WebElement clickViewProfile;
	
	@FindBy(xpath = "//*[@id='navigationBar']/div/button")
	WebElement clickOnCourse;
	
	@FindBy(xpath = "//*[@id='navigationBar']/div/div/a[1]/p")
	WebElement CourseAndCertificate;
	
	
	@FindBy(xpath = "//*[@id='COURSES_CERTIFICATIONS']/div/div/div/div/button")
	WebElement AddCourseAndCertificate;
	
	@FindBy(id = "name")
	WebElement CertificateName;

	@FindBy(id = "issuer")
	WebElement IssuedBy;

	@FindBy(xpath = "//*[@id='coursesCertifications-modal']/div[2]/button")
	WebElement Close;
	

	// -----------------

	public void clickOnProfile() {
		clickProfile.click();

	}

	public void clickOnViewProfile() {
		clickViewProfile.click();

	}

	public void clickOnLogOutButton() {
		clickProfile.click();

	}
	public void clickCourse() {
		clickOnCourse.click();

	}
	public void CourseAndCertificate() {
		CourseAndCertificate.click();
		AddCourseAndCertificate.click();

	}
	public void CourseName(String CName) {
		CertificateName.sendKeys(CName);
	//	IssuedBy.sendKeys("Prasad");

		}
	public void IssuedBy(String Issued) {
		IssuedBy.sendKeys(Issued);
		Close.click();
	}
}
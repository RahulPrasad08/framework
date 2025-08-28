package StepDefination;

import org.openqa.selenium.WebDriver;

import PageObject.AddCertification;
import PageObject.LoginPage;
import Utilities.ReadConfig;

import java.util.Properties;

import org.apache.logging.log4j.*;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginPg;
	public AddCertification addCertification;
	public static Logger log;
	//public Properties readConfig;
	public ReadConfig readConfig;
}

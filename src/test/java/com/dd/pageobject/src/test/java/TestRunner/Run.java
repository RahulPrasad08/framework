package TestRunner;

import org.junit.runner.RunWith;

//import io.cucumber.testng.CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(
		
		//features = "./src/test/resources/features"
		features = "C:/Users/Dell/eclipse-workspace/Cucumber/Features/LoginFeature.feature",
		//features = "C:/Users/Dell/eclipse-workspace/Cucumber/Features",
		//features = {".//features/AddCertification.feature",".//features/LoginFeature.feature"},
		glue="StepDefination",
		dryRun = false,
		monochrome = true,
		//plugin = {"pretty"},
		//tags = "@Sanity",//scenarios under @sanity tag will be executed "@sanity or @Regression", 
		//plugin = {"pretty","html:target/cucumber-reports/reports_html.html"},
			//	plugin = {"pretty","html:target/cucumber-reports/reports1.html",}
		//"junit:target/cucumber-reports/report_xml.xml","json:target/cucumber-reports/reports_json.json"
			//plugin = {"pretty","junit:target/cucumber-reports/report_xml.xml"}
			//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"}
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

     //plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
		//		plugin = {"pretty","json:target/cucumber-reports/reports_json.json"}
		)

	//plugin = {"pretty","json:target/cucumber-reports/report_json.json"}

         
public class Run {

}

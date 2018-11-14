package env;
import org.junit.runner.RunWith;
import org.junit.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.cucumber.listener.Reporter;
import java.io.*;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		features =  "classpath:features",
		glue = {"info.seleniumcucumber.stepdefinitions",   // predefined step definitions package
				"info.seleniumcucumber.userStepDefintions" // user step definitions package
		}
)


public class RunCukeTest {
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}

}
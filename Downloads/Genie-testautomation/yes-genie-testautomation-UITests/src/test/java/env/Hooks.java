package env;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import env.DriverUtil;
import info.seleniumcucumber.userStepDefintions.UserStepDefinitions;

public class Hooks extends DriverUtil {

/*	@After("@NegativeTest")
	public void afterScenario() {
//		System.out.println("In hooks");
//		System.out.println(scenario.getName());
//		System.out.println(scenario.getStatus());
*//*		driver.quit();
		System.out.println("Then I close browser");*//*
	}*/

	@After
	public void afterScenario() {
		System.out.println("Close browser");
		driver.quit();
	}
}

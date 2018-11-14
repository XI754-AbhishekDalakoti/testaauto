# YES-GENIE-TESTAUTOMATION

This is a Selenium-cucumber (BDD) approach based way of writing automation test script to test Web application. 

## Framework components:

src/test/resources/features - all the cucumber features files (files .feature ext) goes here. 

src/test/java/userStepDefinition - you can define step defintion under this package for your feature steps. 

src/test/java/env - this package contains cucumber runner (RunCukeTest.java) where you can configure your glue code location (step defintions), define test result output format.(html, json, xml). Hooks where you can configure all before and after test settings Hooks.java, DriverUtil.java contains code for intializing driver instances for respective driver. 

## Writing a Test:

 The cucumber features goes in the features library and should have the ".feature" extension.

 You can start out by looking at features/Login.feature. You can extend this feature or make your own features using some of the predefined steps that comes with selenium-cucumber.
 
##  Maven/Gradle Dependency:

  The test can be run through either maven or gradle as both build tools have been used for ease of use.

## Running a Test with Maven:

mvn test
(default will run on Chrome browser) 

mvn test -Dcucumber.options="–-plugin html:target/result-html" to generate a HTML report. 

mvn test -Dcucumber.options="–-plugin json:target/result-json" to generate a JSON report. 
  
## Running a Test with Gradle:
 
 gradle test
 (default will run on Chrome browser)   
 
## Reporting:
We are using Extent report to show reporting that is integrated with the framework along with jenkins.

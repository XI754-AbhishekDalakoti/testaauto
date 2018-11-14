1. Install Gradle and IntelliJ/Eclipse on your machine but Since most of the people are using
IntelliJ so to get less conflicts in project files , its better to use IntelliJ

2. Import this project as gradle project in Intellij and give the path of build.gradle while importing

3. This will install all the dependencies as mentioned in build.gradle into the project

4. Write your feature file under "src\test\resources\features" 

5. Write your stepDefinitions under "src\test\java\stepDefinitions" 

6. Write your pages under the "src\test\java\pages" 

7. Create a runner to run the cucumber tests under the "src\test\java\" 

8.  Create a file called **serenity.properties** in **root project directory**.I have created 
chrome.properties and firefox.properties under the "test-properties" as sample.

9. Add the below content to the **chrome.properties** file
   
       ```
       webdriver.timeouts.implicitlywait = 5000
       webdriver.driver=chrome
       webdriver.chrome.driver="Path to the driver"
       webdriver.base.url=http://www.google.com
       serenity.project.name = UI Project using Serenity and Cucumber
       serenity.use.unique.browser = true
       chrome.switches=--no-sandbox,--disable-plugins,--disable-extensions
       #serenity.take.screenshots=AFTER_EACH_STEP
       serenity.take.screenshots=FOR_FAILURES
       webdriver.wait.for.timeout=20000
       #webdriver.applicationCacheEnabled=true
       ```
   
   
   ## Built With
   
   * [Serenity BDD](http://www.thucydides.info/#/) - An open source library that aims to make the idea of living documentation a reality.
   
   For a better understanding of the tests read [cucumber](https://cucumber.io/)'s docs.
   
   Cucumber understands [Gherkin](https://github.com/cucumber/cucumber/wiki/Gherkin) i.e given, when and then format.

10. Run the below command to run your tests 

gradle clean test aggregate -Dserenity.properties=test-properties/chrome.properties -Dcucumber.options="--tags @smoke"


Pass the webdriver.base.url property from the command line to run the test i.e.

gradle clean test aggregate -Dserenity.properties=test-properties/chrome.properties -Dwebdriver.base.url=url -Dcucumber.options="--tags @Smoke"

To run the test with multiple tags:
gradle clean test aggregate -Dserenity.properties=test-properties/chrome.properties -Dwebdriver.base.url="url" -Dcucumber.options="--tags @Smoke,@RegressionTest"

To run the tests excluding a par
gradle clean test aggregate -Dserenity.properties=test-properties/chrome.properties -Dwebdriver.base.url="url" -Dcucumber.options="--tags @Smoke"
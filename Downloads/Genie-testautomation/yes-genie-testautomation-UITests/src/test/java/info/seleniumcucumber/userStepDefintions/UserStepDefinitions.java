package info.seleniumcucumber.userStepDefintions;

        import cucumber.api.PendingException;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import cucumber.api.java.en.Given;
        import env.DriverUtil;
        import info.seleniumcucumber.methods.BaseTest;
        import pageObjects.LoginPage;
        import pageObjects.SearchPage;
        import static org.openqa.selenium.support.ui.ExpectedConditions.*;
        import cucumber.api.PendingException;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.junit.Assert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import cucumber.api.java.en.Given;
        import env.DriverUtil;
        import info.seleniumcucumber.methods.BaseTest;
        import pageObjects.LoginPage;
        import pageObjects.SearchPage;
       import static org.openqa.selenium.support.ui.ExpectedConditions.*;



public class UserStepDefinitions implements BaseTest {

    protected WebDriver driver = DriverUtil.getDefaultDriver();
    public static LoginPage lp = new LoginPage();
    public static SearchPage sp = new SearchPage();


    @Given("^I should get logged-in$")
    public void should_logged_in() throws Throwable {

        By selection = By.id("flash");
        (new WebDriverWait(driver, 30)).until(
                visibilityOfElementLocated(selection));
        String msg = driver.findElement(By.id("flash")).getText();
        if (!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("Welcome, Abhishek Sharma", msg);
            
    @Then("^I should get logged-in with welcome message$")
    public void should_logged_in_with_welcome_message() throws Throwable {

        By selection = By.xpath("//span[@class='_2QCs8cFfqH_wnXLIYBu5ro ZU4gfSwYj6EDl657TJqnA']");
        (new WebDriverWait(driver, 10)).until(
                visibilityOfElementLocated(selection));
        String msg = driver.findElement(By.xpath("//span[@class='_2QCs8cFfqH_wnXLIYBu5ro ZU4gfSwYj6EDl657TJqnA']")).getText();
        if (!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("Welcome, Ravindra Singh", msg);
    }

    @Then("^I should get error message$")
    public void iShouldGetErrorMessage() throws Throwable {

        By selection = By.className("kc-feedback-text");
        (new WebDriverWait(driver, 30)).until(
                visibilityOfElementLocated(selection));
        String msg = driver.findElement(By.className("kc-feedback-text")).getText();
        if (!msg.isEmpty())
            msg = msg.split("\n")[0].trim();
        Assert.assertEquals("Login Failed. Unknown User ID or Bad Password.", msg);
    }

    @Then("^The button should be disabled$")
    public void theButtonShouldBeDisabled() throws Throwable {
        lp.checkDisableButton();
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersAnd(String Username, String Password) throws Throwable {

        lp.enterCredentials(Username, Password);
    }

    @When("^I click on Login$")
    public void iClickOnLogin() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @And("^Last Login date and time is displayed with basic info$")
    public void lastLoginDateAndTimeIsDisplayedWithBasicInfo() throws Throwable {
        lp.displayLoginDateTimeBasicInfo();
    }

    @And("^Search bar contains static search parameters$")
    public void searchBarContainsStaticSearchParameters() throws Throwable {
        lp.staticSearchParameters();

    }


    @When("^I get the page title and decide the starting page$")
    public void verifyAndDecideTestCaseFlow() {
        String title = sp.getpageTitle().trim();
        if(title.equalsIgnoreCase("Log in to YBL")){
            System.out.println("t : "+title);
        } else{
            lp.logOut();
        }
    }

    @Then("^I should get logout$")
    public void iShouldGetLogout() throws Throwable {
        lp.logOut();
    }


    @And("^Basic information$")
    public void basicInformation() throws Throwable {
        lp.displayLoginDateTimeBasicInfo();
    }

    @Then("^I get Search result in tabular format with all details$")
    public void iGetSearchResultInTabularFormatWithAllDetails() throws Throwable {
        sp.searchParameters();
    }

    @Then("^No search result should be displayed$")
    public void noSearchResultDisplay() throws Throwable {
        sp.noSearchResultDisplay();
    }

    @And("^Has option to search by Cust ID$")
    public void hasOptionToSearchByCustID() throws Throwable {
        driver.findElement(By.id("CustID")).click();
    }

    @Then("^I quit browser$")
    public void iQuitBrowser() throws Throwable {
        driver.quit();
    }

    @Then("^I should get the tool tip with message$")

    public void toolTipMessageForCustIdToSearch(){
        sp.toolTipMessageDisplayCustID();
    }

    public void toolTipMessageForCustIdToSearch() {
        sp.toolTipMessageDisplayCustID();
    }

    @And("^I validate last login format$")
    public void iValidateLastLoginFormat() throws Throwable {
        lp.validateFormat();
    }

    @And("^Displays search criteria with count$")
    public void displaysSearchCriteriaWithCount() throws Throwable {
        sp.searchCriteria();

    }

    @Then("^Message should come for search refinement due to threshold exceeded$")
    public void messageShouldComeForSearchRefinementDueToThresholdExceeded() throws Throwable {
        sp.refineMessage();
    }

}

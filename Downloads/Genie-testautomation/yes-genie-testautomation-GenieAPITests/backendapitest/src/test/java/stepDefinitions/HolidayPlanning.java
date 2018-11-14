package stepDefinitions;

import static utils.Utilities.*;

import cucumber.api.DataTable;
import pages.CalendarPage;
import pages.NeoLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HolidayPlanning {

    NeoLoginPage neologinPage;
    CalendarPage calendarPage;

    @Given("^James logged into the system$")
    public void loginNeo(DataTable dataTable) throws Throwable {
        neologinPage.enterHomeUrl();
        neologinPage.logIn(getKeyValueFromDataTable(dataTable, "loginUserName"), getKeyValueFromDataTable(dataTable, "loginPassword"));
    }

    @When("^James provides the travel source destination and dates$")
    public void sourceDestinationDetails(DataTable dataTable) throws Throwable {
        calendarPage.searchText(getKeyValueFromDataTable(dataTable, "searchMessage"));
        assert(calendarPage.verifyChatResponse(getKeyValueFromDataTable(dataTable, "Response1")));
        calendarPage.enterChat(getKeyValueFromDataTable(dataTable, "UserMessage1"));
        assert(calendarPage.verifyChatResponse(getKeyValueFromDataTable(dataTable, "Response2")));
        calendarPage.enterChat(getKeyValueFromDataTable(dataTable, "UserMessage2"));
        assert(calendarPage.verifyChatResponse(getKeyValueFromDataTable(dataTable, "Response3")));
        calendarPage.enterChat(getKeyValueFromDataTable(dataTable, "UserMessage3"));
        assert(calendarPage.verifyChatResponse(getKeyValueFromDataTable(dataTable, "Response4")));
        calendarPage.selectResponse(getKeyValueFromDataTable(dataTable, "UserMessage4"));
    }

    @Then("^System provides option to select travel partner$")
    public void verifyTravelOptions() throws Throwable {
        calendarPage.logOut();
    }

}

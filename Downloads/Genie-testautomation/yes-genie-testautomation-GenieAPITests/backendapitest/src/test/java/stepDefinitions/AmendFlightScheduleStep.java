package stepDefinitions;

import static utils.Utilities.*;
import static utils.YmlReader.getNestedKeyValueFromYML;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pages.FlightSchedulePage;
import utils.SetupConfiguration;

public class AmendFlightScheduleStep extends SetupConfiguration {
	public static ResponseBody responsebody;
	public static Response response;
	public static int statusCode;
	
	FlightSchedulePage flightSchedule;
	
	public AmendFlightScheduleStep(){
		flightSchedule = new FlightSchedulePage();
	}

	@When("^A Partner performs REST request to amend via these APIs$")
	public void a_Partner_performs_REST_request_to_amend_via_these_APIs(DataTable dataTable) throws Throwable {
		System.out.println(RestAssured.baseURI);

		responsebody = given().relaxedHTTPSValidation().accept(ContentType.JSON).contentType(ContentType.JSON)
				.body(flightSchedule.createClientObject(dataTable)).when()
				.put("v2/travel/transportoffering/" + getKeyValueFromDataTable(dataTable, "TransportOfferingCode"))
				.thenReturn().body();
		// assertion missing for 200
	}

	@Then("^Flight Schedules Availability should be updated in EK Marketplace/Hybris Inventory$")
	public void flight_Schedules_Availability_should_be_updated_in_EK_Marketplace_Hybris_Inventory() throws Throwable {
		String jsonString = responsebody.asString();
		System.out.println(jsonString);
		JsonPath objJsonPath = JsonPath.from(jsonString);
		// Assertion required
	}
	
	@When("^Hybris receives an incoming request with a order ID$")
	public void hybris_receives_an_incoming_request_with_a_order_ID(DataTable orderTable) throws Throwable {
		
		HashMap client = new HashMap<String, Object>();
		responsebody = given().relaxedHTTPSValidation().accept(ContentType.JSON).header("Accept", "application/json")
				.header("Authorization", getNestedKeyValueFromYML(domain, "authenticationKey")).body(client).when()
				.get("v2/travel/users/" + getKeyValueFromDataTable(orderTable, "user_id") + "/orders/"
						+ getKeyValueFromDataTable(orderTable, "order_id"))
				.thenReturn().body();
		//assertion missing for 200
	}

	@Then("^The content of the order identified by ID will be returned in a JSON format$")
	public void the_content_of_the_order_identified_by_ID_will_be_returned_in_a_JSON_format() throws Throwable {
		String jsonString = responsebody.asString();
		System.out.println(jsonString);
		JsonPath objJsonPath = JsonPath.from(jsonString);
		//Assertion required
	}

	@When("^Hybris receives an incoming GET request with userID$")
	public void hybrisReceivesAnIncomingGETRequestWithUserID(DataTable orderTable) throws Throwable {
		HashMap client = new HashMap<String, Object>();
		
		responsebody = given().relaxedHTTPSValidation().accept(ContentType.JSON).header("Accept", "application/json")
				.header("Authorization", getNestedKeyValueFromYML(domain, "authenticationKey")).body(client).when()
				.get("v2/travel/users/" + getKeyValueFromDataTable(orderTable, "user_id") + "/orders").thenReturn()
				.body();
		//assertion missing for 200
	}

	@Then("^The content of the orders will be returned in a JSON format$")
	public void theContentOfTheOrderSWillBeReturnedInAJSONFormat() throws Throwable {
		String jsonString = responsebody.asString();
		System.out.println(jsonString);
		JsonPath objJsonPath = JsonPath.from(jsonString);
		//Assertion required
	}
	
	@When("^A Partner performs REST request to upload via these APIs$")
	public void a_Partner_performs_REST_request_to_upload_via_these_APIs(DataTable dataTable) throws Throwable {
		System.out.println(RestAssured.baseURI);
		
		responsebody = given().relaxedHTTPSValidation().accept(ContentType.JSON).contentType(ContentType.JSON)
				.body(flightSchedule.createClientObject(dataTable)).when().put("v2/travel/transportoffering").thenReturn().body();
		//assertion missing for 200
	}

	@Then("^Flight Schedules Availability should be created & available in EK Marketplace/Hybris$")
	public void flight_Schedules_Availability_should_be_created_available_in_EK_Marketplace_Hybris() throws Throwable {
		String jsonString = responsebody.asString();
		System.out.println(jsonString);
		JsonPath objJsonPath = JsonPath.from(jsonString);
		//Assertion required
	}

}

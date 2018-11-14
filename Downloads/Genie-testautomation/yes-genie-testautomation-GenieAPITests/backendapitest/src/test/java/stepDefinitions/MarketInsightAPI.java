package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static utils.Utilities.getKeyValueFromDataTable;
import static utils.Utilities.matchesJsonSchema;

import org.junit.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import jnr.constants.platform.Sysconf;
import utils.Constants;
import utils.SetupConfiguration;
import static utils.Utilities.*;

public class MarketInsightAPI extends SetupConfiguration {
	public static Response response;
	public static int statusCode;

	@Given("^I configure the Rest setup for \"([^\"]*)\"$")
	public void i_configure_the_rest_setup_for(String testDomain) throws Throwable {
		setUp(testDomain);

	}

	@When("^I get the market insight for city \"([^\"]*)\"$")
	public void i_get_the_market_insight_for_city(String city) throws Throwable {
		response = given().when().get("market?cityCode=" + city);
	}

	@Then("^response status code is (\\d+)$")
	public void response_schema_is_statusCode_validation(int statusCode) throws Throwable {
		response.then().statusCode(statusCode);
	}

	@Then("^\"([^\"]*)\" value is \"([^\"]*)\"$")
	public void value_is(String key, String value) throws Throwable {
		response.then().body(key, is(value));
	}
	
	@Then("^response for \"([^\"]*)\" value is \"([^\"]*)\"$")
	public void response_for_value_is(String key, String value) throws Throwable {
		JsonPath jsonPath = new JsonPath(response.asString());
		
		Assert.assertEquals(jsonPath.get("data[0]."+key).toString(), value);
	}

	
	@Then("^market response schema is validated successfully$")
	public void reponse_schema_is_validated_successfully() throws Throwable {
		 response.then().
		 body(matchesJsonSchema("marketInsightAPISchema.json"));
	}
	
	@Then("^I get all OD pair for market-insight$")
	public void get_od_pair_market_insight() throws Throwable {
		response = given().when().get("od-pair");
	}
	
	@And("^OD pair response schema is validated successfully$")
	public void od_pair_reponse_schema_is_validated_successfully() throws Throwable {
		 response.then().
		 body(matchesJsonSchema("odPairAPISchema.json"));
	}

	@When("^I get spend trends for below OD pair and duration$")
	public void spend_trend_odpair_duration(DataTable dataTable) throws Throwable {
		String url="spend-intent?odPair="
				+getKeyValueFromDataTable(dataTable, "odPair")+"&year="
				+getKeyValueFromDataTable(dataTable, "year")+"&month="
				+getKeyValueFromDataTable(dataTable, "month");
		System.out.println(url);
		response = given().when().get(url);
	}
	
	@And("^spend trends response schema is validated successfully$")
	public void spend_trend_reponse_schema_is_validated_successfully() throws Throwable {
		 response.then().
		 body(matchesJsonSchema("spendTrendODPairAPISchema.json"));
	}
	
	@When("^I get travel missions for below OD pair and duration$")
	public void travel_mission_odpair_duration(DataTable dataTable) throws Throwable {
		String url="travel-mission?odPair="
				+getKeyValueFromDataTable(dataTable, "odPair")+"&year="
				+getKeyValueFromDataTable(dataTable, "year")+"&month="
				+getKeyValueFromDataTable(dataTable, "month");
		response = given().when().get(url);
	}
	
	@And("^travel missions response schema is validated successfully$")
	public void travel_mission_reponse_schema_is_validated_successfully() throws Throwable {
		 response.then().
		 body(matchesJsonSchema("travelMissionAPISchema.json"));
	}
	
	@When("^I get travel demand for below OD pair and duration$")
	public void travel_demand_odpair_duration(DataTable dataTable) throws Throwable {
		String url="travel-demand?originType="+getKeyValueFromDataTable(dataTable, "originType")
					+"&originCityCode="+getKeyValueFromDataTable(dataTable, "originCityCode")
					+"&destinationType="+getKeyValueFromDataTable(dataTable, "destinationType")
					+"&destination="+getKeyValueFromDataTable(dataTable, "destination")
					+"&summaryType="+getKeyValueFromDataTable(dataTable, "summaryType")
					+"&year="+getKeyValueFromDataTable(dataTable, "year");
		System.out.println(url);
		response = given().when().get(url);
	}
	
	@And("^travel demand response schema is validated successfully$")
	public void travel_demand_reponse_schema_is_validated_successfully() throws Throwable {
		 response.then().
		 body(matchesJsonSchema("travelMissionAPISchema.json"));
	}
	
	@Then("^result for \"([^\"]*)\" is \"([^\"]*)\"$")
    public void result_for_is(String key, String value) throws Throwable {
		JsonPath jsonPath = new JsonPath(response.asString());
		
		Assert.assertEquals(jsonPath.get("results[0]."+ key).toString(), value);
    }
	
	@And("^spend preference response schema is validated successfully$")
	public void spend_preference_reponse_schema_is_validated_successfully() throws Throwable {
		 response.then().
		 body(matchesJsonSchema("spendPreferenceAPISchema.json"));
	}
	
	@When("^I get spend preference for below OD pair and customer type$")
	public void spend_preference_odpair_customer_type(DataTable dataTable) throws Throwable {
		String url="spend-preference?odPair="+getKeyValueFromDataTable(dataTable, "odPair")
					+"&customerType="+getKeyValueFromDataTable(dataTable, "customerType");
		
		response = given().when().get(url);
	}
	
	@And("^search intent response schema is validated successfully$")
	public void search_intent_reponse_schema_is_validated_successfully() throws Throwable {
		 response.then().
		 body(matchesJsonSchema("searchIntentAPISchema.json"));
	}
	
	@When("^I get search intent for below OD pair and product category$")
	public void search_intent_odpair_product_category(DataTable dataTable) throws Throwable {
		String url="search-intent?odPair="+getKeyValueFromDataTable(dataTable, "odPair")
					+"&productCategory="+getKeyValueFromDataTable(dataTable, "productCategory")
					+"&productSubCategory="+getKeyValueFromDataTable(dataTable, "productSubCategory");
		
		response = given().when().get(url);
	}
	
	@And("^top products response schema is validated successfully$")
	public void top_products_reponse_schema_is_validated_successfully() throws Throwable {
		 response.then().
		 body(matchesJsonSchema("topProductsAPISchema.json"));
	}
	
	@When("^I get Top products for below OD pair and product category$")
	public void top_product_odpair_products_category(DataTable dataTable) throws Throwable {
		String url="search-intent?odPair="+getKeyValueFromDataTable(dataTable, "odPair")
					+"&productCategory="+getKeyValueFromDataTable(dataTable, "productCategory")
					+"&top="+getKeyValueFromDataTable(dataTable, "top");
		
		response = given().when().get(url);
	}
	
	
	@When("^I update market details$")
	public void update_market() throws Throwable {
		String jsonBody = generateStringFromResource("market.json");
		
		response = given().
							header(Constants.headerType, Constants.contentTypeJson).
						    body(jsonBody).
				   when().
							post("market");
	} 
	
	@Then("^response \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void response_message_validation(String message, String responseText) {
		response.then().body(message, is(responseText));
	}
		
	@When("^I update OD Pair details$")
	public void update_od_pair() throws Throwable {
		String jsonBody = generateStringFromResource("odPair.json");
		
		response = given().
							header(Constants.headerType, Constants.contentTypeJson).
						    body(jsonBody).
				   when().
							post("od-pair");
	}
	
	
	@When("^I update Spend Intent details$")
	public void update_spend_intent() throws Throwable {
		String jsonBody = generateStringFromResource("spendIntent.json");
		
		response = given().
							header(Constants.headerType, Constants.contentTypeJson).
						    body(jsonBody).
				   when().
							post("spend-intent");
	}
	
	
	@When("^I update Travel Mission details$")
	public void update_travel_mission() throws Throwable {
		String jsonBody = generateStringFromResource("travelMission.json");
		
		response = given().
							header(Constants.headerType, Constants.contentTypeJson).
						    body(jsonBody).
				   when().
							post("travel-mission");
	}
	
	@When("^I update Travel Demand details$")
	public void update_travel_demand() throws Throwable {
		String jsonBody = generateStringFromResource("travelDemand.json");
		
		response = given().
							header(Constants.headerType, Constants.contentTypeJson).
						    body(jsonBody).
				   when().
							post("travel-demand");
	}
	
	@When("^I update Search Intent details$")
	public void update_search_intent() throws Throwable {
		String jsonBody = generateStringFromResource("searchIntent.json");
		
		response = given().
							header(Constants.headerType, Constants.contentTypeJson).
						    body(jsonBody).
				   when().
							post("search-intent");
	}
	
	@When("^I update Spend Preference details$")
	public void update_spend_preference() throws Throwable {
		String jsonBody = generateStringFromResource("spendPreference.json");
		
		response = given().
							header(Constants.headerType, Constants.contentTypeJson).
						    body(jsonBody).
				   when().
							post("spend-preference");
	}
}

package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import utils.SetupConfiguration;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.is;
import static utils.Utilities.matchesJsonSchema;

/**
 * Created by vibhu on 11/13/2018.
 */
public class SearchAPI extends SetupConfiguration {

    public static Response response;

    @When("^I set the base URL \"([^\"]*)\"$")
    public void tosetUpBaseURL(String testDomain) throws Exception {

        setUp(testDomain);

    }

    @Then("^I validate the status is OK$")
    public void validateAPIisOK(){

        String uri = "http://yesgenie.com:30978/api/customer/search";
        given().accept(ContentType.JSON).
                param("query", "838295").
                param("isCustomerId", "true").
                param("threshold", "50").
                get(uri).
                then().assertThat().statusCode(HttpStatus.SC_OK);

    }

    @Then("^I validate the response body$")
    public void validateResponseBody(){

        String uri = "http://yesgenie.com:30978/api/customer/search";
        given().accept(ContentType.JSON).
                param("query", "838295").
                param("isCustomerId", "true").
                param("threshold", "50").
                get(uri).
                then().
                body("count",is(9)).
                body("records[0].custId",is(838295)).
                body("records[0].mdmId",is(838191)).
                body("records[0].customerName",is("foo5")).
                body("records[0].addressCity",is("Goa")).
                body("records[0].addressArea",is("MMM Road")).
                body("records[0].homeBranch",is("FORT NOT GOA")).
                body("records[0].assetRM",is("Sandeep Kumar")).
                body("records[0].liabilityRM",is("Rahul Rawel")).
                body("records[0].groupId",is("274369")).
                body("records[0].businessSegment",is("BRB")).
                body("records[0].partnerSegment",is("BRB")).
                body("records[0].customerSearchEnabled",is(true)).
                body("records[0].DOB",is("05/05/2007")).
                body("records[1].custId",is(838295)).
                body("records[1].mdmId",is(838191)).
                body("records[1].customerName",is("foo5")).
                body("records[1].addressCity",is("Goa")).
                body("records[1].addressArea",is("MMM Road")).
                body("records[1].homeBranch",is("FORT GOA")).
                body("records[1].assetRM",is("Sandeep Kumar")).
                body("records[1].liabilityRM",is("Rahul Rawel")).
                body("records[1].groupId",is("274369")).
                body("records[1].businessSegment",is("BRB")).
                body("records[1].partnerSegment",is("BRB")).
                body("records[1].customerSearchEnabled",is(true)).
                body("records[1].DOB",is("05/05/2007")).
                body("searchParams['custId'][0]",is("838295"));

    }

    @Then("^search api response schema is validated successfully$")
    public void reponse_schema_is_validated_successfully() throws Throwable {
        response.then().
                body(matchesJsonSchema("marketInsightAPISchema.json"));
    }




    @Then("^I make a complete URI$")
    public void addData(){

        String  aPI = "/api/users?page=2";
        String uri = (RestAssured.baseURI).concat(aPI);
// To get the response in JSON format
/*        Response response = given().accept(ContentType.JSON).
                when().get(uri);

        System.out.println(response.asString());*/

        // To check status code 200 OK should be returned
        // To capture the status code and any other information :thenReturn()
/*        int code = given().accept(ContentType.JSON).
                when().get(uri).
                thenReturn().statusCode();
        System.out.println(code);
        Assert.assertEquals(HttpStatus.SC_OK, code);*/

// To validate the response :then()
/*        given().accept(ContentType.JSON).
                when().get(uri).
                then().assertThat().statusCode(HttpStatus.SC_OK);*/

/*Map<String,String> headers = new HashMap<String,String>();
        headers.put("Accept","application/json");

        String body = given().headers(headers).
                when().get(uri).
                thenReturn().body().asString();

        System.out.println("body is : "+body);*/

        //  uri = "http://yesgenie.com:30978/api/customer/search?query=838295&isCustomerId=true&threshold=50";
        uri = "http://yesgenie.com:30978/api/customer/search";


    }
}

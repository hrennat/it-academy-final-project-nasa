package api.stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import com.jayway.jsonpath.JsonPath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.restassured.RestAssured.given;


public class StepDefsTest {

    private static Logger log = Logger.getLogger(StepDefsTest.class);
    public int element_count;
    public int code;
    public String name;
    public String errorMessage;


    @Given("There are asteroids")
    public void thereAreAsteroids() {
        log.info("There are asteroids...");
    }

    @When("User fetch all asteroids")
    public void userFetchAllAsteroids() {
        Response response = given().
                when().get("https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-09-19&end_date=2021-09-20&api_key=DEMO_KEY").
                then().statusCode(200).extract().response();

        element_count = JsonPath.read(response.asString(), "$.element_count");
        code = response.statusCode();
        log.info("Status code "+code+" is received");

    }


    @Then("Amount is greater than {int}")
    public void amountIsGreaterThan(int arg0) {
        assertTrue(element_count > 0, "Total Items should be greater than 0");
    }


    @When("User fetch an asteroid")
    public void userFetchAnAsteroid() {
        Response response = given().
                when().get("http://www.neowsapp.com/rest/v1/neo/2465633?api_key=DEMO_KEY").
                then().statusCode(200).extract().response();

        name = JsonPath.read(response.asString(), "$.name");
        code = response.statusCode();
        log.info("Status code "+code+" is received");
    }

    @Then("the name of asteroid is retrieved")
    public void theNameOfAsteroidIsRetrieved()  {
        assertEquals("465633 (2009 JR5)", name);
    }

    @When("User tries to fetch all asteroids")
    public void userTriesToFetchAllAsteroids() {
        Response response = given().param("start_date","2021-08-09").param("end_date","2021-09-10").param("api_key","DEMO_KEY").
                when().get("https://api.nasa.gov/neo/rest/v1/feed").
                then().statusCode(400).extract().response();

        errorMessage = JsonPath.read(response.asString(),"$.error_message");
        code = response.statusCode();
        log.info("Status code "+code+" is received");
    }

    @Then("error_message is received")
    public void error_messageIsReceived() {
        assertEquals( "Date Format Exception - Expected format (yyyy-mm-dd) - The Feed date limit is only 7 Days",errorMessage);
    }

    @When("User tries to fetch asteroids")
    public void userTriesToFetchAsteroids() {
        Response response = given().param("start_date","2021-08-09").param("end_date","2021-09-10").param("api_key","").
                when().get("https://api.nasa.gov/neo/rest/v1/feed").
                then().statusCode(403).extract().response();


        String errMess = response.getBody().asString();
        errorMessage = errMess.substring(62, 122);
        code = response.statusCode();
        log.info("Status code "+code+" is received");
    }

    @Then("message is received")
    public void messageIsReceived() {
        assertEquals("No api_key was supplied. Get one at https://api.nasa.gov:443", errorMessage);
    }
}

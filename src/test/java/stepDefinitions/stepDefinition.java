package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.DataSetBuild;
import resources.Utils;
import static org.junit.Assert.*;
import java.io.IOException;


import static io.restassured.RestAssured.given;

public class stepDefinition extends Utils {

    //global variables accessable for all methods
    RequestSpecification res;
    ResponseSpecification responseSpec;
    Response postResponse;
    DataSetBuild dataToSend = new DataSetBuild();


    @Given("Add Place Payload")
    public void add_place_payload() throws IOException {

        res = given().log().all().spec(requestSpecificationNeeded())
                .body(dataToSend.addPlacePayload());
    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
        postResponse = res.when()
                .post("/maps/api/place/add/json")
                .then()
                .spec(responseSpec)
                .extract().response();
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        assertEquals(postResponse.getStatusCode(),200);
    }

     /* POST Response from SWAGGER is below:
            {
            "status": "OK",
            "place_id": "928b51f64aed18713b0d164d9be8d67f",
            "scope": "APP",
            "reference": "736f3c9bec384af62a184a1936d42bb0736f3c9bec384af62a184a1936d42bb0",
            "id": "736f3c9bec384af62a184a1936d42bb0"
            }
            */

    // verify that Status=OK and scope=APP, so this then runs twice with different set of data
    @Then("{string} in response body in {string}")
    public void in_response_body_in(String keyValue, String expectedValue) {
        String pr = postResponse.asString();
        JsonPath jpath = new JsonPath(pr);
        System.out.println(System.getProperties());
        assertEquals(jpath.get(keyValue).toString(),expectedValue);
    }

}

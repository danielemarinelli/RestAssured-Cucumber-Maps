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
import resources.APIroutes;
import resources.DataSetBuild;
import resources.Utils;
import static org.junit.Assert.*;
import java.io.IOException;


import static io.restassured.RestAssured.given;

public class stepDefinition extends Utils {

    //global variables access for all methods
    RequestSpecification res;
    ResponseSpecification responseSpec;
    Response httpResponse;
    DataSetBuild dataToSend = new DataSetBuild();

    /*
    @Given("add place payload")
    public void add_place_payload() throws IOException {
        res = given().log().all().spec(requestSpecificationNeeded())
                .body(dataToSend.addPlacePayload());
    }



    @Given("add place payload with {string} {string} {string} {string}")
    public void add_place_payload_with(String userName, String userLanguage, String userAddress, String url) throws IOException {

        res = given().log().all().spec(requestSpecificationNeeded())
                .body(dataToSend.addPlacePayload(userName, userLanguage, userAddress ,url));

    }

    */


    @Given("add place payload {string} {string} {string} {string}")
    public void add_place_payload(String userName, String userLanguage, String userAddress, String url) throws IOException {
        res = given().log().all().spec(requestSpecificationNeeded())
                .body(dataToSend.addPlacePayload(userName, userLanguage, userAddress ,url));

    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String route, String method) {
        //constructor will be called with value of route which you pass from .feature file
        APIroutes httpMethodInvoked = APIroutes.valueOf(route);  //route contains the string from ENAM , that get it from feature file
        System.out.println(httpMethodInvoked.getRoute());

        responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        if(method.equalsIgnoreCase("POST"))
            httpResponse = res.when().post(httpMethodInvoked.getRoute());
        else if (method.equalsIgnoreCase("GET"))
            httpResponse = res.when().get(httpMethodInvoked.getRoute());

    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        assertEquals(httpResponse.getStatusCode(),200);
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

        assertEquals(getValueFromJsonResponse(httpResponse, keyValue),expectedValue);
        //assertEquals(jpath.get(keyValue).toString(),expectedValue);
    }


    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resourse) throws IOException {
        //resourse comes from the feature file in this case AddPlaceAPI
        String placeIdFromResponse = getValueFromJsonResponse(httpResponse,"place_id");
        res = given().spec(requestSpecificationNeeded()).queryParam("place_id", placeIdFromResponse);
        user_calls_with_http_request(resourse,"GET");
        String actualName = getValueFromJsonResponse(httpResponse,"name");
        assertEquals(actualName,expectedName);  // expectedName = Kiki from feature file and actualName is extracted from json response


    }

}

package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
    //contains all reusable methods

    RequestSpecification reqSpec;

    public RequestSpecification requestSpecificationNeeded(){

        // Details generic for every Maps API requests, we can collect them in a RequestSpecBuilder method
        // and ResponseSpecBuilder for API generic responses
        RestAssured.baseURI="https://rahulshettyacademy.com";
        reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();
        RestAssured.useRelaxedHTTPSValidation();  // ---> to bypass SSL verification
        return reqSpec;
    }

}

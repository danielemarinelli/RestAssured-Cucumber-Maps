package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {
    //contains all reusable methods

    RequestSpecification reqSpec;

    public RequestSpecification requestSpecificationNeeded() throws FileNotFoundException {

        // all logs directed to an external file that will be created
        PrintStream logToFile = new PrintStream(new FileOutputStream("allLogs.txt"));

        RestAssured.baseURI="https://rahulshettyacademy.com";
        reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(logToFile))
                .addFilter(ResponseLoggingFilter.logResponseTo(logToFile))
                .setContentType(ContentType.JSON).build();
        RestAssured.useRelaxedHTTPSValidation();  // ---> to bypass SSL verification
        return reqSpec;
    }

}

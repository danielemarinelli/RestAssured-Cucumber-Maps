package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    //contains all reusable methods

    RequestSpecification reqSpec;

    public RequestSpecification requestSpecificationNeeded() throws IOException {

        // all logs directed to an external file that will be created
        PrintStream logToFile = new PrintStream(new FileOutputStream("allLogs.txt"));
        // get the base URL from the Properties file
        reqSpec = new RequestSpecBuilder().setBaseUri(getProperties("appURL")).addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(logToFile))
                .addFilter(ResponseLoggingFilter.logResponseTo(logToFile))
                .setContentType(ContentType.JSON).build();
        RestAssured.useRelaxedHTTPSValidation();  // ---> to bypass SSL verification
        return reqSpec;
    }


    //pass any key of the global.properties file and we can return evey value
    public static String getProperties(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\dmarinel\\API\\RSA_BDD_API\\frameworkBDD\\src\\test\\java\\resources\\global.properites");
        properties.load(fis);
        String value = (String) properties.get(key);
        return value;
    }

}

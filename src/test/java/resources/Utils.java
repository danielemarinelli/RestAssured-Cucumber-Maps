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
        reqSpec = new RequestSpecBuilder().setBaseUri(getValueOfProperties("appURL")).addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(logToFile))
                .addFilter(ResponseLoggingFilter.logResponseTo(logToFile))
                .setContentType(ContentType.JSON).setRelaxedHTTPSValidation().build();
        //RestAssured.useRelaxedHTTPSValidation();  // ---> to bypass SSL verification we can set it on the RequestSpecBuilder
        return reqSpec;
    }


    //pass any key of the global.properties file and we can return evey value
    public static String getValueOfProperties(String key) throws IOException {
        String globalPropFilepath = System.getProperty("user.dir") +  //cross-platform compatibility (to handle different path separators in Windows vs. Unix-based systems)
                File.separator + "src" +
                File.separator + "test" +
                File.separator + "java" +
                File.separator + "resources" +
                File.separator + "global.properites";
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(globalPropFilepath);
        properties.load(fis);
        String value = (String) properties.get(key);
        return value;
    }

}

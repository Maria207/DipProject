package de;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import wkda.BodyTypes;
import wkda.BuiltDates;
import wkda.MainTypes;
import wkda.Manufacturer;
import java.io.FileReader;
import java.io.IOException;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import static de.Machine.*;


public class ApiRestTest {

    private static final String BASE_URL = "http://www.wkda.de/papi/v1/car-types";

    @Test
    public void getManufacter2() {

        RestAssured.baseURI = BASE_URL;
        given().
                when().
                get(Manufacturer.MANUFACTURES2.addPath("")).
                then().
                statusCode(200).
                assertThat().
                body("wkda.040", equalTo("Alfa Romeo")).
                body("wkda.107", equalTo("Bentley")).
                body("wkda.230", equalTo("Dodge")).
                body("wkda.277", equalTo("Ferrari")).
                body("wkda.835", equalTo("Westfield"));
    }

    @Test
    public void getMainTypes() {
        RestAssured.baseURI = BASE_URL;
        given().
                when().
                get(MainTypes.MAIN_TYPES2.addPath(String.format("?manufacturer=%s",
                        MANUFACTURE_CODE))).
                then().
                statusCode(200).
                assertThat().
                body("wkda.Azure", equalTo("Azure"));

    }

    @Test
    public void getBuiltDates2() {

        RestAssured.baseURI = BASE_URL;
        given().
                when().
                get(BuiltDates.BUILT_DATES2.addPath(String.format("?manufacturer=%s&main-type=%s",
                        MANUFACTURE_CODE, MAIN_TYPE))).
                then().
                statusCode(200).
                assertThat().
                body("wkda.2008", equalTo("2008"));

    }

    @Test
    public void getBodyTypes2() {

        RestAssured.baseURI = BASE_URL;
        given().
                when().
                get(BodyTypes.BODY_TYPES2.addPath(String.format("?manufacturer=%s&main-type=%s" +
                                "&built-date=%s",
                        MANUFACTURE_CODE, MAIN_TYPE, BUILT_DATE))).
                then().
                statusCode(200).
                assertThat().
//                body("wkda.1007", equalTo("Azure 6.8 V8 Biturbo (336 kW / 457 PS)")).
//                body("wkda.1007", equalTo("Azure 6.8 V8 Biturbo (373 kW / 507 PS)")).
                body("wkda.1007", equalTo("Azure 6.8 V8 (299 kW / 407 PS)"));
    }

    @Test
    public void getMainTypes2() {

        RestAssured.baseURI = BASE_URL;
        given().
                when().
                get(MainTypes.MAIN_TYPES2.addPath(String.format("?manufacturer=%s&main-type=%s" +
                                "&built-date=%s&body-type=%s",
                        MANUFACTURE_CODE, MAIN_TYPE, BUILT_DATE, BODY_TYPE))).
                then().
                statusCode(200).
                assertThat().
                body("wkda", hasItems());

    }


    @Test
    public void POSTRequest() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/java/wkda/postrequest.json");
        Object jsonobj = jsonParser.parse(reader);

        RestAssured.baseURI = BASE_URL;
        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(jsonobj)
                    .post(Manufacturer.MANUFACTURES2.addPath(""));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response " + response.asString());
        System.out.println("Status Code " + response.statusCode());

        assertEquals(301, response.statusCode());


    }





}



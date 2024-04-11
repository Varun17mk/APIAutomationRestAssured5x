package org.example.CRUD.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NONBDD_PATCH {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "8078a3774c35653";

    @Test
    public void testPatchRequest() {
        //URL
        //auth-token - 1500cbad560258b,headers
        //id-1735
        //payload

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/2733");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload).log().all();

        // Calling PATCH method on URI . After hitting we get response
        Response response = requestSpecification.when().patch();

        // to get response to validate response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("VARUN"));


    }
}




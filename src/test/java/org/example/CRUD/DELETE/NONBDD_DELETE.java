package org.example.CRUD.DELETE;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
public class NONBDD_DELETE {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token = "6374c44fa902680";

    @Test
    public void testPatchRequest() {
        //URL
        //auth-token - 1500cbad560258b,headers
        //id-1735


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/4543");
        requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.cookie("token", token);


        // Calling PATCH method on URI . After hitting we get response
        Response response = requestSpecification.when().delete();

        // to get response to validate response
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(403);


    }
}


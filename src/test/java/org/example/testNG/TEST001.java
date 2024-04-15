package org.example.testNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.*;

// ALL annotations of TestNG
public class TEST001 {

    //PUT request
    // Before - Token
    // Payload
    // Id

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token ;

    public void getToken(){
        requestSpecification = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response = requestSpecification.post();
        validatableResponse = response.then();

        // Rest Assured -> Matchers (Hamcrest) - 1-2% Times you will be using it
        validatableResponse.body("token", Matchers.notNullValue());

        // TestNG assertion
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token); //


        // AssertJ
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();

        System.out.println(token);

    }

    public void NONBDDStyle_PUT_request(){

    }
}

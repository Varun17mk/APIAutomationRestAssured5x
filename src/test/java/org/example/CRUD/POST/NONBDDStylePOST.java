package org.example.CRUD.POST;
//import com.google.inject.matcher.Matchers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

public class NONBDDStylePOST {
    @Test
    public void testNonBDDStylePOSTPositive() {
        // Pre Paration

        RequestSpecification r= RestAssured.given();

        String payload = "{\n" +
                "        \"username\": \"admin\",\n" +
                "        \"password\": \"password123\"\n" +
                "}";


        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        // Making Req

        Response response = r.when().post();



        // Validation Part

        ValidatableResponse validatableResponse =  response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);




    }


}

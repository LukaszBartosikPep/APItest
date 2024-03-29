package eu.pepco.lbartosik;
import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredAPITest {

    @Test
    public void GetBookDetails(){


        Response response=given()
                .get("https://demoqa.com/BookStore/v1/Books");  
//                .then()
//                .statusCode(200)
//                .body("books[0].isbn", equalTo("9781449325862"));
                System.out.println(response.getBody().asString());
                response.then().assertThat().body("books[0].isbn", equalTo("9781449325862"));
        response.then().assertThat().body("books", hasItems("isbn"));



//        int statusCode= given().queryParam("CUSTOMER_ID","68195")
//                .queryParam("PASSWORD","1234!")
//                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
//        System.out.println("The response status is "+statusCode);
//
//        given().when().get("http://demo.guru99.com/V4/sinkministatement.php").then().assertThat().statusCode(200);

//        given().when().get("http://demo.guru99.com/V4/sinkministatement.php").then().assertThat().body("TRANSACTION_ID", equalTo("12"));





    }
}

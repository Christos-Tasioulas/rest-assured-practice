package com.example.demo.validations;

import com.example.demo.util.CommonValidations;
import com.example.demo.util.GherkinParser;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@Data
@NoArgsConstructor
public class CustomerValidations {
    MockMvcResponse customerResponse;

    public void hasCustomers() {
        given()
                .when()
                .get("/api/customers")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    public void get(String request) {
        setCustomerResponse(given().when().get(request));
        customerResponse.then().log().all();
        customerResponse.then().statusCode(200);
    }

    public void statusCode(Integer status) {
        customerResponse.then().statusCode(status);
    }

    public void bodySize(Integer size) {
        customerResponse.then().body("size()", equalTo(size));
    }

    public void firstName(String position, String firstName) {
        CommonValidations.validateJSONResponseField(customerResponse, position, "firstName", firstName);
    }

    public void lastName(String position, String lastName) {
        CommonValidations.validateJSONResponseField(customerResponse, position, "lastName", lastName);
    }
}

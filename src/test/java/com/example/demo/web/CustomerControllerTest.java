package com.example.demo.web;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @Test
    void getAllCustomers_shouldReturnOk() {
        given()
                .when()
                .get("/api/customers")
                .then()
                .statusCode(200)
                .body("size()", equalTo(5));
    }

    @Test
    void getCustomerById_shouldReturnOk() {
        given()
                .when()
                .get("/api/customers/byId/1")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("Jack"))
                .body("lastName", equalTo("Bauer"));
    }

    @Test
    void getCustomerByLastName_shouldReturnOk() {
        given()
                .when()
                .get("/api/customers/byLastName/Bauer")
                .then()
                .statusCode(200)
                .body("size()", equalTo(2))
                .body("[0].firstName", equalTo("Jack"))
                .body("[1].firstName", equalTo("Kim"));
    }
}


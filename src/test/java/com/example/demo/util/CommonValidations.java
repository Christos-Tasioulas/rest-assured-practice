package com.example.demo.util;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.response.MockMvcResponse;

import static org.hamcrest.Matchers.equalTo;

public class CommonValidations {

    public static void validateJSONResponseField(MockMvcResponse response, String position, String field, String value) {
        int index = GherkinParser.positionToIndex(position);
        String jsonIndex = index != -1 ?  "[" + index + "]." : "";
        response.then().contentType(ContentType.JSON).body( jsonIndex + field, equalTo(value));
    }
}

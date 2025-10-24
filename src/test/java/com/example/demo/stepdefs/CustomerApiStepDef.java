package com.example.demo.stepdefs;

import com.example.demo.util.MockMvcTestHelper;
import com.example.demo.validations.CustomerValidations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerApiStepDef {

    private final MockMvcTestHelper helper;
    CustomerValidations validate;

    @Autowired
    public CustomerApiStepDef(MockMvcTestHelper helper) {
        this.validate = new CustomerValidations();
        this.helper = helper;
        // Initialize RestAssuredMockMvc with the same MockMvc instance
        RestAssuredMockMvc.mockMvc(helper.getMockMvc());
    }

    @Given("the service has customers")
    public void theServiceHasCustomers() {
        validate.hasCustomers();
    }

    @When("I call GET: {string}")
    public void iCallGet(String path) {
        // Use RestAssuredMockMvc to perform the request (you can store the response if needed)
        validate.get(path);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(Integer status) {
        validate.statusCode(status);
    }

    @Then("the response body size should be {int}")
    public void theResponseBodySizeShouldBe(Integer size) {
        validate.bodySize(size);
    }

    @Then("^the response body firstName should be (.+)$")
    public void theResponseBodyFirstNameShouldBe(String firstName) {
        validate.firstName("", firstName);
    }

    @Then("^the response body lastName should be (.+)$")
    public void theResponseBodyLastNameShouldBe(String lastName) {
        validate.lastName("", lastName);
    }

    @Then("^the response body (.+) firstName should be (.+)$")
    public void theResponseBodyNthFirstNameShouldBe(String position, String firstName) {
        validate.firstName(position, firstName);
    }

    @Then("^the response body (.+) lastName should be (.+)$")
    public void theResponseBodyNthLastNameShouldBe(String position, String lastName) {
        validate.lastName(position, lastName);
    }
}


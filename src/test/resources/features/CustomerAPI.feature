Feature: Customer API

  Scenario: Get All Customers
    Given the service has customers
    When I call GET: "/api/customers"
    Then the response body size should be 5

  Scenario: Get Customer By ID
    Given the service has customers
    When I call GET: "/api/customers/byId/1"
    Then the response body firstName should be Jack
    And the response body lastName should be Bauer

  Scenario: Get Customers By Last Name
    Given the service has customers
    When I call GET: "/api/customers/byLastName/Bauer"
    Then the response body size should be 2
    And the response body 1st firstName should be Jack
    And the response body 2nd firstName should be Kim
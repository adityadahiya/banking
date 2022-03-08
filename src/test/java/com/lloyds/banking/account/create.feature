Feature: Create and Read account ...

  Background:
    * url baseUrl
    * def accountBase = '/account/'

  Scenario: Create an account

    Given path accountBase
    And request { accountNo: 10000, name: 'ADITYA', balance: 10000 }
    And header Accept = 'application/json'
    When method post
    Then status 200
    And match response == '0'

  Scenario: Get the account we just created

    Given path accountBase + '0'
    When method GET
    Then status 200
    And match response == { accountNo: 10000, name: "ADITYA", BALANCE: 10000 }
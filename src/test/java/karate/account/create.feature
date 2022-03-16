Feature: Create and Read account ...

  Background:
    * def accountBase = 'http://localhost:8080/account'

  Scenario: Create an account

    Given url accountBase
    And request { accountNo: 1, name: 'ADITYA', balance: 10000 }
    When method POST
    Then status 200
    And match $ contains {id:"#notnull", accountNo: 1, name: 'ADITYA', balance: 10000}

  Scenario: Get all accounts
    Given url accountBase
    When method GET
    Then status 200
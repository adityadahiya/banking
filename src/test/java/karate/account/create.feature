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

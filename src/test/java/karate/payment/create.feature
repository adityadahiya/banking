@parallel=false
Feature: Create and Read payment ...

  Background:
    * def paymentBase = 'http://localhost:8080/pay'

  Scenario: Create first account

    Given url 'http://localhost:8080/account'
    And request { accountNo: 10000, name: 'ADITYA', balance: 100000 }
    When method POST
    Then status 200
    And match $ contains {id:"#notnull", accountNo: 10000, name: 'ADITYA', balance: 100000}

  Scenario: Create second account

    Given url 'http://localhost:8080/account'
    And request { accountNo: 10001, name: 'DAHIYA', balance: 100000 }
    When method POST
    Then status 200
    And match $ contains {id:"#notnull", accountNo: 10001, name: 'DAHIYA', balance: 100000}
  Scenario: Create a payment

    Given url paymentBase
    And request { fromAccountNo: 10000, toAccountNo: 10001, lastUpdate: '23-11-1996', amount: 10000 }
    When method POST
    Then status 200
    And match $ contains {id:"#notnull"}

  Scenario: Get last 10 payments
    Given url 'http://localhost:8080/pay'
    When method GET
    Then status 200
  
Feature: Customer

  Background: Below are the common steps for each scenario
    Given user launch chrome browser
    When user opens url "http://admin-demo.nopcommerce.com/login"
    And user enters email as  "admin@yourstore.com" and password as "admin"
    And click on login
    Then User should be at homepage

  Scenario: Add new customer
    And User clicks on customers-Admin
    Then Below customer accordian opens
    And User clicks on the Customers list
    And User clicks on Add button
    And User can see Add new customer page
    When User enter customer info
    And Click on save button
    Then Page should display "The new customer has been added successfully."
    And close the browser

  Scenario: Search by EmailID
    Then User should be at homepage
    And User clicks on customers-Admin
    And User clicks on the Customers list
    Then Click on dropdown arrow
    And Enters customer email
    When Click on search button
    And page is scroll down
    Then User should found email in the search table
    And close the browser

  Scenario: Search Customer by Name
    Then User should be at homepage
    And User clicks on customers-Admin
    And User clicks on the Customers list
    Then Click on dropdown arrow
    And Enter customer Firstname
    And Enter customer Lastname
    When Click on search button
    Then User should found name in the search table
    And close the browser
    
    Scenario: Get the data from Web and fetch in excelfile
	    Then User should fetch the Orderrecords table into excelfile

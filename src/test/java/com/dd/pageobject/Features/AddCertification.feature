Feature: Certification
Background: Successful Login with Valid Credentials

 Given User Launch Chrome browser
    When User opens URL "https://www.foundit.in/"
    And Click on Maximize
    And Click on Login
    And User enters Email as "abc@gmail.com" and Password as "pwd123"
    
    
  Scenario: Add Certification
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Profile
    And Click on View Profile
    And Click on Course and Certification
    And Click on Add
    When User enter Certification details
    
    Scenario: Add Certification and Issued
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Profile
    And Click on View Profile
    And Click on Course and Certification
    And Click on Add
    When User enter Certification details

Feature: Login


 Scenario: Successful Login with Valid Credentials Sanity
    Given User Launch Chrome browser
    When User opens URL "https://www.foundit.in/"
    And Click on Maximize
    And Click on Login
    And User enters Email as "abc@gmail.com" and Password as "Pad@123"
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser

@Sanity
   Scenario Outline: Successful Login with Valid Credentials DDT
    Given User Launch Chrome browser
    When User opens URL "https://www.foundit.in/"
    And Click on Maximize
    And Click on Login
    And User enters Email as "<email1>" and Password as "<password1>"
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser


    Examples: 
      | email1               | password1   |
      | abc@gmail.com | Password@123 |
      | abc@gmail.com | Password@123 |
     
     
 

  
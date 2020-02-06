Feature: Home Page


  Scenario: Login with correct username and password
#    Given I navigate to the login page
    And I enter the username as "admin" and password as "admin"
    And I enter following new credentials
      | uname    | pass        |
      | adminone | passwordone |
    And I click login button
    Then I should see the userform page
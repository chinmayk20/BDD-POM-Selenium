Feature: Contacts Page

  @test
  Scenario Outline:: Contacts Page test
    Given I navigate to the login page
    And I click on login Button
    And I enter the username and password
    And I click on contacts link
    And I create a new contact with "<row_index>" dataset
    And I close the browser
    Examples:
      | row_index |
      |    2       |
      |    3       |
  @ck
  Scenario: Test Enum
    Given I navigate to the login page
    And I click on login Button
    And I enter the username and password
    And I see chinmay as name
    And I see Arin as name
    And I see contacts link

  @test
  Scenario: Test Enum
    Given I navigate to the login page
    And I click on login Button
    And I enter the username and password
    And I see following links
      |Home|
      |contacts|
      |Calendar        |

    Scenario: test
      Given I am testing hashmap
      And I am testing boolean
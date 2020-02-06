Feature: Data Driven examples

#DataTable for UserDetails using raw()

  Scenario: To test DataTable for UserDetails using raw()
    And I am good
    Then I enter valid data on the page using raw
      | title     | Dr       | Dr2       |
      | firstname | Cool     | cool2     |
      | lastname  | Test     | Test2     |
      | company   | test.com | test2.com |

  Scenario: To test DataTable for UserDetails using raw() ANOTHER EXAPMLE
    And I am good
    And I enter following new credentials
      | uname    | pass        |
      | adminone | passwordone |

#Using stream Java 8

  Scenario: To test data driven using Using stream Java 8
    And I am good
    And using stream list check links present
      | abc |
      | pqr |
      | plr |

#Using Map in DataTable

  Scenario: To test multiple users using HASHMAP
    And I am good
    Then I enter valid data on the page using HashMap
      | title | firstname | lastname | company   |
      | Dr    | Cool      | Test     | test.com  |
      | Dr2   | cool2     | Test2    | test2.com |

#Using POJO in DataTable

  Scenario: To test multiple users using POJO
    And I am good
    Then I enter valid data on the page using POJO type
      | title | firstname | lastname | company   |
      | Dr    | Cool      | Test     | test.com  |
      | Dr2   | cool2     | Test2    | test2.com |

#Using Scenario Outline

  Scenario Outline: To test Scanario Outline
    And I am good
    Then I enter valid <ttle>
    And I enter valid <firstname>
#    And I enter valid <lastname>
#    And I enter valid <company>
    Examples:
      | ttle | firstname | lastname | company   |
      | Dr   | Cool      | Test     | test.com  |
      | Dr2  | cool2     | Test2    | test2.com |

  Scenario Outline: To test Scanario Outline
    And I am good
    Then I also enter valid <ttle> and <firstname>
    And I also enter valid <lastname> and <company>
    Examples:
      | ttle | firstname | lastname | company   |
      | Dr   | Cool      | Test     | test.com  |
      | Dr2  | cool2     | Test2    | test2.com |

  Scenario Outline: To test Scanario Outline
    And I am good
    Then the user click on the following <link>
    And appropriate <page> gets displayed
    Examples:
      | link | page |
      | policy     |  linkpolicy    |
      | terms     | linkterms     |
Feature: User Registration feature
  I want to check that the user can register in our e-commerce website.

  Scenario Outline: User registration scenario
    Given the user in the home page
    When the user clicks on register
    And enters "<firstname>", "<secondname>", "<password>", "<email>"
    Then user registers successfully and Logins with "<email>", "<password>"

    Examples:
      | firstname | secondname | password | email          |
      | ahmed     | mhmd       | 12345678 | test@test1.com |
      | mhmd      | ahmed      | 123456   | test@test2.com |
Feature: Grinfer login

  Scenario: Login happy pass
    Given I open "HOME" page
    When I click "Log In" link
    Then I see "LOGIN" page
    When I fill email field with "mail@email.com" value
    And I fill password field with "test12345" value
    And I click "Log in" button
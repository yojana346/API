@SmokeTest
Feature: OrangeHRM Login

  Background:
    Given User is on the OrangeHRM login page

  Scenario: Successful login with valid credentials
    When the user enters admin and admin123
    Then the user should see the dashboard

  Scenario: UnSuccessful login with valid credentials
    When User enter credential
      | administrator | adin123 |
    Then the user should see invalid user message
      | name     | age | city          |
      | John Doe | 30  | New York      |
      | Jane Roe | 25  | Los Angeles   |
      | Alice    | 28  | San Francisco |
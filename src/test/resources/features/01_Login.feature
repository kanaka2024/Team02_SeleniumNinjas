
Feature: Verify if admin is sucssessfuly login to  LMS portal.

  Scenario: 
    Given Admin is in LoginPage
    When Admin enters valid user and password with select role as Admin.
    Then Admin should be landing to home page

    
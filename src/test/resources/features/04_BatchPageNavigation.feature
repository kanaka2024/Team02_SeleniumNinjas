#Author: Anusuya Selvaraj

@Batch
Feature: Batch Page Navigation


  Admin successfully Logged on to the  Batch page
  
  Background:  Verify if user is logged in
 
  Given Admin is on the LMS page

  @BatchPageNavigation	


  Scenario: Admin in Batch Page
   Given Admin is on the home Page
    When  Admin clicks Batch tab on top right corner of the LMS page
    Then  Verify the Batch page is displayed

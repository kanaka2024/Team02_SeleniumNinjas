#Author: Anusuya Selvaraj

@Batch
Feature: Add Batch Popup Validation 
  UI validation of the  Add Batch popup

  @AddBatchUI
  Scenario: Verify sub menu displayed in batch menu bar
  
    Given Admin in Home page
    When  Admin clicks "Batch" on the navigation bar
    Then  Admin should see sub menu in menu bar as "Add New Batch"
    
    Given Admin in Home page
    When  Admin clicks on "Add New batch" under the "batch" menu bar
    Then Admin should see the "Batch Details" pop up window
    
    
    
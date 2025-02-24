@DeleteClass
Feature: Delete Class

 Background:
 	Given Admin is on dashboard page after Login and Admin clicks "Class" button on the navigation bar
 	 When Admin clicks on Delete button for Class Topic in manage class
 	 
 @DeletePopup
  Scenario: Verify Delete pop up of class   
    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
    
  @NoButtonClick
  Scenario: Verify No button in Delete pop up of class 
    When Admin clicks No option of Delete pop up of manage class      
    Then Admin can see the deletion alert disappears without deleting class
    
  @YesButtonClick
  Scenario: Verify Yes button in Delete pop up of class 
    When Admin clicks yes option of Delete pop up of manage class      
    Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table
    
   
    

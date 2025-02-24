@EditClass
Feature: Edit Class

 Background:
 	Given Admin is on dashboard page after Login and Admin clicks "Class" button on the navigation bar
 	 When Admin clicks on Edit button for Class Topic in manage class
 	 
 @EditPopup
  Scenario: Verify Edit pop up of class   
    Then A new Edit pop up with class details appears
    
  @BatchFieldEdit
  Scenario: Verify Batch Field Edit pop up of class   
    Then Admin should see batch name field is disabled in class edit pop up
    
    @ValidateEditClassValidMandatefields
  Scenario Outline: Validate admin able to Edit class with valid data in mandatory fields
    When Admin enters all mandatory field values with valid data in Edit class and clicks save button "<TestCase>" and "<Sheetname>" 
    Then Admin gets message class updated Successfully and see the updated values in data table


    Examples: 
      | TestCase                         | Sheetname        |
      | AllMandateFieldsValidDataForEdit | classDetailsForm |
 
  
    

@AddClass
Feature: Add New Class

 Background:
 	Given Admin is on dashboard page after Login and Admin clicks "Class" button on the navigation bar 	
 	 When Admin clicks on "Add New Class" under the class menu bar

  @ValidateaddnewclassvalidMandatefields
  Scenario Outline: Validate admin able to add new class with valid data in mandatory fields
    When Admin enters all mandatory field values with valid data and clicks save button "<TestCase>" and "<Sheetname>"
    Then Admin should see new class details is added in the data table

    Examples: 
      | TestCase                  | Sheetname        |
      | AllMandateFieldsValidData | classDetailsForm |
      
  @ValidateaddnewclassinvalidMandatefields
  Scenario Outline: Validate admin able to add new class with invalid data in mandatory fields
    When Admin enters all mandatory field values with invalid data and clicks save button "<TestCase>" and "<Sheetname>"
    Then Error message should appear in alert

    Examples: 
      | TestCase                     | Sheetname        |
      | ValidateInvalidMandatefields | classDetailsForm |
      
  @validateNumOfClasses
  Scenario Outline: Validate admin able to add new class with invalid data in mandatory fields
    When Admin selects class date in date picker "<TestCase>" and "<Sheetname>"
    Then Admin should see no of class value is added automatically


    Examples: 
      | TestCase                   | Sheetname        |
      | ValidateNumOfClasses       | classDetailsForm |
      
  @DatePickerValidation
  Scenario: Verify weekends are disabled in the date picker   
    When Admin clicks date picker
    Then Admin should see weekends dates are disabled to select
    
  @FormValidationForMandatoryFields
  Scenario Outline: Admin skips adding value in mandatory field and enters value in optional field     
    When Admin skips adding value in the mandatory fields and enters a value in the optional field "<TestCase>" and "<Sheetname>"
    Then Admin should see an error message below mandatory field "<FieldName>", it should be highlighted in red color
    
    Examples: 
    | TestCase   				        | FieldName     | Sheetname        |
		| BatchFieldReqVerification | BatchName		  | classDetailsForm |
		| ClassTopicReqVerification | ClassTopic 	  | classDetailsForm |
		| ClassDatesReqVerification | ClassDates 	  | classDetailsForm |
		| StaffNameReqVerification  | StaffName 	  | classDetailsForm |
		| StatusReqVerification     | Status 		    | classDetailsForm |
		      
      
    
    


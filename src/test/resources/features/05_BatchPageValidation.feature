#Author: Anusuya Selvaraj


@Batch
Feature: Batch Page Validation 

  UI validation of the  Batch page

Background:

 #	Given Admin is on dashboard page after Login and Admin clicks "batch" Module


  @BatchPageNavigation	
    Scenario: Admin in Batch Page
  
    When Admin in batch page
    Then Validate Title in Batch Page
    Then Validate Heading in Batch Page
    Then Validate disabled Delete Icon under the header in the Batch Page
    Then Validate pagination in the Batch Page
    Then Validate edit icon in each data rows
    Then validate delete icon in each data rows
    Then validate checkbox in each data rows
    Then Validate batch Datatable headers
    Then Validate Checkbox in the Datatable header row
    Then Validate sort icon next to all the datatable header
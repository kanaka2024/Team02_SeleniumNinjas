#Author: Anusuya Selvaraj

Feature: Add New Batch

  @AddNewBatch
  Scenario Outline: Admin creates New Batch in LMS
  
   Given Admin in Home page
   When  Click Add New Batch
   Then  Create New Batches <SheetName>

    
    Examples: 
      |SheetName|
      |Batch| 
 
    

@ClassDetails
Feature: Class details Popup window verification

  Background:
 	Given Admin is on dashboard page after Login and Admin clicks "Class" button on the navigation bar 	
 	 When Admin clicks on "Add New Class" under the class menu bar
 	
 	@VerifyClassDetails
			Scenario: Verify class details popup window
      Then Admin should see a popup  with  heading "Class Details"
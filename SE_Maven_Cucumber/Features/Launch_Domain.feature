Feature: Login and Logout 

Scenario: Login functionality
Given I launch the url in chrome browser
When I navigate to LogIn popup
And I enters the username
And I enters the password
And I click on the Login button
Then I should see successful Login
And I logout the session
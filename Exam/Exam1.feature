@SmokeTest
Feature: Login Test

@tag1
Scenario: Successful Login with valid credentials
Given User is on Home page
And Click on Login link
When Enters email and password and clicks login
   | email | password |
   | pratiksha@test.com | pratiksha |
   | rick@test.com | tester |
Then User logged in successfully
   


Feature: Application Login


# Background 	:-When we use for common for Every Scnario's
Background:
Given setup the entries in database
When launch the browser from config variables
And hit the home page url of banking site



@RegressionTest
Scenario: Admin Page default login
Given User is on NetBanking landing page
When User login into application with "admin" and password "1234"
Then Home Page is displayed
And Cards are displayed




@MobileTest
Scenario: User Page default login

Given User is on NetBanking landing page
When User login into application with "user" and password 0953
Then Home Page is displayed 
And Cards are displayed


@SmokeTest @RegressionTest
Scenario Outline: Mortgage User Page default login
# @SmokeTest
#Scenario Outline: Used for parameterization
# <Username> This use for parameteriztion Parameter will take from Examples
Given User is on NetBanking landing page
When User login into application with "<Username>" and password "<Password>"
Then Home Page is displayed 
And Cards are displayed

Examples:
 | Username	 | Password |
 | debituser |  hello12 |
 | crediuser |  lpo213  |
 
 
 
 #Data Driven Testing 
 #Data as List
 #From Here to send to mainSteps file  @When("User Signup into application")
@SmokeTest
Scenario: User Page default Sign up

Given User is on Practice landing page
When User Signup into application
| rahul |
| shetty|
|contact@email.com|
|54343646463|
Then Home Page is displayed 
And Cards are displayed
 
 
 
 
 
 
 
 
 
 
 
















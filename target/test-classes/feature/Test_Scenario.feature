Feature: To verify OpenWeatherMap 5 days functionality

Background:
Given User is navigated to home page

@TestScenario#1
Scenario: To verify 5 Days weather forecast displayed for a city
When  Enter "Perth" as City to Search for Weather forecast
Then  Verify five days forecast is displayed

@TestScenario#2
Scenario: To verify that On clicking on any day 3 hour forecast displayed
When User click on any Day
Then Verify hour forecast is displayed

@TestScenario#3
Scenario: To verify that On clicking on the same day 3 hour forecast Hide
When User click on any Day
And User click on the same Day
Then Verify hour forecast is Hide
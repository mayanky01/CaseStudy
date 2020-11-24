# CaseStudy

This Framework contains mostly three files:


1) Test_Scenario.feature
   Path : /Openweather_casestudy/src/test/java/feature
   Usage: This file contains test scenarios, which supports Gherkin language (Given , When, Then etc.)
   
2) TestCaseStepDefinitions.Java
   Path : /Openweather_casestudy/src/main/java/StepDefinitionsFiles
   Usage: This is a StepDefinitions file (Glue), which contains the implementions of the Scenarios mentioned in Feature file.
   

3) TestRunner.java
   Path : /Openweather_casestudy/src/test/java/TestRunnerFile
   Usage: This file is use to execute test. This mainly contains address of Feature file, Glue and other format related syntax.
   
How To run the TestScenarios.
    PreRequisites: Eclipse, Java, Maven,Node, NPM,Cucumber,Selenium,Chrome 86.0
    
    1) Download the code of the application
    2) Open Node.js
    3) Set the location in Node.js( Where above application is downloaded)
    4) Run "$ npm install" & "$ npm run develop"
    5) Above Steps help to Run application locally
    6) Can verify the application by "http://localhost:3000/ in Chrome Browser.
    7)Clone this automation code in Eclipse.
    8) Right click on "Test Runner.Java" and select Run As as "JUnit Test"
    9) All the scenarios will execute and TestResult would be displayed in Console.
   

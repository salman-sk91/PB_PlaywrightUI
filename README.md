# PB_PlaywrightUI

A simple PB UI Automation using Java + Playwright that verifies functionality of Registeration flow

****************************************************************************
Flow automated as part of the project are as follows -

Use any of the mentioned frameworks to automate the following scenario on www.payback.at:
o Go to “Anmelden”
o Select “Noch keine PAYBACK Karte? Neue Karte auswählen.“
o Select a PAYBACK card of your choice
o Enter some Email and pin and click on “Weiter”
o Enter some personal data (only the mandatory fields)
▪ Please do some assertions on the field validation

****************************************************************************
Tools/Technologies used are as follows - 

* Playwright
* Java
* TestNG
* Maven 
* Surefire

****************************************************************************
How the Framework works?

Its a Modular Test Driven Framework, all the test scenarios use '@Test' annotation of TestNG in their respective test files.
The Browser is initialized at the beggining of each Test file and destroyed at the completion of Test.

Using the Page Object Model to keep all Page Object locators/Web Elements in a separate files for easy maintenance. The default execution happens on chromium browser in headless: false
To switch between actual headless and non-headless run change the parameter \<parameter name="headlessMode" value="false"/> in testNg.xml file.

The Test scenario can be executed using individual test file/ testNg.xml / pom.xml file 

****************************************************************************
How to execute the Tests ?

* Clone the repository to your workspace.
* Build the project using maven
* Execute the test using testng.xml or pom.xml file directly
OR
* Clone the repository to your workspace.
* Run "ExecuteTest" windows batch file
* Once the execution completes the result will be available at: {project.directory}/target/surefire-reports/index.html


****************************************************************************
 Sample Execution Report :
![image](https://user-images.githubusercontent.com/110985162/184166529-6c704811-178f-4fd4-8ac6-c50f1f6c183a.png)

****************************************************************************
Notes:
* Execution using maven command line will provide the test report in HTML format

****************************************************************************

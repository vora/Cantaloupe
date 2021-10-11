# Cantaloupe
Pull the latest code from main branch 
Feature branch will ahve code related to features and will be updated as and when the functionality is added
configure following files:
  a. config.properties: 
      - Currently it's running on iOS simulator - So mobile set up (appium and Xcode) should be available to execute the scripts
      - Specify the input test data excel path 
      - Specify the output files path
      
  b. pom.xml :
      - this file contains all the maven dependencies 

/src/main/java/com/ascendum/Cantaloupe/OutputFiles : This is the path where all the output generated reports are stored. Every excel report has unique name 
/src/main/java/com/ascendum/Cantaloupe/PageActions : This folder contains files for each page and the actions performed on these pages
/src/main/java/com/ascendum/Cantaloupe/PageLocators : This folder contains files with locator details on different pages
/src/main/java/com/ascendum/Cantaloupe/resources/Cantaloupe.xls : This input file contains test data for Loan officers validation

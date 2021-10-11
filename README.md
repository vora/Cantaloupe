# SMLoanPal
Pull the latest code from main branch 
configure following files:
  a. config.properties: 
      - Specify the default browser for testing [Firefox is used as default test browser as chrome has captcha issue]
      - Specify the input test data excel path 
      - Specify the output files path
      - Specify the template path 
  b. pom.xml :
      - this file contains all the maven dependencies 
/src/main/java/com/ascendum/lopal/drivers : This is the path for browser executables 
/src/main/java/com/ascendum/lopal/OutputFiles : This is the path where all the output generated reports are stored. Every excel report has unique name 
/src/main/java/com/ascendum/lopal/PageActions : This folder contains files for each page and the actions performed on these pages - google, linkedin, twitter, zillow           
/src/main/java/com/ascendum/lopal/PageLocators : This folder contains files with locator details on different pages
/src/main/java/com/ascendum/lopal/resources/LoanPal.xls : This input file contains test data for Loan officers validation

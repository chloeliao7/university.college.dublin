
Instructions: 
// to run terminal mvn clean install
// run test cases straight from Eclipse 


to run : 
1. SIMPLE CODE TESTS : (SUREFIRE) - REPORT 
- mvn clean install
- mvn test

https://examples.javacodegeeks.com/enterprise-java/maven/how-to-run-unit-test-with-maven-example/


2. SIMPLE CODE COVERAGE (EMMA) TO SEE AND LOOK AT :
- mvn clean install -Pemma
- mvn clean install 
- mvn emma:emma    
- mvn site 
 
-- test results are in 
 ${project}/target/site/index.html - basic information about whole project 

-- test results about emma 
 ${project}/target/site/emma/index.html  - emma classes 

// notes : 
Mutation Testing : 
"is a type of software testing where we mutate (change) certain statements in the source code and check if the test cases are able to find the errors. It is a type of White Box Testing which is mainly used for Unit Testing"

// info about maven-emma-integration : 
https://www.mkyong.com/maven/maven-emma-integration-example/


// useful commands : 

- mvn site : creates code coverage html package with chrome located in :  ${project}/target/site/index.html.
- mvn clean install : installs everything in java 
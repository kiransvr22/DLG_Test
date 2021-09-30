# DLG_Test

Selenium-Java-testng Framework
A Maven framework in which to build Selenium tests written in Java with testng reports of test results.

Prerequisites
-------------
JDK8 installed
Maven latest installation

Adding Environment Variables
----------------------------
JAVA_HOME: <bin path of java>
MAVEN_HOME :<bin path of maven>

To verify Version of Java  and maven  from command prompt. Below are the command 
Maven -- mvn -version
Java -- java -version

Getting Started
---------------
Copy the repository into your local machine.

Run Tests through IDE
---------------------
Import project has  (Maven) to IDE 
Right click the testng.xml(/src/test/resources/testng.xml) and select "Run As (Maven Build /Goal = clean install)" to start the test.


Run tests through the command line
----------------------------------
As this project uses maven, we can invoke the tests using Maven goals.
From command prompt navigate to root folder of the project and run 
mvn clean install




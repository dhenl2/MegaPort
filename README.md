# MegaPort
 Assignment by MegaPort  
**Note:**  
The instructions below assume that you have installed the Java and have the .jar file for JUnit4 and HamCrest.  
## Running the Application
First compile the required .java files. This will include compiling the test files as well. Open the command prompt at the project directory. At the command prompt type:  
`javac -cp <PathToJUnit> src\MainClass.java src\Person.java test\SorterTest.java`  
Now, to run the application of sorting a given file containing a list of names, type:  
`java src\MainClass <filename>`  

## Testing the Application
First compile the required .java files.  
`java -cp "<PathToJUnit>;<PathToHamCrest>;.\src;.\test" org.junit.runner.JUnitCore SorterTest`

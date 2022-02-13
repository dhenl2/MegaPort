# MegaPort
**Note:**  
The instructions below assume that you have installed the Java and have the .jar file for JUnit4 and HamCrest. To easily test if Java has been installed, enter java then javac into your command prompt. Correct installation will show a helper blog listing possible arguments. Also, the text requested to be entered into the command prompt are intented to be used within Windows. Unix environments will be slightly different so be sure to do your research if needed.
## Running the Application
First compile the required .java files. This will include compiling the test files as well. Open the command prompt at the project directory. At the command prompt type:  
`javac -cp <PathToJUnit> src\MainClass.java src\Person.java test\SorterTest.java`  
Now, to run the application of sorting a given file containing a list of names, type:  
`java -cp .\src MainClass <filename>`  

## Testing the Application
Assuming the files have already been compiled, to run the associcated tests, enter the following into the command prompt:  
`java -cp "<PathToJUnit>;<PathToHamCrest>;.\src;.\test" org.junit.runner.JUnitCore SorterTest`

# HICX-task Directory-Monitor-APP

****

This directory monitor app is made up of four packages: the directory monitor, services, fileProcessor and fileStatistics.
***

**directoryMonitor package:** contains the class that is the heart of the application, the monitorDirectory class. It takes a directory path and monitors the directory for create events. It calls the methods that read files, processes statistics, creates a folder for processed files, and moves processed files on both existing and new files in the directory. 


**services package:** contains all the interfaces in the program. 


**fileProcessor package:** contains the class that takes care of reading content from files.


**statistic package:** contains the classes the process different types of statistics from the file content. The statistics implemented include: word count, number of dots and most used word.

****
The application was developed using Java 17 with IntelliJ IDE. The only dependencies added are those necessary for testing: JUnit, Mockito.
****
The application can be run through the main method. Once you run the main method, the application starts. However, you have to provide a directory path located in your local machine in the 
'working directory' of the Run configuration environment.

Alternatively, you can comment out the first 'if condition' in the main method that checks if a path was passed in the programme argument (the working directory field in the RUN environment) 
and the assign a valid path to a directory in your local machine to the variable **"passedDirectoryPath"** then run the main method to use the programme.




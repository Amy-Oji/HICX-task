# HICX-task Directory-Monitor-APP

****

This directory monitor app is made up of four packages: the directory monitor, services, fileProcessor and fileStatistics.
***

**directory monitor package** contains the class that is the heart of the application, the monitorDirectory class. this class calls the method from the other classes and most importantly, it has the method that monitors the directory that is passed in the argument and listens for create events.


**services** contains all the interfaces in the program. 


**fileProcessor** contains the class that takes care of reading content from files.


**statistic** contains the classes the process different types of statistics from the file content. The statistics implemented include: word count, number of dots and most used word.

****
The application was developed with java 17. The only dependencies added are those necessary for testing, JUnit, Mockito.
The application can be run through the main. once you run the main method, the application starts. However, you have to provide a directory path located in your local machine in the Main class.




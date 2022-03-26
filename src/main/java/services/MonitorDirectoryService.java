package services;

import java.io.IOException;
import java.nio.file.Path;

public interface MonitorDirectoryService {

   void monitorDirectory();

   void printStatistics(Path passedDirectory) throws IOException;

   void createProcessedFolder(Path pathToPassedDirectory);

   void moveProcessedFiles(Path filePath);

}

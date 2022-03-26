import directoryMonitor.MonitorDirectory;
import services.MonitorDirectoryService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

//        checks if a directory path was passed in
//        'working directory' field of the Run/Debug configuration environment


        if (args.length == 0){
            System.out.println(" Please provide a directory in the program arguments ");
            return;
        }

        Path passedDirectoryPath = Path.of(args[0]);
//        checks if the passed path is a valid directory path
        if (!Files.exists(passedDirectoryPath)){
            System.out.println("Directory does not exist ");
            return;
        }

        boolean exists = Files.exists(passedDirectoryPath);

//        prints true if the passed directory path is valid

        System.out.println("folder exists = " + exists);

        MonitorDirectoryService monitor = new MonitorDirectory(passedDirectoryPath);

//        calls the method that runs the application
        monitor.monitorDirectory();

    }
}

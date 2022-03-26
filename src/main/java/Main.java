import directoryMonitor.MonitorDirectory;
import services.MonitorDirectoryService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0){
            System.out.println(" Please provide a directory in the program arguements ");
            return;
        }

        Path testPath = Path.of(args[0]);
        if (!Files.exists(testPath)){
            System.out.println("Directory does not exist ");
            return;
        }

        boolean exists = Files.exists(testPath);
        System.out.println("folder exists = " + exists);

        MonitorDirectoryService monitor = new MonitorDirectory(testPath);
        monitor.monitorDirectory();


    }
}

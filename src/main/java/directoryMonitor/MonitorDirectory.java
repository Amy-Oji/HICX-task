package directoryMonitor;

import fileProcessor.TxtFileProcessor;
import fileStatistics.DotsCountStats;
import fileStatistics.MostUsedWordStat;
import fileStatistics.TotalWordsStats;
import services.FileProcessorService;
import services.MonitorDirectoryService;
import services.StatsProcessorService;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class MonitorDirectory implements MonitorDirectoryService {

    private final Path passedDirectory;

    public MonitorDirectory( Path passedDirectory) {
        this.passedDirectory = passedDirectory;
    }

    private final FileProcessorService txtFileProcessor = new TxtFileProcessor();
    private String fileContent;
    private Path processedFolder;
    WatchKey key;
    WatchService watchService;


    @Override
    public void monitorDirectory() {

//        checking for processed folder
        createProcessedFolder(passedDirectory);

        try {
            printStatistics(passedDirectory);
            watchService = FileSystems.getDefault().newWatchService();
            passedDirectory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    String file = event.context().toString();
                    System.out.println("New directory event: filet-name::"+file+ " just added");
                    System.out.println("Statistics=========================================");
                    createProcessedFolder(passedDirectory);
                    printStatistics(passedDirectory);

                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }

    @Override
    public void printStatistics(Path passedDirectory) throws IOException {
        try{
          var files = Files.newDirectoryStream(passedDirectory, "*.txt");
            List<StatsProcessorService> statsProcessorServices = new ArrayList<>();
            statsProcessorServices.add(new TotalWordsStats());
            statsProcessorServices.add(new MostUsedWordStat());
            statsProcessorServices.add(new DotsCountStats());
          files.forEach(filePath -> {
              fileContent = txtFileProcessor.readFile(filePath);
              Path fileName = filePath.getFileName();
              statsProcessorServices.forEach(s -> System.out.println(fileName + ": " + s.processStats(fileContent)));
              moveProcessedFiles(filePath);
          });
      }catch (IOException e){
          e.printStackTrace();
      }

    }


    @Override
    public void createProcessedFolder(Path pathToPassedDirectory) {
        processedFolder = pathToPassedDirectory.resolve("processedFolder");
        try {
            if (!Files.exists(processedFolder)) {
                Files.createDirectories(processedFolder);
            }
        } catch (Exception e) {
            System.out.println("failed");;
        }
    }

    @Override
    public void moveProcessedFiles(Path filePath) {
        try {
            Files.move(filePath, processedFolder.resolve(filePath.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
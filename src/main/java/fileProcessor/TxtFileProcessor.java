package fileProcessor;

import services.FileProcessorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TxtFileProcessor implements FileProcessorService {
    //method to read from file

    @Override
    public String readFile(Path path) {
        String content = "";

        try(BufferedReader bufferedReader = Files.newBufferedReader(path)){
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                content += line;
            }
        } catch (IOException e) {
        e.printStackTrace();
    }
        return content;
    }

}


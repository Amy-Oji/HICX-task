package services;

import java.nio.file.Path;

public interface FileProcessorService {
    String readFile(Path path);
}

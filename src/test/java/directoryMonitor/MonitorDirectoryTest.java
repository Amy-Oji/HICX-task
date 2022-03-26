package directoryMonitor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class MonitorDirectoryTest {



    @Test
    public void monitorDirectory() {
        MonitorDirectory monitorDirectory = mock(MonitorDirectory.class);
        doNothing().when(monitorDirectory).monitorDirectory();
        monitorDirectory.monitorDirectory();
        verify(monitorDirectory, times(1)).monitorDirectory();

    }


    @Test
    public void createProcessedFolder() {
        Path path = mock(Path.class);
        MonitorDirectory monitorDirectory = new MonitorDirectory(path);
        monitorDirectory.createProcessedFolder(path);

        verify(path, times(1)).resolve("processedFolder");
    }

}
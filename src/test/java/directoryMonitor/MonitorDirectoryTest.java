package directoryMonitor;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.nio.file.Path;

public class MonitorDirectoryTest {

    @Mock
    Path path;

    @InjectMocks
    MonitorDirectory monitorDirectory;


    @Test(expected = NullPointerException.class)
    public void monitorDirectory() {
        monitorDirectory.monitorDirectory();
    }

    @Test
    public void printStatistics() {
    }

    @Test
    public void createProcessedFolder() {
    }

    @Test
    public void moveProcessedFiles() {
    }
}
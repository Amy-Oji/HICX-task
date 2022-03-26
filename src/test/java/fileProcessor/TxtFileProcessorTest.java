package fileProcessor;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import java.nio.file.Path;

import static org.junit.Assert.*;

public class TxtFileProcessorTest {
    TxtFileProcessor txtFileProcessor;

    @Before
    public void setUp() throws Exception {
        txtFileProcessor = new TxtFileProcessor();
    }

    @Test
    public void readFileShouldReadARandomFile() {
        String expected = "Random test";
        String actual = txtFileProcessor.readFile(Path.of("src/test/resources/testfile.txt"));
        assertEquals("Should return random Test", expected, actual);
    }
}
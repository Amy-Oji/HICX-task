package fileStatistics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TotalWordsStatsTest {
    private TotalWordsStats totalWordsStats;

    @Before
    public void setUp() throws Exception {
        totalWordsStats = new TotalWordsStats();
    }

    @Test
    public void processStats() {
        String expected = "The total number of words is === " + 8;
        String actual = totalWordsStats.processStats(expected);

        assertEquals(expected, actual);
    }
}
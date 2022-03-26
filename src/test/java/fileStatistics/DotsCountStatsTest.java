package fileStatistics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DotsCountStatsTest {
    DotsCountStats dotsCountStats;

    @Before
    public void setUp() throws Exception {
        dotsCountStats = new DotsCountStats();
    }

    @Test
    public void shouldCountTheNumberOfDots_SimpleTest() {
        String expected = "The total number of dots is ==== " + 5;
        String actual = dotsCountStats.processStats(".....");

        assertEquals(expected, actual);
    }
}
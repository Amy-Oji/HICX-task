package fileStatistics;

import services.StatsProcessorService;

import java.util.Arrays;

public class TotalWordsStats implements StatsProcessorService {
//  method for total number of words

    private static final String TOTAL_WORD_STATS = "The total number of words is === ";

    @Override
    public String processStats(String fileContent) {

        String [] words = fileContent.split("\\s");

        long count = Arrays.stream(words).count();

        return TOTAL_WORD_STATS + count;
    }
}

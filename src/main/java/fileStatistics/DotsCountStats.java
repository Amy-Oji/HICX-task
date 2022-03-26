package fileStatistics;

import services.StatsProcessorService;

public class DotsCountStats implements StatsProcessorService {
//    method to get total number of dots in the files

    private static final String TOTAL_DOTS_SATS = "The total number of dots is ==== " ;

    @Override
    public String processStats(String fileContent) {

        String [] words = fileContent.split("");

        int dotCount = 0;

        for (String chars : words) {

            if (chars.equals(".")) {
                dotCount++;
            }

        }
            return TOTAL_DOTS_SATS + dotCount;

    }
}

package fileStatistics;

import services.StatsProcessorService;

public class MostUsedWordStat implements StatsProcessorService {
//    method to get most used word

private static final String MOST_USED_WORD = "The most used word is ==== ";

    @Override
    public String processStats(String fileContent) {

        String atTheCountOf = " with count at:  ";

        String [] words = fileContent.split(" ");

        int count, maxCount = 0;

        String word = "";

        for(int i = 0; i < words.length; i++){
            count = 1;

            //Count each word in the file and store it in variable count

            for(int j = i+1; j < words.length; j++){
                if(words[i].equals(words[j])){
                    count++;
                }
            }

            if(count > maxCount){
                maxCount = count;
                word = words[i];
                word += " ";
            }
        }

        return MOST_USED_WORD + word +"===="+ atTheCountOf + maxCount;

    }



}

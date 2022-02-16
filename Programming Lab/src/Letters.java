import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Letters {

    public static final int[] scores = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10, 0};
    public static final int[] counts = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
    public static final String[] alphabet= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","*"};


    private static WordScore wordScore( final String word, final int[] tileCounts    ) {
        String[] Words = word.split("(?!^)");
        int i;
        int j;
        int score = 0;
        for (i = 0; i < Words.length; i++) {
            Words[i] = Words[i].toUpperCase();
            for (j = 0; j < alphabet.length-1; j++)
            {
                if (Objects.equals(Words[i], alphabet[j]) & tileCounts[j] > 0) {
                    score = score + scores[j];
                    tileCounts[j] = tileCounts[j] - 1;
                }
            }
           if (tileCounts[26] > 0) {
             tileCounts[26] = tileCounts[26] - 1;
             Words[i] = "*";
           }
           else {return null;
            }
        }

        String word1 =Words.toString();
        final WordScore wS = new WordScore(word1,score);
        return wS;
    }

    public static List<WordScore> validWords(final List<String> wordList, final int[] tileCounts){
        int i ;
        ArrayList<WordScore> WordList = new ArrayList<>();
      for(i = 0;i < wordList.size();i++){
          String wrd= wordList.get(i);

          if (wordScore(wrd, tileCounts) != null) {

              WordList.add(wordScore(wrd, tileCounts));
          }
      }
      WordScore.sort(WordList);

        return WordList;
    }


}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Assignment2 {


    public static List<WordScore> test1() {
        final Dictionary dictionary = new Dictionary("words-sowpods-1.txt");
        return Letters.validWords(dictionary.words(), Letters.counts);
    }




    public static void task2a(final List<String> wdList) {
        int l;
        int k;
        ArrayList<Integer> scoreList = new ArrayList<>();
        for (l = 0; l < wdList.size(); l++) {
            String word = wdList.get(l);
            String[] Words = word.split("(?!^)");
            int i;
            int j;
            int score = 0;
            for (i = 0; i < Words.length; i++) {
                Words[i] = Words[i].toUpperCase();
                for (j = 0; j < Letters.alphabet.length - 1; j++) {
                    if (Objects.equals(Words[i], Letters.alphabet[j])) {
                        score = score + Letters.scores[j];

                    }
                }

            }
            scoreList.add(score);
        }
        Collections.sort(scoreList, Collections.reverseOrder());


        for (k = 0; k < wdList.size(); k++) {
            String word = wdList.get(k);
            String[] Words = word.split("(?!^)");
            int i;
            int j;
            int count = 0;
            int ind = k + 1;
            int score = 0;
            for (i = 0; i < Words.length; i++) {
                Words[i] = Words[i].toUpperCase();
                for (j = 0; j < Letters.alphabet.length - 1; j++) {
                    if (Objects.equals(Words[i], Letters.alphabet[j])) {
                        score = score + Letters.scores[j];

                    }
                }

            }


            if (Objects.equals(scoreList.get(k), scoreList.get(ind))) {
                count = count + 1;
            } else if (scoreList.get(k) > scoreList.get(ind)) {
                count = 0;

            }

            if (scoreList.get(0) == score & count == 0) {
                System.out.println("Highest(s) word+ score " + word + ", " + score);
            } else if (count >= 1) {
                for (int g = 0; g < count; g++) {
                    if (scoreList.get(g) == score) {
                        System.out.println("Highest(s) word+ score " + word + ", " + score);
                    }
                }
            }
        }
    }





    public static void main(String[] args) {
//task one
        int i;

        int total = 0;

        for (i = 0; i < Letters.scores.length; i++) {
            int score = Letters.scores[i] * Letters.counts[i];
            total = total + score;
        }
        System.out.println("the total letter score= " + total);

// task 2
        final Dictionary dictionary = new Dictionary("words-sowpods-1.txt");

         task2a(dictionary.words());
    }
}

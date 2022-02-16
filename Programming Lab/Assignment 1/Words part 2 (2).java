/**
 * I2P Assignment 1
 * Bindia Parekh i6225857
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Words {

    private static final int NUM_LETTERS = 26;
    private static final int[] num1grams = new int[NUM_LETTERS];
    private static final int[][] num2grams = new int[NUM_LETTERS][NUM_LETTERS];
    private static final int[][][] num3grams = new int[NUM_LETTERS][NUM_LETTERS][NUM_LETTERS];
    private static final int[][][][] num4grams = new int[NUM_LETTERS][NUM_LETTERS][NUM_LETTERS][NUM_LETTERS];




    private static ArrayList<String> Lines;

//code for loading file into array:
    public static List<String> loadWords(final File fileName) throws IOException {
        Lines = new ArrayList<String>();

        try ( BufferedReader ignored = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),
                "UTF-8"))) {

            // code for with while loop written by Javin Paul URL: https://www.java67.com/2016/07/how-to-read-text-file-into-arraylist-in-java.html
            String line = ignored.readLine();
            int count = 0;

            while (line != null) {
                if (validWord(line)== true){

                    line = line.toLowerCase();
                    line = line.trim();
                   Lines.add(line);
                   line = ignored.readLine();
                }

            }

            ignored.close();

        }catch( final IOException e){ e.printStackTrace(); }


        return Lines;

    }

//code for checking validity
// regex pattern condition for at least one letter and all letters was seen from a example here:  https://www.java67.com/2016/07/how-to-read-text-file-into-arraylist-in-java.html by adarshr
    public static <size> boolean validWord(final String word) {

            if (Pattern.matches("[a-zA-Z]+", word)) {

                return true;
            }

            else {

                return false;
            }

    }

//code for calculating n-grams up to 4
    static void countNGrams(final List<String> words) {
        for (String word : words) {
//calculate 1-grams
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                num1grams[pos]++;
            }
//calculate 2-grams
            for (int i = 0; i < word.length() - 1; i++) {
                int pos = word.charAt(i) - 'a';
                int pos2 = word.charAt(i + 1) - 'a';
                num2grams[pos][pos2]++;
            }

//calculate 3-grams
                for (int i = 0; i < word.length()-2; i++) {
                    int pos = word.charAt(i) - 'a';
                    int pos2 = word.charAt(i + 1) - 'a';
                    int pos3 = word.charAt(i + 2) - 'a';
                    num3grams[pos][pos2][pos3]++;
                }
//calculate 4-grams
                for (int i = 0; i < word.length() - 3; i++) {
                    int pos = word.charAt(i) - 'a';
                    int pos2 = word.charAt(i + 1) - 'a';
                    int pos3 = word.charAt(i + 2) - 'a';
                    int pos4 = word.charAt(i + 3) - 'a';
                    num4grams[pos][pos2][pos3][pos4]++;
                }

        }
    }

    //Test method

    private void test() throws IOException {
        File file = new File("C:\\Users\\bindi\\IdeaProjects\\MyFirstProgram.java\\out\\production\\MyFirstProgram.java\\words-sowpods.txt");
        countNGrams(loadWords(file));
        int max = 0;
        for (int i = 1; i < num1grams.length; i++) {
            if (num1grams[i] > num1grams[max]) {
                max = i;
                System.out.println("The most common 1-gram is '" + (char) ('a' + max) + "' with a count of " + num1grams[max]);
            }

            if (num2grams[i][i] > num2grams[max][max]) {
                max = i;
                System.out.println("The most common 1-gram is '" + (char) ('a' + max) + "' with a count of " + num2grams[max]);
            }

            if (num3grams[i][i][i] > num3grams[max][max][max]) {
                max = i;
                System.out.println("The most common 1-gram is '" + (char) ('a' + max) + "' with a count of " + num3grams[max]);
            }
            if (num4grams[i][i][i][i] > num4grams[max][max][max][max]) {
                max = i;
                System.out.println("The most common 1-gram is '" + (char) ('a' + max) + "' with a count of " + num4grams[max]);
            }
        }
    }


        public static void main(final String[] args) throws IOException {
        File file = new File("C:\\Users\\bindi\\IdeaProjects\\MyFirstProgram.java\\out\\production\\MyFirstProgram.java\\words-sowpods.txt");
            final Words app = new Words();
            app.test();

        loadWords(file);


            int size = Lines.size();
            String[] Letters = new String[size];
            String[] Words= new String[size];
            int[] wordLength= new int[size];
            int count = 0;
            int count1 = 0;

// Lines array list was made private claas variable method inorder to be accessed by loop

             //Loop to create array which will count total number of words and letters:
            //int [] wordLength array was created in case of misinterpretation of question.


            // modified code for total number of words, written by java point URL:https://www.javatpoint.com/program-to-find-the-number-of-words-in-the-given-text-file
            // to obtain total number letters code was modifies to split into letters instead of words with regex (?!^) seen from answers on https://stackoverflow.com/questions/5235401/split-string-into-array-of-character-strings by Stephan
            for (int i = 0; i < Lines.size(); i++) {
                String word = Lines.get(i);

                Letters = word.split("(?!^)");
                Words= word.split(" ");
                if (Letters.length<20)
                    count = count + Letters.length;
                count1 = count1 + Words.length;
                wordLength[i]=Letters.length;
                //if each length is to be printed separately:
               //System.out.println(wordLength[i]);
            }

            System.out.println("Total number of words "+ count1);
            System.out.println("Number of words loaded of each length "+ count);



        }


}



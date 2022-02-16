/**
 * I2P Assignment 1
 * Bindia Parekh i6225857
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Words {
private static ArrayList<String> Lines;

    public static List<String> loadWords(final File fileName) throws IOException {
        Lines = new ArrayList<String>();

        try ( BufferedReader ignored = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),
                "UTF-8"))) {

            // code for with while loop written by Javin Paul URL: https://www.java67.com/2016/07/how-to-read-text-file-into-arraylist-in-java.html

            String line = ignored.readLine();
            int count = 0;

            while (line != null) {

                Lines.add(line);
                line = ignored.readLine();

            }

            ignored.close();

        }catch( final IOException e){ e.printStackTrace(); }


        int counter;


        for (int i = 0; i < Lines.size(); i++) {
            String letter = (Lines.get(i));
            validWord(letter);

            if (validWord(letter)== true){

                letter = letter.toLowerCase();
                letter = letter.trim();
                Lines.set(i, letter);
            }

        }
        return Lines;

    }

// regex pattern condition for at least one letter and all letters was seen from a example here:  https://www.java67.com/2016/07/how-to-read-text-file-into-arraylist-in-java.html by adarshr
    public static <size> boolean validWord(final String word) {

            if (Pattern.matches("[a-zA-Z]+", word)) {

                return true;
            }

            else {

                return false;
            }

    }

    

    public static void main(final String[] args) throws IOException {
        File file = new File("C:\\Users\\bindi\\IdeaProjects\\MyFirstProgram.java\\out\\production\\MyFirstProgram.java\\words-sowpods.txt");

        loadWords(file);
        

// Lines array list was made private outside method inorder to be accessed by loop
        
//Loop to create array which will count total number of words and letters
//int [] wordLength array was created in case of misinterpretation of question.
       
        // modified code for total number of words obtained written by java point URL:https://www.javatpoint.com/program-to-find-the-number-of-words-in-the-given-text-file
        // to obtain total number letters code was modifies to split into letters instead of words with regex (?!^) seen from answers on https://stackoverflow.com/questions/5235401/split-string-into-array-of-character-strings by Stephan
        int size = Lines.size();
        String[] Letters = new String[size];
        String[] Words= new String[size];
        int[] wordLength= new int[size];
        int count = 0;
        int count1 = 0; 
        
        for (int i = 0; i < Lines.size(); i++) {
            String word = Lines.get(i);

            Letters = word.split("(?!^)");
            Words= word.split(" ");
            if (Letters.length<20)
                count = count + Letters.length;
            count1 = count1 + Words.length;
            wordLength[i]=Letters.length;
            //if each length is to be printed separately:
//            System.out.println(wordLength[i]);
        }

        System.out.println("Total number of words "+ count1);
        System.out.println("Number of words loaded of each length "+ count);
    }

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * I2P Assignment 2: Dictionary class to load a list of words from file.
 * @author cambolbro
 */
public class Dictionary
{
	private static final int MAX_WORD_LENGTH = 20;

	/** List of words read in from file. */
	private final List<String> words = new ArrayList<>();
		
	//-------------------------------------------------------------------------

	/**
	 * Constructor.
	 * @param fileName File to load words from. Use file name only, not path!
	 */
	public Dictionary(final String fileName)
	{
		load(fileName);
	}
	
	//-------------------------------------------------------------------------
	// Getters
	
	/**
	 * @return Read-only reference to word list.
	 */
	public List<String> words()
	{
		return Collections.unmodifiableList(words);
	}
	
	//-------------------------------------------------------------------------

	/**
	 * @return Whether the specified word has one or more characters, 
	 *         all of which are letters.
	 */
	private static boolean validWord(final String word)
	{
		final int length = word.length();
		if (length < 1)
			return false;  // zero-length string
		
		for (int c = 0; c < length; c++)
			if (!Character.isLetter(word.charAt(c)))
				return false;  // character is not a letter
		
		return true;
	}
	
	//-------------------------------------------------------------------------

	/**
	 * @return Number of valid words loaded from the specified file.
	 *         Assume one word per line.
	 */
	private int load(final String fileName)
	{
		words.clear();
		
		try 
		(
			BufferedReader reader = new BufferedReader
			(
				new InputStreamReader(new FileInputStream(fileName), "UTF-8")
			)
		)
		{
			String line = reader.readLine();
			while (line != null)
			{
				final String word = line.trim().toUpperCase();
				if (word.length() <= MAX_WORD_LENGTH && validWord(word))
					words.add(word);
				line = reader.readLine();
			}
		} 
		catch (final IOException e) 
		{
			e.printStackTrace();
		}		
		System.out.println(words.size() + " words loaded.");
		
		return words.size();
	}

	//-------------------------------------------------------------------------

	/**
	 * @return The Levenshtein or "edit" distance between two strings. 
	 *         This is the minimum number of edits (additions, removals or 
	 *         substitutions) required to convert one string into the other.
	 *         Code adapted from: https://en.wikipedia.org/wiki/Levenshtein_distance
	 */
	public static int distance(final String wordA, final String wordB) 
	{
		final int lengthA = wordA.length();
		final int lengthB = wordB.length();
		
		final int[][] dist = new int[lengthA + 1][lengthB + 1];
 
		for (int a = 0; a < lengthA + 1; a++) 
		{
			// Extract out chA variable but avoid charAt(-1) on first iteration
			final char chA = (a == 0) ? ' ' : wordA.charAt(a - 1);
			
			for (int b = 0; b < lengthB + 1; b++) 
			{
				if (a == 0) 
					dist[a][b] = b;  // worst case for empty wordA
	            else if (b == 0) 
	                dist[a][b] = a;  // worst case for empty wordB
	            else 
	                dist[a][b] = 
	                	Math.min
	                	(   // Minimum edit cost to match characters a and b
	                		dist[a - 1][b - 1] + (chA == wordB.charAt(b - 1) ? 0 : 1), 
	                		Math.min(dist[a - 1][b] + 1, dist[a][b - 1] + 1)
	                	);
			}
		}
		return dist[lengthA][lengthB];  // accumulated edit distance
	}

	//-------------------------------------------------------------------------

	/**
	 * @return Novelty estimate in the range 0..1, where: 
	 *         0 == duplicate word exists in list 
	 *         1 == word is entirely novel
	 *         Novelty is based on the minimum number of edits required 
	 *         to convert the target word to the closest known word. 
	 *         Returns 0 if the word is empty. 
	 */
	public double novelty(final String word)
	{
		final int length = word.length();
		if (length == 0)
			return 0;  // empty word
		
		// Find edit distance to closest known word 
		int minDistance = Integer.MAX_VALUE;
		
		for (final String known : words)
		{
			final int distance = distance(word, known);
			
			if (distance == 0)
				return 0;  // exact match found!
			
			if (distance < minDistance)
				minDistance = distance;
		}
		return (double)minDistance / length;
	}
	
	//-------------------------------------------------------------------------

}

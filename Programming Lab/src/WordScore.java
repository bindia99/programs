import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * I2P Assignment 2: Record of a word and its score.
 *                   A word's score is the total number of Scrabble 
 *                   points for the letters that make up the word.
 * @author cambolbro
 */
public class WordScore
{
	private final String word;  // the word (can include blanks '*')
	private final int score;    // its score
	
	//-------------------------------------------------------------------------
	
	public WordScore(final String word, final int score)
	{
		this.word  = word;
		this.score = score;
	}

	//-------------------------------------------------------------------------
	// Getters

	public String word()
	{
		return word;
	}
	
	public int score()
	{
		return score;
	}
	
	//-------------------------------------------------------------------------

	/**
	 * Sort list of WordScore objects by score.
	 */
	public static void sort(final List<WordScore> list)
	{
		Collections.sort(list, new Comparator<WordScore>() 
		{
			@Override
			public int compare(final WordScore wsA, final WordScore wsB)
			{
				return Integer.compare(wsB.score(), wsA.score());
			}
		});
	}
	
	//-------------------------------------------------------------------------		

}

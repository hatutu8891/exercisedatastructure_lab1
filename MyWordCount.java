/**
 * 
 */
package lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * TASK 1 : WORD COUNT
 * This is the class to implement a program for counting words in a text file.
 * @author hp
 *
 */
public class MyWordCount {
//	 public static final String filename="data/hamlet.txt";
	public static final String filename = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> result = new ArrayList<>();
		for (String word : words) {
			WordCount wc = new WordCount(word, countWord(word));
			if (!result.contains(wc))
				result.add(wc);

		}
		return result;
	}

	// To support count the number of times each unique token appears in the file
	public int countWord(String word) {
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (word.equals(words.get(i))) {
				count++;
			}
		}
		// count = Collections.frequency(words, word);//
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> result = new HashSet<>();
		List<WordCount> list = getWordCounts();
		for (WordCount wc : list) {
			if (wc.getCount() == 1)
				result.add(wc.getWord());

		}
		return result;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> result = new HashSet<>();
		List<WordCount> list = getWordCounts();
		for (WordCount wc : list) {
			if (wc.getCount() != 1)
				result.add(wc.getWord());

		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> exportWordCounts() {
		Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount w1, WordCount w2) {
				int countComparison = w1.getCount() - w2.getCount();
				if (countComparison != 0) {
					return countComparison;
				} else {
					return w1.getWord().compareTo(w2.getWord());
				}
			}
//			@Override
//			public int compare(WordCount w1, WordCount w2) {
//				return w1.getWord().compareTo(w2.getWord());
//			}
		});
		result.addAll(getWordCounts());

		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount w1, WordCount w2) {
				int countComparison = w1.getCount() - w2.getCount();
				if (countComparison != 0) {
					return -countComparison;
				} else {
					return w1.getWord().compareTo(w2.getWord());
				}
			}
//			@Override
//			public int compare(WordCount w1, WordCount w2) {
//				return -(w1.getCount() - (w2.getCount()));
//			}
		});
		result.addAll(getWordCounts());

		return result;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> result = new HashSet<>();
		for (String word : words) {
			if (!word.startsWith(pattern)) {
				result.add(word);
			}
		}
		return result;
	}

}

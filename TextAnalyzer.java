/**
 * 
 */
package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * TASK 2 : MAP AND TEXT FILE
 * 
 * This is the class using Map to store each pair <word, its positions>. We use
 * ArrayList for the positions of each word in the text file.
 * 
 * Inside this class, the main method is included.
 * 
 * @author hp
 *
 */
public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	// load words in the text file given by fileName and store them into map by
	// using add method in Task 2.1.

	// Using BufferedReader as in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		int realIndex;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
//					add(word, -index);
					realIndex = -index;
				} else {
//					add(word, index);
					realIndex = index;
				}
				index++;
				// Put the word into the map
				if (!map.containsKey(word)) {
					map.put(word, new ArrayList<Integer>());
				}
				map.get(word).add(realIndex);
			}
		}

		reader.close();

	}

	/**
	 * @return the map
	 */
	public Map<String, ArrayList<Integer>> getMap() {
		return map;
	}

	// Task 2.1
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) throws IOException {
		if (map.containsKey(word)) {
			ArrayList<Integer> values = map.get(word);
			values.add(position);
		} else {
			ArrayList<Integer> values = new ArrayList<>();
			values.add(position);
			map.put(word, values);

		}

	}

	// Task 2.2
	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		TreeMap<String, ArrayList<Integer>> result = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		result.putAll(map);
		System.out.println(result);
	}

	// Task 2.3
	// This method will display the content of the text file stored in the map
	public void displayText() {
		Map<Integer, String> top = new HashMap<>();
		Iterator<Map.Entry<String, ArrayList<Integer>>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, ArrayList<Integer>> text = iter.next();
			String key = text.getKey();
			ArrayList<Integer> values = text.getValue();
			for (int index : values) {
				top.put(index, key);
			}
		}
		Set<Integer> keys = top.keySet();
		for (int k : keys) {
			if (k < 0) {
				System.out.print(top.get(k) + "\n");
			} else {
				System.out.print(top.get(k) + " ");
			}
		}
	}

	// Task 2.4
	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String result = null;
		int max = 0;
		Set<String> keys = map.keySet();
		for (String key : keys) {
//			ArrayList<Integer> values = map.get(keys);
			ArrayList<Integer> values = map.get(key);
			if (values.size() > max) {
				max = values.size();
				result = key;
			}
		}

		return result;
	}

	// This is the main method of class.
	public static void main(String[] args) throws IOException {
		// Declare text variable of class TextAnalyzer.
		TextAnalyzer text = new TextAnalyzer();

		// This is the testcase of method load.
		try {
			text.load("data/short.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(text.getMap());// This line is print the result of method load

		// This is the testcase of method add
		text.add("harry", 7);
		System.out.println("\n" + text.getMap());// This line is print the result

		// This is the testcase of method displayWords
		System.out.println("\n" + "This is positions of each word, one word per line, in alphabetical order");
		text.displayWords();

		// This is the testcase of method displayText
		System.out.println("\n" + "The content of the text file stored in the map is: ");
		text.displayText();

		// This is the testcase of method mostFrequentWord
		System.out
				.println("\n" + "The word that occurs most frequently in the text file is: " + text.mostFrequentWord());
	}
}

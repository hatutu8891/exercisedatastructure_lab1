/**
 * 
 */
package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * TASK 1 : WORD COUNT
 * 
 * This is the class uses implementations of Map to write a program for counting
 * words in a text file.
 * 
 * Inside this class, the main method is included.
 * 
 * @author hp
 *
 */
public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public MyWordCountApp() throws FileNotFoundException {
		this.loadData();
	}

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File(fileName));

		while (input.hasNext()) {
			String word = input.next();
			map.put(word, map.getOrDefault(word, 0) + 1);

		}
		System.out.println(map);
	}

	// Returns the number of distinct tokens in the file data/hamlet.txt or fit.txt
	public int countDistinct() throws FileNotFoundException {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		int count;
		for (String word : map.keySet()) {
			count = map.get(word);
			System.out.println(word + "-" + count);

		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		Map<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareToIgnoreCase(o2);
			}
			
		});
		sortedMap.putAll(map);
		System.out.println(sortedMap);

	}

	// This is the main method of class MyWordCountApp.
	public static void main(String[] args) throws FileNotFoundException {
		// This is the testcase of method loadData of class MyWordCountApp
		MyWordCountApp app = new MyWordCountApp();

		// This is the testcase of method countDistinct of class MyWordCountApp
		System.out.println("\n"+"The number of distinct tokens in the file is: " + app.countDistinct());

		// This is the testcase of method printWordCounts of class MyWordCountApp
		System.out.println("\n"+"The number of times each unique token appears in the file is: ");
		app.printWordCounts();

		// This is the testcase of method printWordCountsAlphabet of class
		// MyWordCountApp
		System.out.println("\n"+"The number of times each unique token appears are sorted to alphabet in the file is: ");
		app.printWordCountsAlphabet();

	}

}

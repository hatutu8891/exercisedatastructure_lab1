/**
 * 
 */
package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * TASK 1 : WORD COUNT
 * This is the class to test class MyWordCount
 * @author hp
 *
 */
public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File("data/fit.txt"));

		while (input.hasNext()) {
			String word = input.next();
			System.out.println(word);
		}
		
		
		MyWordCount wordCount = new MyWordCount();
		//This is the testcase of getWordCounts method of class MyWordCount
		System.out.println(wordCount.getWordCounts());
		
		//This is the testcase of getUniqueWords method of class MyWordCount
		System.out.println(wordCount.getUniqueWords());
		
		//This is the testcase of getDistinctWords method of class MyWordCount
		System.out.println(wordCount.getDistinctWords());
		
		//This is the testcase of exportWordCounts method of class MyWordCount
		System.out.println(wordCount.exportWordCounts());
		
		//This is the testcase of exportWordCountsByOccurence method of class MyWordCount
		System.out.println(wordCount.exportWordCountsByOccurence());
		
		//This is the testcase of filterWords method of class MyWordCount
		System.out.println(wordCount.filterWords("D"));
	}

}

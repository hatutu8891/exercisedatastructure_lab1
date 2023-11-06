/**
 * 
 */
package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TASK 1 : WORD COUNT
 * 
 * This is the class to implement the method loadWords to save the input file
 * into a list that can be processed in methods of class MyWordCount
 * 
 * @author hp
 *
 */
public class Utils {
	public static List<String> loadWords(String fileName) throws FileNotFoundException {
		List<String> re = new ArrayList<String>();
		Scanner input = new Scanner(new File(fileName));

		while (input.hasNext()) {
			String word = input.next();
			re.add(word);
		}
		return re;
	}

}

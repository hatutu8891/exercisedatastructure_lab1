/**
 * 
 */
package lab7;

import java.util.Objects;

/**
 * TASK 1 : WORD COUNT
 * 
 * 
 * @author hp
 *
 */
public class WordCount {
	private String word;
	private int count;

	/**
	 * @param word
	 * @param count
	 */
	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + word.hashCode();
		result = prime * result + count;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
//		System.out.println("called.");
		if (obj == null || obj.getClass() != getClass())
			return false;
		else {
			WordCount c = (WordCount) obj;
			return this.word.equals(c.word);
		}
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	@Override
	public String toString() {
		return this.word + "-" + this.count;
	}

}

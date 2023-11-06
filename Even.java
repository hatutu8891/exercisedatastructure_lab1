/**
 * 
 */
package lab7;

/**
 * @author hp
 *
 */
public class Even implements Predicate<Integer>{
	public boolean test(Integer i) {
		return (i % 2 == 0);
	}
}

/**
 * 
 */
package lab7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * TASK 2 : COLLECTIONS and PREDICATE
 * 
 * @author hp
 *
 */
public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (p.test(next))
				iter.remove();
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (!p.test(next))
				iter.remove();
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
		for (T obj : coll) {
			if (p.test(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;
		for (T obj : coll) {
			if (p.test(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Even p = new Even();

		// This is the testcase of remove method
		MyPredicates.remove(list, p);
		System.out.println(list);
		// This is the testcase of retain method
		MyPredicates.retain(list, p);
		System.out.println(list);

		// This is the testcase of collect method
		System.out.println(MyPredicates.collect(list, p));

		// This is the testcase of find method
		System.out.println(MyPredicates.find(list, p));
	}
}

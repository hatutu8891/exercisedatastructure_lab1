/**
 * 
 */
package lab10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * TASK 2 : QUEUE
 * @author hp
 *
 */
public class MyFIFO_App {
	// Method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front[1,2,3] back becomes front[1,1,2,2,3,3] back
	public static <E> void stutter(Queue<E> input) {
		Queue<E> temporaryQueue = new LinkedList<>();
		while (!input.isEmpty()) {
			E element = input.remove();
			temporaryQueue.add(element);
			temporaryQueue.add(element);

		}
		while (!temporaryQueue.isEmpty()) {
			input.add(temporaryQueue.remove());
		}
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front[a,b,c] back becomes front[a,b,c,c,b,a] back
	public static <E> void mirror(Queue<E> input) {
		Queue<E> temporaryQueue = new LinkedList<>();
		Stack<E> temporaryStack = new Stack<>();
		while (!input.isEmpty()) {
			E element = input.remove();
			temporaryQueue.add(element);
			temporaryStack.add(element);
		}
		while (!temporaryStack.isEmpty()) {
			temporaryQueue.add(temporaryStack.pop());
		}
		while (!temporaryQueue.isEmpty()) {
			input.add(temporaryQueue.remove());
		}

	}

	public static void main(String[] args) {
		//This is the testcase of stutter method
		Queue<Integer> queue1 = new LinkedList<>();
		queue1.add(1);
		queue1.add(2);
		queue1.add(3);
		stutter(queue1);
		System.out.println(queue1);

		Queue<Character> queue2 = new LinkedList<>();
		queue2.add('a');
		queue2.add('b');
		queue2.add('c');
		stutter(queue2);
		System.out.println(queue2);

		Queue<String> queue3 = new LinkedList<>();
		queue3.add("Hung");
		queue3.add("Hai");
		queue3.add("Ha");
		stutter(queue3);
		System.out.println(queue3);

		//This is the testcase of mirror method
		Queue<Integer> queue4 = new LinkedList<>();
		queue4.add(1);
		queue4.add(2);
		queue4.add(3);
		mirror(queue4);
		System.out.println(queue4);

		Queue<Character> queue5 = new LinkedList<>();
		queue5.add('a');
		queue5.add('b');
		queue5.add('c');
		mirror(queue5);
		System.out.println(queue5);

		Queue<String> queue6 = new LinkedList<>();
		queue6.add("Hung");
		queue6.add("Hai");
		queue6.add("Ha");
		mirror(queue6);
		System.out.println(queue6);
	}
}

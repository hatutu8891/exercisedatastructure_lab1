/**
 * 
 */
package lab10;

import java.util.Arrays;
import java.util.Stack;

/**
 * TASK 1 : STACK
 * @author hp
 *
 */
public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> result = new Stack<>();
		for (int i = 0; i < array.length; i++) {
			result.push(array[i]);

		}
		for (int i = 0; i < array.length; i++) {
			array[i] = result.pop();
		}

	}

	// This method checks the correctness of the given input
	// i.e. () (())[]{(())} ==> true, ){[]}() ==> false.
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char specialChar = input.charAt(i);
			switch (specialChar) {
			case '(':
			case '[':
			case '{':
				stack.push(specialChar);
				break;
			case ' ':
				break;
			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 * (3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		String outExpression = expression.replaceAll(" ", "");
		for (int i = 0; i < outExpression.length(); i++) {
			char ch = outExpression.charAt(i);
			if (Character.isDigit(ch)) {
				operandStack.add(Character.getNumericValue(ch));
			} else if (ch == ' ') {
				operandStack.add((int) ch);
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				operatorStack.add(ch);
				operandStack.add((int) ' ');
			} else if (ch == '(') {
				operatorStack.add(ch);
			} else if (ch == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					
					int operand2 = operandStack.pop();
					int operand1 =0;
					int i1=0;
					if(operandStack.peek()==' ') {
						operandStack.pop();
						do {
						operand1+=(operandStack.pop()*Math.pow(10, i1));
						i1++;
						}while(operandStack.peek()!=' ');
					}
					char operator = operatorStack.pop();
					int result = performOperation(operand1, operand2, operator);
					operandStack.add(result);
				}
				if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
					operatorStack.pop();
				}
			}
		}
		while (!operatorStack.isEmpty()) {
			int operand2 = operandStack.pop();
			int operand1 = operandStack.pop();
			char operator = operatorStack.pop();
			int result = performOperation(operand1, operand2, operator);
			operandStack.add(result);
		}
		return operandStack.pop();
	}

	private static int performOperation(int operand1, int operand2, char operator) {
		if (operator == '+') {
			return operand1 + operand2;
		} else if (operator == '-') {
			return operand1 - operand2;
		} else if (operator == '*') {
			return operand1 * operand2;
		} else if (operator == '/') {
			return operand1 / operand2;
		}
		return 0;

	}

	public static void main(String[] args) {
		Integer[] array1 = { 1, 2, 3 };
		
		//This is the testcase of reserve method
		reserve(array1);
		System.out.println(Arrays.toString(array1));

		
		//This is the testcase of isCorrect method
		String character = "() (())[]{(())}";
		System.out.println(isCorrect(character));
		String character1 = "){[]}()";
		System.out.println(isCorrect(character1));
		String character2 = "() (()[]{(())}";
		System.out.println(isCorrect(character2));

		//This is the testcase of evaluateExpression method
		String st1 = "51 + (54 * (3+2))";
		System.out.println(evaluateExpression(st1));
	}
}

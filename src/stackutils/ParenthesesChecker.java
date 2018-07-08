package stackutils;

import datastructures.Stack;
import datastructures.StackAL;

public class ParenthesesChecker {
	/**
	 * Uses a Split String and a Stack to check if parentheses match
	 * 
	 * @param input
	 *            A string containing parentheses of types () [] {}
	 * @return True if each open parentheses is matched by a closing parentheses
	 */
	public static boolean checkParentheses(String input) {
		String[] paren = input.split(" "); // split the string by space
		Stack<String> newStack = new StackAL<>();

		// loop through all the string that is inside string array paren
		for (String i : paren) {
			// if the string inside is one of the openings, push it onto the top
			// of stack
			if (i.equals("(") || i.equals("[") || i.equals("{")) {
				newStack.push(i);
			}

			// if the string inside is one of the closings
			if (i.equals(")") || i.equals("]") || i.equals("}")) {
				if (newStack.isEmpty())
					return false; // return false if the stack is empty

				String popElem = newStack.pop(); // if the stack has elements,
													// pop the one at the top

				// checking if the pop elements match the string
				if (popElem.equals("(") && !i.equals(")")) {
					return false;
				} else if (popElem.equals("[") && !i.equals("]")) {
					return false;
				} else if (popElem.equals("{") && !i.equals("}")) {
					return false;
				}

			}

		}
		// after matching, the stack should be empty
		if (!newStack.isEmpty())
			return false;
		return true;
	}

	/**
	 * Calls "checkParentheses" for each argument in "args" and prints out if
	 * they match or not
	 * @param args String
	 */
	public static void main(String args[]) {
		for (String argument : args) {
			if (checkParentheses(argument)) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}

	}
}

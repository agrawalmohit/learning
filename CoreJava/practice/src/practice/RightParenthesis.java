package practice;

import java.util.Stack;

public class RightParenthesis {
	public static void main(String[] args) {

		System.out.println(isValid("("));
		System.out.println(isValid("()"));
		System.out.println(isValid("([])"));
		System.out.println(isValid(")("));
		System.out.println(isValid("((((([{{[]}}]"));
		System.out.println(isValid("((((([{{[]}}]))))"));

		System.out.println(isValid("((((([{{[]}}])))))"));
		System.out.println(isValid("()[]{}"));
	}

	public static boolean isValid(String s) {
		Stack<Character> bracesStack = new Stack<>();
		char[] arr = s.toCharArray();
		if (arr[0] == '}' || arr[0] == ']' || arr[0] == ')') {
			return false;
		}
		for (char c : arr) {
			if (c == '{' || c == '(' || c == '[') {
				bracesStack.push(c);
			} else if (!bracesStack.isEmpty()) {
				if (getCompliment(bracesStack.pop()) != c) {
					return false;
				}
			} else if (bracesStack.isEmpty()) {
				return false;
			}
		}
		if (bracesStack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static char getCompliment(char c) {
		switch (c) {
		case '{':
			return '}';
		case '(':
			return ')';
		case '[':
			return ']';
		default:
			return '0';
		}
	}

}

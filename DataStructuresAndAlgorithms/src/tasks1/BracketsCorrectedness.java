package tasks1;

import java.util.Stack;

public class BracketsCorrectedness {

	public boolean areBalanced(char firstBracket, char secondBracket) {
		if (firstBracket == '(' && secondBracket == ')')
			return true;
		if (firstBracket == '[' && secondBracket == ']')
			return true;
		if (firstBracket == '{' && secondBracket == '}')
			return true;

		return false;
	}

	public boolean bracketCorrectedness(String expression) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') {
				stack.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')') {
				if (!areBalanced(stack.pop(), expression.charAt(i)))
					return false;
			} else if (expression.charAt(i) == '}') {
				if (!areBalanced(stack.pop(), expression.charAt(i)))
					return false;
			} else if (expression.charAt(i) == ']') {
				if (!areBalanced(stack.pop(), expression.charAt(i)))
					return false;
			}
		}

		if (!stack.isEmpty())
			return false;
		else
			return true;
	}
}

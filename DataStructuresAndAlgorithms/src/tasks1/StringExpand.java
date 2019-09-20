package tasks1;

import java.util.Stack;

public class StringExpand {

	public String expand(String str) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder strToBeExapanded = new StringBuilder("");
		int timesToCopy = 0;

		for (int i = 0; i < str.length(); i++) {
			// start pushing into stack until come to ')'
			if (str.charAt(i) != ')') {
				stack.push(str.charAt(i));
			} else {
				// to cover case like 2()
				if (stack.peek() == '(') {
					stack.pop();
					if (!stack.empty() && Character.isDigit(stack.peek())) {
						stack.pop();
					}
					continue;
					// to cover case like 2(F)
				} else {
					while (Character.isLetter(stack.peek())) {
						strToBeExapanded.append(stack.pop());
					}
					if (stack.peek() == '(') {
						stack.pop();
						if (Character.isDigit(stack.peek())) {
							timesToCopy = Character.getNumericValue(stack.pop());
						}
					}
					for (int j = 0; j < timesToCopy; j++) {
						for (int k = strToBeExapanded.length() - 1; k >= 0; k--) {
							stack.push(strToBeExapanded.charAt(k));
						}
					}
					strToBeExapanded = new StringBuilder("");
				}
			}
		}

		StringBuilder result = new StringBuilder("");
		while (!stack.empty()) {
			result.append(stack.pop());
		}

		return (result.reverse()).toString();
	}
}

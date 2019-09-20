package tasks1;

import java.util.Stack;

public class InfixExpression_FullyParenthesized {

	// private Stack<Character> stackToKeepElements = new Stack<Character>();

	public int transformFromStringToInteger(String expression, int counterDigits, int startIndex) {
		int result = 0;
		int j = 0;

		for (int i = counterDigits + startIndex - 1; i >= startIndex; i--) {
			result += Character.getNumericValue(expression.charAt(i)) * Math.pow(10, j);
			j++;
		}
		return result;
	}

	public int evaluateExpression(String expression) {
		Stack<Character> characterStack = new Stack<Character>();
		Stack<Integer> integerStack = new Stack<Integer>();
		int counterDigits = 0;

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				characterStack.push(expression.charAt(i));
			}
			int current_i = i;
			while (Character.isDigit(expression.charAt(i))) {
				counterDigits++;
				i++;
				// integerStack.push(Character.getNumericValue(expression.charAt(i)));
			}
			if (Character.isDigit(expression.charAt(i - 1))) {
				integerStack.push(transformFromStringToInteger(expression, counterDigits, current_i));
			}
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
					|| expression.charAt(i) == '/') {
				characterStack.push(expression.charAt(i));
			}
			if (expression.charAt(i) == ')') {
				while (characterStack.peek() == '(' || characterStack.peek() == ')') {
					System.out.println("element to pop: " + characterStack.pop());
				}
				System.out.println("Stack " + characterStack);
				System.out.println("Stack " + integerStack);

				int secondOperand = integerStack.pop();
				System.out.println("second operand: " + secondOperand);

				char operation = characterStack.pop();
				System.out.println("operation: " + operation);

				int firstOperand = integerStack.pop();
				System.out.println("first operand: " + firstOperand);

				int result = evaluation(operation, firstOperand, secondOperand);
				integerStack.push(result);
				System.out.println("result to push: " + result);
				System.out.println("Stack " + characterStack);
				System.out.println("Stack " + integerStack);
			}

			// System.out.println("new element: " + stackToKeepElements.pop());
		}
		return integerStack.pop();
	}

	public int evaluation(char operation, int firstOperand, int secondOperand) {

		switch (operation) {
		case '+':
			return firstOperand + secondOperand;
		case '-':
			return firstOperand - secondOperand;
		case '*':
			return firstOperand * secondOperand;
		case '/':
			if (secondOperand != 0) {
				return firstOperand / secondOperand;
			}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixExpression_FullyParenthesized obj = new InfixExpression_FullyParenthesized();
		// String expression = "(((2*5)-(1*2))/(9-7))";
		String expression = "((2*5)-1)";
		System.out.println(obj.evaluateExpression(expression));
	}

}

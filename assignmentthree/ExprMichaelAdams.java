package assignmentthree;
// Class:			Data Structures W01

// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.64.2

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;

public class ExprMichaelAdams {

	public static void main(String[] args) {
		String wantToContinue = "Y";
		while ("Y".equals(wantToContinue)) {
			Scanner input = new Scanner(System.in);
			// - User will insert infix
			System.out.println("Enter an infix:");
			String infix = input.nextLine();

			// - Invoke infixToPostfix to transform it to postfix expression
			String postfix = infixToPostfix(infix);

			// - Invoke postfixEval to evaluate postfix expression
			double postfixEvaluation = postfixEval(postfix);

			// - Show the calculated result
			System.out.println("Postfix Expression:\t\t" + postfix);
			System.out.println("Result value:\t\t" + postfixEvaluation);

			// Allow the user re-run the program
			System.out.println("Do you want to continue? (Y/N)");
			wantToContinue = input.nextLine();
			input.close();
		}

	}

	public static int precedence(char text) {
		if (text == '+' || text == '-') {
			return 1;
		} else if (text == '*' || text == '/') {
			return 2;
		} else if (text == '^') {
			return 3;
		}
		return -1;
	}

	public static String infixToPostfix(String infix) {
		String result = "";
		int size = infix.length();
		MyStackMichaelAdams stack = new MyStackMichaelAdams();
		stack.S = new Character[infix.length()];
		stack.size = 0;
		stack.MAX_SIZE = size;
		for (int i = 0; i < size; i++) {
			if ((infix.charAt(i) >= '0' && infix.charAt(i) <= '9') || (infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z')
					|| (infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z')) {
				result = result + infix.charAt(i);
			} else {
				if (stack.isEmpty() || infix.charAt(i) == '(') {
					// Base case
					// When getting a open parenthesis
					// Or stack is empty
					stack.push(infix.charAt(i));
				} else if (infix.charAt(i) == ')') {
					// Need to remove stack element until the close bracket
					while (!stack.isEmpty() && (Character) stack.peek() != '(') {
						// Get top element
						result += stack.peek();
						// Remove stack element
						stack.pop();
					}
					if ((Character) stack.peek() == '(') {
						// Remove stack element
						stack.pop();
					}
				} else {
					// Remove stack element until precedence of
					// top is greater than current infix operator
					while (!stack.isEmpty() && precedence(infix.charAt(i)) <= precedence((char) stack.peek())) {
						// Get top element
						result += stack.peek();
						// Remove stack element
						stack.pop();
					}
					// Add new operator
					stack.push(infix.charAt(i));
				}
			}
		}
		// Add remaining elements
		while (!stack.isEmpty()) {
			result += stack.peek();
			stack.pop();
		}
		// Return postfix as a returned String of this method
		return result;
	}

	public static double postfixEval(String postfix) {
		MyStackMichaelAdams<Integer> stack = new MyStackMichaelAdams<>(); // Create postfix stack
		int n = postfix.length();

		for (int i = 0; i < n; i++) {
			if (postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*'
					|| postfix.charAt(i) == '/' || postfix.charAt(i) == '^') {
				// pop top 2 operands.
				int op1 = stack.pop();
				int op2 = stack.pop();

				// evaluate in reverse order i.e. op2 operator op1.
				switch (postfix.charAt(i)) {
					case '+':
						stack.push(op2 + op1);
						break;
					case '-':
						stack.push(op2 - op1);
						break;
					case '*':
						stack.push(op2 * op1);
						break;
					case '/':
						stack.push(op2 / op1);
						break;
				}
			}
			// Current Char is Operand simple push into stack
			else {
				// convert to integer
				int operand = postfix.charAt(i) - '0';
				stack.push(operand);
			}
		}

		// Stack at End will contain result.
		return (stack.pop());
	}
}

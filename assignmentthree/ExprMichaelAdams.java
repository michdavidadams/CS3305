package assignmentthree;
// Class:			Data Structures W01

// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.64.2

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

			// - Show the calculated result
			System.out.println("Postfix Expression:\t\t" + postfix);

			// Allow the user re-run the program
			System.out.println("Do you want to continue? (Y/N)");
			wantToContinue = input.nextLine();
			input.close();
		}
	}

	// For finding the order of operations. Higher number means higher precedence
	static int orderOfOperations(char operator) {
		// the bigger the number, the higher the orderOfOperations
		if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		} else {
			return 0;
		}
	}

	// Converts infix to postfix
	public static String infixToPostfix(String infix) {
		// Stack to hold operators
		MyStackMichaelAdams<Character> operators = new MyStackMichaelAdams<Character>();
		// Stack to hold postfix
		MyStackMichaelAdams<Object> postfix = new MyStackMichaelAdams<Object>();

		int numberBuffer = 0;
		boolean bufferingOperand = false;
		// for each character in infix string, as a char array
		for (char infixCharacter : infix.toCharArray()) {
			// if character is greater than 0 and less than 9 (if character is a number)
			if (infixCharacter >= '0' && infixCharacter <= '9') {
				//
				numberBuffer = numberBuffer * 10 + infixCharacter - '0';
				bufferingOperand = true;
			} else {
				if (bufferingOperand) {
					postfix.push(numberBuffer);
				}
				numberBuffer = 0;
				bufferingOperand = false;

				if (infixCharacter == '(') {
					operators.push('(');
				} else if (infixCharacter == ')') {
					while (operators.peek() != '(')
						postfix.push(operators.pop());
					operators.pop(); // popping "("
				} else { // operator
					while (!operators.isEmpty()
							&& orderOfOperations(infixCharacter) <= orderOfOperations(operators.peek()))
						postfix.push(operators.pop());
					operators.push(infixCharacter);
				}
			}
		}

		if (bufferingOperand)
			postfix.push(numberBuffer);
		// While operator stack is not empty, pop and then push to postfix stack
		while (!operators.isEmpty())
			postfix.push(operators.pop());

		// Returns postfix stack as string
		return postfix.toString();
	}

	public static double postfixEval(String postfix) {
		MyStackMichaelAdams<Integer> stack = new MyStackMichaelAdams<>(); // Create postfix stack
		int n = postfix.length();

		for (int i = 0; i < n; i++) {
			System.out.println(stack);
			if (postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*'
					|| postfix.charAt(i) == '/' || postfix.charAt(i) == '^') {
				// pop the top 2 operands
				int operator1 = stack.pop();
				int operator2 = stack.pop();

				// evaluates in reverse order, operator2 before operator
				switch (postfix.charAt(i)) {
					case '+':
						stack.push(operator2 + operator1);
						break;
					case '-':
						stack.push(operator2 - operator1);
						break;
					case '*':
						stack.push(operator2 * operator1);
						break;
					case '/':
						stack.push(operator2 / operator1);
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

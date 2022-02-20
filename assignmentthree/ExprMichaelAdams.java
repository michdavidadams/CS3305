package assignmentthree;
// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.64.2

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class ExprMichaelAdams {
    
    public static int precedence(char text) {
		if (text == '+' || text == '-') {
			return 1;
		}
		else if (text == '*' || text == '/') {
			return 2;
		}
		else if (text == '^') {
			return 3;
		}
		return -1;
	}

	public boolean is_operator(char text) {
		if (text == '+' || text == '-' || text == '*' || text == '/' || text == '^') {
			return true;
		}
		return false;
	}

    public static String infixToPostfix(String infix) {
        String result = "";
        int size = infix.length();
        MyStackMichaelAdams stack = new MyStackMichaelAdams();
        for (int i = 0; i < size; i++) {
            if ((infix.charAt(i) >= '0' && infix.charAt(i) <= '9') || (infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z') || (infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z')) {
                result = result + infix.charAt(i);
            } else {
                if (stack.isEmpty() || infix.charAt(i) == '(')
				{
					// Base case
					// When getting a open parenthesis
					// Or stack is empty
					stack.push(infix.charAt(i));
				} else if (infix.charAt(i) == ')') {
					// Need to remove stack element until the close bracket
					while (stack.isEmpty() == false && (Character) stack.peek() != '(')
					{
						// Get top element
						result += stack.peek();
						// Remove stack element
						stack.pop();
					}
                    if ((Character) stack.peek() == '(')
					{
						// Remove stack element
						stack.pop();
					}
				}
                else {
					// Remove stack element until precedence of 
					// top is greater than current infix operator
					while (stack.isEmpty() == false && precedence(infix.charAt(i)) <= precedence((char) stack.peek())) {
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
    
}

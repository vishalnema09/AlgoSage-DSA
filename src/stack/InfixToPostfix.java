package stack;

import java.util.Stack;

public class InfixToPostfix {
    static int precedence(char ch) {
        switch (ch) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':  // Exponent has highest precedence
                return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String s) {
        // Your code here
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}

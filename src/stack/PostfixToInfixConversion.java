package stack;

import java.util.Stack;

public class PostfixToInfixConversion {
    static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String newExpr = "(" + operand1 + c + operand2 + ")";
                stack.push(newExpr);
            }
        }
        return stack.peek();
    }
}

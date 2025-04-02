package stack;

import java.util.Stack;

public class PostfixToPrefixConversion {
    static String postToPre(String post_exp) {
        Stack<String> stack = new Stack<>();

        for (char c : post_exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String newExpr = c + operand1 + operand2;
                stack.push(newExpr);
            }
        }
        return stack.peek();
    }
}

package stack;

import java.util.Stack;

public class PrefixToPostfixConversion {
    static String preToPost(String pre_exp) {
        Stack<String> stack = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char c = pre_exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String newExpr = operand1 + operand2 + c;
                stack.push(newExpr);
            }
        }
        return stack.peek();
    }
}

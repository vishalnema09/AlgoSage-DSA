package stack;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanner {
    Stack<Integer> stack;
    ArrayList<Integer> list;
    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        int index = list.size();
        list.add(price);

        while(!stack.isEmpty() && list.get(stack.peek()) <= price){
            stack.pop();
        }

        int span = stack.isEmpty() ? index+1 : index-stack.peek();
        stack.push(index);
        return span;
    }
}

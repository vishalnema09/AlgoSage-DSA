package stack;

public class StackUsingLinkedList {
    class MyStack {
         class StackNode {
             int data;
             StackNode next;
             StackNode(int a) {
                 data = a;
                 next = null;
             }
         }
        StackNode top;

        void push(int a) {
            StackNode newNode = new StackNode(a);
            newNode.next = top;
            top = newNode;
        }

        int pop() {
            if (top == null) return -1;
            int poppedData = top.data;
            top = top.next;
            return poppedData;
        }
    }
}

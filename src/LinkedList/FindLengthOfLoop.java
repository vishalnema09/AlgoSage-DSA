package LinkedList;

public class FindLengthOfLoop {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                int count = 1;
                fast = fast.next;
                while(slow != fast) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }
}

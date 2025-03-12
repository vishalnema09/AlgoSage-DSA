package LinkedList;

public class ReverseDoublyLinkedList {

    class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }
    public DLLNode reverseDLL(DLLNode head) {
        if(head == null || head.next == null) return head;
        DLLNode curr = head;
        DLLNode temp = null;
        while(curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        return temp.prev;
    }
}

package LinkedList;

public class ReverseLinkedListByUsingRecursion {

    public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return res;
    }
}

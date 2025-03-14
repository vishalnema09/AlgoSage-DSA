package LinkedList;

import java.util.Stack;

public class PalindromeLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode cur = head;
        while(cur!=null){
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(cur!=null && cur.val==stack.pop()){
            cur = cur.next;
        }
        return cur==null;
    }
}

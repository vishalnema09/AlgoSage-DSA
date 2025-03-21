package LinkedList;

public class AddTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        while(l1 !=null || l2 !=null || carry !=0){
            int sum = carry;
            if(l1!=null){
                sum+=l1.val;
                l1= l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2= l2.next;
            }
            carry = sum /10;
            current.next= new ListNode(sum % 10);
            current = current.next;
        }
        return dummyHead.next;
    }
}

package LinkedList;


class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}
public class ArrayToLinkedList {
    static Node constructLL(int arr[]) {
        int i = 1;
        if(arr.length == 1){
            new Node(arr[0]);
        }
        Node head = new Node(arr[0]);
        Node temp = head;
        while(i < arr.length) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
            i++;
        }
        return head;
    }
}

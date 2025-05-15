package BinarySearchTrees;

public class MaxAndMinElementBinaryTree {
    public static int findMax(Node root) {
        if(root == null) return -1;
        Node curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }

    public static int findMin(Node root) {
        if(root == null) return -1;
        Node curr = root;
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }
}

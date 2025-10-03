package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        leftSideView(root, ans, 0);
        return ans;
    }
    public void leftSideView(Node curr, List<Integer> ans , int depth){
        if(curr == null){
            return;
        }
        if(depth == ans.size()){
            ans.add(curr.data);
        }
        leftSideView(curr.left, ans, depth +1);
        leftSideView(curr.right, ans, depth+1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.right.right.left = new Node(70);

        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
        ArrayList<Integer> result = tree.leftView(root);

        System.out.println("Left View of Binary Tree: " + result);
    }
}

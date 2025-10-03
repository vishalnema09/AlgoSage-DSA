package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public void preOrder(TreeNode root, List<Integer> list){
        if(root == null)
            return ;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTreePreorderTraversal obj = new BinaryTreePreorderTraversal();
        List<Integer> result = obj.preorderTraversal(root);

        System.out.println("Preorder Traversal: " + result);
    }
}
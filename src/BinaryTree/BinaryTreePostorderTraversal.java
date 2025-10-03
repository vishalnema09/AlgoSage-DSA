package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public void postOrder(TreeNode root, ArrayList<Integer>list){
        if(root == null)return;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer>list = new ArrayList<>();
        postOrder(root,list);
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

        BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();
        List<Integer> result = obj.postorderTraversal(root);

        System.out.println("Postorder Traversal: " + result);
    }
}

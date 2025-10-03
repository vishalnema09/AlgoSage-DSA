package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightview(root, ans, 0);
        return ans;
    }
    public void rightview(TreeNode curr, List<Integer> ans , int depth){
        if(curr == null){
            return;
        }
        if(depth == ans.size()){
            ans.add(curr.val);
        }
        rightview(curr.right, ans, depth+1);
        rightview(curr.left, ans, depth +1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        root.right.right.left = new TreeNode(70);

        BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
        List<Integer> result = tree.rightSideView(root);

        System.out.println("Right View of Binary Tree: " + result);
    }
}

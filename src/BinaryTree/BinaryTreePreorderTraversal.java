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
}

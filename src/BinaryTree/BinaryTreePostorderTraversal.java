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
}

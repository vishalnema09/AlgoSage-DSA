package BinaryTree;
import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        backtrack(root, ans, "");
        return ans;
    }
    private void backtrack(TreeNode root, List<String> ans, String curr) {
        if(root.left == null && root.right == null) {
            ans.add(curr+root.val);
        }
        if(root.left != null) {
            backtrack(root.left, ans, curr+root.val+"->");
        }
        if(root.right != null) {
            backtrack(root.right, ans, curr+root.val+"->");
        }
    }
}

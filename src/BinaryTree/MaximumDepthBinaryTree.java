package BinaryTree;

public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        MaximumDepthBinaryTree obj = new MaximumDepthBinaryTree();
        int depth = obj.maxDepth(root);

        System.out.println("Maximum Depth of the Binary Tree: " + depth);
    }
}

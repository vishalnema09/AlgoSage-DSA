package BinaryTree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null)
            return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1,
                        new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                        new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7))
        );

        BalancedBinaryTree obj = new BalancedBinaryTree();
        System.out.println("Is the tree balanced? " + obj.isBalanced(root1));
    }
}

package BinaryTree;
import java.util.*;

public class MaximumWidthBinaryTree {
    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            int minIndex = queue.peek().index;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++){
                Pair current = queue.poll();
                int currIndex = current.index - minIndex;
                TreeNode node = current.node;

                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;

                if (node.left != null)
                    queue.offer(new Pair(node.left, 2 * currIndex));
                if (node.right != null)
                    queue.offer(new Pair(node.right, 2 * currIndex + 1));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        MaximumWidthBinaryTree tree = new MaximumWidthBinaryTree();
        int maxWidth = tree.widthOfBinaryTree(root);

        System.out.println("Maximum Width of Binary Tree: " + maxWidth);
    }
}

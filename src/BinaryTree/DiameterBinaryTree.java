package BinaryTree;

public class DiameterBinaryTree {
    int ans = 0;
    public int hd(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = hd(root.left);
        int rh = hd(root.right);
        ans = Math.max(ans, (lh+rh));
        return Math.max(lh, rh)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int h = hd(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterBinaryTree tree = new DiameterBinaryTree();
        System.out.println("Diameter of Binary Tree: " + tree.diameterOfBinaryTree(root));
    }
}

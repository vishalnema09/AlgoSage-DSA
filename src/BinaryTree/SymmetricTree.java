package BinaryTree;

public class SymmetricTree {
    public boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val == q.val){
            return isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree tree = new SymmetricTree();
        System.out.println("Is tree symmetric? " + tree.isSymmetric(root));
    }
}

package BinaryTree;

public class ChildrenSumBinaryTree {
    static boolean flag = true;
    public static int dfs(Node root){
        if(root == null)return 0;
        if(root.left ==null && root.right == null)return root.data;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(root.data != left+right){
            flag = false;
        }
        return root.data;
    }

    public static int isSumProperty(Node root) {
        flag = true;
        dfs(root);
        return flag?1:0;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);

        int result = isSumProperty(root);
        System.out.println("Does tree follow Children Sum Property? " + (result == 1 ? "Yes" : "No"));
    }
}

package BinaryTree;
import java.util.*;
public class BottomViewOfBinaryTree {
    static class Info{
        Node node;
        int hd;
        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        int min = 0; int max = 0;
        q.add(new Info(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Info curr = q.remove();
                map.put(curr.hd, curr.node);
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for(int i = min; i <= max;i++){
            ans.add(map.get(i).data);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        ArrayList<Integer> result = bottomView(root);
        System.out.println("Bottom View of Binary Tree: " + result);
    }
}

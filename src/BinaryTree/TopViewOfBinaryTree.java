package BinaryTree;
import java.util.*;
public class TopViewOfBinaryTree {
    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        int min = 0, max = 0;
        q.add(new Info(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                Info curr = q.remove();
                if (!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for(int i = min; i <= max;i++){
            ans.add(map.get(i).data);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> result = topView(root);
        System.out.println("Top View of Binary Tree: " + result);
    }
}

package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        leftSideView(root, ans, 0);
        return ans;
    }
    public void leftSideView(Node curr, List<Integer> ans , int depth){
        if(curr == null){
            return;
        }
        if(depth == ans.size()){
            ans.add(curr.data);
        }
        leftSideView(curr.left, ans, depth +1);
        leftSideView(curr.right, ans, depth+1);
    }
}

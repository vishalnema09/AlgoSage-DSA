package BinarySearchTrees;

import java.util.ArrayList;

public class PredecessorAndSuccessor {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node predecessor = null, successor = null;
        Node curr = root;

        while (curr != null) {
            if (curr.data == key) break;

            if (key < curr.data) {
                successor = curr;
                curr = curr.left;
            } else {
                predecessor = curr;
                curr = curr.right;
            }
        }

        if (curr != null) {
            Node temp = curr.left;
            while (temp != null) {
                predecessor = temp;
                temp = temp.right;
            }

            temp = curr.right;
            while (temp != null) {
                successor = temp;
                temp = temp.left;
            }
        }

        ArrayList<Node> ans = new ArrayList<>();
        ans.add(predecessor);
        ans.add(successor);
        return ans;
    }
}

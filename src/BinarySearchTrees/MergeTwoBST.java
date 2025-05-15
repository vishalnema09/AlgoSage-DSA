package BinarySearchTrees;

import java.util.ArrayList;

public class MergeTwoBST {
    public ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }

        while (i < list1.size()) result.add(list1.get(i++));
        while (j < list2.size()) result.add(list2.get(j++));

        return result;

    }

    private void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}

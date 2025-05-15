package BinarySearchTrees;

public class FloorInBST {
    int floor(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            }

            if (root.data < key) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}

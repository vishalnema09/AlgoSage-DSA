package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        int rightMax = arr[n - 1]; // Rightmost element is always a leader

        // Pehle rightmost element ko add kar lo
        res.add(rightMax);

        // Reverse traversal from second-last element to first
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= rightMax) {
                rightMax = arr[i];  // Update rightMax
                res.add(rightMax);
            }
        }
        Collections.reverse(res);

        return res;
    }
}

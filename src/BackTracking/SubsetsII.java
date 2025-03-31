package BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
    class Solution {
        public void generateSubsets(int arr[], int i, List<Integer> curr, HashSet<List<Integer>> set) {
            if (i == arr.length) {
                set.add(new ArrayList<>(curr));
                return;
            }
            curr.add(arr[i]);
            generateSubsets(arr, i + 1, curr, set);

            curr.remove(curr.size() - 1);
            generateSubsets(arr, i + 1, curr, set);
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            HashSet<List<Integer>> set = new HashSet<>();
            generateSubsets(nums, 0, new ArrayList<>(), set);
            return new ArrayList<>(set);
        }
    }
}

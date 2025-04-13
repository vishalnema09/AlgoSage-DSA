package stack;

import java.util.Stack;

public class SumSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long maxSum = 0, minSum = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long count = (mid - left) * (right - mid);
                maxSum += count * nums[mid];
            }
            st.push(i);
        }

        st.clear();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long count = (mid - left) * (right - mid);
                minSum += count * nums[mid];
            }
            st.push(i);
        }
        return maxSum - minSum;
    }
}

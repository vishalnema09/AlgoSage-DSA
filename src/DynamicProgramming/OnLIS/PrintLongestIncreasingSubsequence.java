package DynamicProgramming.OnLIS;

import java.util.ArrayList;
import java.util.Collections;

public class PrintLongestIncreasingSubsequence {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = i;
        }

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();
        while (prev[lastIndex] != lastIndex) {
            lis.add(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        lis.add(arr[lastIndex]);

        Collections.reverse(lis);
        return lis;
    }
}

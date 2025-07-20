package DynamicProgramming.MatrixChainMultiplicationAndPartition;

import java.util.Arrays;

public class MatrixChainMultiplicationMemo {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int [][]dp= new int [n][n];
        for(int []row : dp ){
            Arrays.fill(row, -1);
        }
        return solve(1,n-1, arr, dp);
    }
    static int solve(int i , int j , int []arr, int[][]dp){
        if(i == j )return 0;
        if(dp[i][j]!= -1)return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] +
                    solve(i, k, arr, dp) +
                    solve(k + 1, j, arr, dp);
            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }
}

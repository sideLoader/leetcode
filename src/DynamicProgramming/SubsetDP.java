package DynamicProgramming;

import java.util.Arrays;

public class SubsetDP {

    static boolean isSubset(int input[], int n, int sum) {
        if(sum == 0) return  true;
        if(n == 0 && sum != 0) return false;
        if(input[n -1] > sum) isSubset(input, n -1, sum);

        return isSubset(input, n -1, sum) ||
                isSubset(input, n -1, sum - input[n -1]);
    }

    static boolean isSubsetDP(int input[], int n, int sum) {
        boolean dp[][] = new boolean[sum +1][n +1];

        for(int i = 0; i <= n; i++) dp[0][i] = true;
        for(int i = 0; i <= sum; i++) dp[i][0] = false;

        for(int i = 1; i <= sum; i++)
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j -1];
                if(i > input[j -1])
                    dp[i][j] = dp[i][j -1] || dp[i - input[j -1]][j -1];
            }

        return dp[sum][n];
    }

    public static void main(String args[]) {
        int input[] = new int[] {5,4,9,10,3};

        System.out.println(isSubsetDP(input, input.length, 17));

    }
}

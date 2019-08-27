package DynamicProgramming;

import java.util.Arrays;

public class MaxCostPath
{

    public static void main(String args[]) {
        int path[][] = new int[][]{
                {1, 2, 3},
                {6, 5, 4},
                {7, 3, 9}};

        int dp[][] = new int[4][4];

        for (int i = 1; i < 4; i++) {
            for(int j = 1; j < 4; j++)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + path[i - 1][j - 1];
        }

        System.out.println(dp[3][3] / 5.0);
    }
}
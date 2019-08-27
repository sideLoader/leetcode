package DynamicProgramming;

import java.util.Arrays;

public class NumberOfWaysMaze {

    static int getNumWays(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for(int j = 0; j < n; j++) dp[0][j] = 1;

        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i -1][j] + dp[i][j -1];
            }
            
        return dp[m -1][n -1];

    }

    static int getNumWaysWithObstruction(int m, int n, int obstruction[][]) {
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++)
            if(obstruction[i][0] == -1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }

        for(int j = 0; j < n; j++)
            if(obstruction[0][j] == -1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstruction[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i -1][j] + dp[i][j -1];
                }
            }
        }


        return dp[m -1][n -1];
    }

    public static void main(String[] args) {
        int obstruction[][] = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        System.out.println(getNumWays(3,3));
        System.out.println(getNumWaysWithObstruction(3,3, obstruction));
    }
}

package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by vdep on 28/4/18.
 */
public class RodCutting {

    public static void main(String args[]) {
        int cost[] = new int[]{2,5,7,8};
        int rodLength = 5;

        int dp[][] = new int[cost.length +1][rodLength +1];

        for(int i = 0; i < cost.length; i++) dp[i][0] = 0;
        for(int i = 0; i < rodLength; i++) dp[0][i] = 0;

        for(int i = 1; i <= cost.length; i++)
            for (int j = 1; j <= rodLength; j++) {
                dp[i][j] = (j >= i) ?
                        Math.max(dp[i - 1][j], dp[i -1][j - i] + cost[i - 1]) :
                        dp[i - 1][j];
            }

         for(int i = 0; i <= cost.length; i++) {
             for(int j = 0; j <= rodLength; j++) {
                 System.out.print(dp[i][j] + " ");
             }
             System.out.println();
         }
        System.out.println(dp[cost.length][rodLength]);
    }
}

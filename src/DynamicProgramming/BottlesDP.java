package DynamicProgramming;

import java.util.Arrays;

public class BottlesDP {
    static int cost[];
    static int dp[][];

    int computeCost(int year, int start, int end) {
        if(start > end) return 0;
        else {
            return Math.max(
                    computeCost(year + 1, start + 1, end) + (year * cost[start]),
                    computeCost(year + 1, start, end -1) + (year * cost[end])
            );
        }
    }

    int computeCostDP(int year, int start, int end) {
        if(start > end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        else {
            return  dp[start][end] = Math.max(
              computeCostDP(year +1, start + 1, end) + (year * cost[start]),
                    computeCostDP(year +1, start, end -1) + (year * cost[end])
            );
        }

    }
    public static void main(String args[]) {
        cost = new int[]{2,3,5,1,4};
        dp = new int[cost.length][cost.length];
        Arrays.fill(dp, -1);

        System.out.println(
                new BottlesDP().computeCostDP(1, 0, cost.length -1));

        for(int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost.length; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }
}

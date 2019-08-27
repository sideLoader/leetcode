package DynamicProgramming;

/**
 * Created by vdep on 29/4/18.
 */
public class Knapsack01 {

    static int knapsack(int w, int wt[], int value[], int size) {
        if(size == 0 || w == 0) return 0;

        if(wt[size -1] > w)
            return knapsack(w, wt, value, size -1);

        return Math.max(
                knapsack(w, wt, value, size -1),
                knapsack(w - wt[size -1], wt, value, size -1) + value[size -1]
            );
    }

    static int knapsackDP(int w, int wt[], int value[], int size) {
        int dp[][] = new int[value.length +1][w +1];

        for(int i = 0; i <= value.length; i++)
            dp[i][0] = 0;

        for(int i = 0; i <= w; i++)
            dp[0][i] = 0;

        for(int i = 1; i <= value.length; i++)
            for(int j = 1; j <= w; j++) {
                dp[i][j] = (j >= wt[i -1]) ?
                        Math.max(
                                dp[i -1][j],
                                dp[i -1][j - wt[i -1]] + value[i -1]
                        ) : dp[i -1][j];
            }

        return dp[size][w];
    }
    public static void main(String args[]) {
        int value[] = {60,100,120};
        int wt[] = {10,20,30};
        int w = 50;

        System.out.println(knapsackDP(w, wt, value, value.length));
    }
}

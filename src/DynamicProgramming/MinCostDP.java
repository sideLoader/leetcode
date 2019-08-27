package DynamicProgramming;

public class MinCostDP {

    public int minCost(int path[][], int i, int j) {
        if(i < 0 || j < 0 || i > 2 || j > 2) return Integer.MAX_VALUE;
        else if(i == 2 && j == 2)
            return path[i][j];
        else {
            return path[i][j] + Integer.min(
                    Integer.min(
                            minCost(path, i +1, j),
                            minCost(path, i, j + 1)),
                    minCost(path, i +1, j +1));
        }
    }

    public int minCostDP(int path[][]) {
        int dp[][] = new int[3][3];
        dp[0][0] = path[0][0];

        for(int i = 1; i < 3; i++)
            dp[0][i] = path[0][i] + dp[0][i -1];

        for(int i = 1; i < 3; i++)
            dp[i][0] = path[i][0] + dp[i -1][0];

        for(int i = 1; i < 3; i++)
            for(int j = 1; j < 3; j++)
                dp[i][j] = path[i][j] + Integer.min(
                        Integer.min(dp[i -1][j -1],
                                    dp[i -1][j]),
                                dp[i][j -1]);

        return dp[2][2];

    }

    public static void main(String args[]) {
        int path[][] = new int[][] {
                {1,2,3},
                {4,8,2},
                {1,5,3}};

        System.out.println(new MinCostDP().minCostDP(path));
    }
}

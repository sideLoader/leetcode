package DynamicProgramming;

import java.util.Arrays;

public class LcsDP {

    public static int lcs(char X[], char Y[], int i, int j) {
        if(i == X.length || i == Y.length || X[i] != Y[j])
            return 0;
        else return 1 + lcs(X, Y, i +1, j +1);
    }

    public static int lcsDP(char X[], char Y[]) {
        int m = X.length;
        int n = Y.length;
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++) dp[i][0] = 0;
        for(int j = 0; j < n; j++) dp[0][j] = 0;

        int max = -1;
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++) {
                if(X[i -1] == Y[j -1])
                    dp[i][j] = dp[i -1][j -1] + 1;
                else
                    dp[i][j] = 0;

                if(dp[i][j] > max) max = dp[i][j];
            }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return max;
    }
    public static void main(String args[]) {
        String X = "dynadfprogr";
        String Y = "dynamiprogramming";

        int A[] = new int[]{2,3,5,6,6};
        final int[] y = {0};



        //System.out.println(lcsDP(X.toCharArray(), Y.toCharArray()));
        //System.out.println(lcs(X.toCharArray(), Y.toCharArray(), 0, 0));
    }
}

package DynamicProgramming;

import java.util.Arrays;

public class WildcardMatching {

    private static boolean isMatching(String str, String pattern) {
        if(pattern.isEmpty()) return str.isEmpty();

        int m = str.length();
        int n = pattern.length();
        boolean dp[][] = new boolean[m +1][n +1];
        //Arrays.fill(dp, "false");

        for(int i = 0; i < m +1; i++)
            dp[i][0] = false;

        dp[0][0] = true;

        for(int j = 1; j < n +1; j++)
            dp[0][j] = (pattern.charAt(j -1) == '*') ? dp[0][j -1] : false;

        for(int i = 1; i < m +1; i++) {
            for(int j = 1; j < n +1; j++) {
                if(pattern.charAt(j -1) == '?' ||
                        str.charAt(i -1) == pattern.charAt(j -1)) {
                    dp[i][j] = dp[i -1][j -1];
                } else if(pattern.charAt(j -1) == '*') {
                    dp[i][j] = dp[i -1][j] || dp[i][j -1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        String pattern = "*f?g?io";
        String str = "fufiguio";

        System.out.println(isMatching(str, pattern));
    }
}

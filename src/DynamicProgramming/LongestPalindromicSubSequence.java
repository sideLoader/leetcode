package DynamicProgramming;

public class LongestPalindromicSubSequence {

    private static int lps(String input) {
        if(input.isEmpty()) return 0;

        int n = input.length();
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++)
            dp[i][i] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i != j) {
                    //if()
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String input = "adbbca";
        System.out.println(lps(input));

    }
}

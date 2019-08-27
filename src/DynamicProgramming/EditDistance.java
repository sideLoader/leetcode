package DynamicProgramming;

public class EditDistance {

    static int editDistance(String source, String target) {
        int m = source.length();
        int n = target.length();

        int dp[][] = new int[m +1][n +1];

        for(int i = 0; i < m +1; i++) dp[i][0] = i;
        for(int j = 0; j < n +1; j++) dp[0][j] = j;

        for(int i = 1; i < m +1; i++)
            for(int j = 1; j < n +1; j++)
                if(source.charAt(i -1) == target.charAt(j -1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            Math.min( dp[i -1][j], dp[i][j -1]),
                            dp[i -1][j -1]
                    );
                }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String source = "horse";
        String target = "ros";

        System.out.println(editDistance(source, target));
    }
}

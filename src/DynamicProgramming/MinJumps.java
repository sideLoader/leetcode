package DynamicProgramming;

import java.util.Arrays;

public class MinJumps {

    private static int minimumJumps(int input[]) {
        if(input == null || input.length <= 1) return 0;

        int dp[] = new int[input.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < i; j++) {
                if(i <= j + input[j])
                    dp[i] = Math.min(dp[i], dp[j] +1);
            }
        }

        return dp[input.length -1];
    }

    public static void main(String[] args) {
        int input[] = {2, 3, 1, 1, 4};
        System.out.println(minimumJumps(input));
    }
}

package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaxContigousSubSequence {

    public static int maxSubSeq(int input[]) {
        int dp[] = new int[input.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return maxSubSeq(input, dp);
    }

    public static int maxSubSeq(int input[], int dp[]) {
        int max = dp[0] = input[0];

        for(int i = 1; i < input.length; i++) {
            dp[i] = Math.max(dp[i -1] + input[i], input[i]);
            System.out.println(dp[i]);
            if(dp[i] > max) max = dp[i];
        }

        return max;
    }

    
    public static void main(String[] args) {
        int input[] = new int[]{2,-6,3,-2,4,1};

        System.out.println(maxSubSeq(input));
    }
}

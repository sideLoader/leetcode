package DynamicProgramming;

import java.util.Arrays;

public class LisDP {

    private  static int lcsDP(int input[]) {
        int dp[] = new int[input.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < input.length; i++) {
            for(int j = i +1; j < input.length; j++) {
                if(input[j] > input[i])
                    dp[j] = Math.max(dp[j], dp[i] +1);
            }
        }

        return dp[input.length -1];

    }
    public static void main(String[] args) {
        int input[] = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(lcsDP(input));
    }
}

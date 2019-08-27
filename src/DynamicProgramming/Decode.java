package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Decode {

    public static int numDecode(int input[]) {
        int dp[] = new int[input.length +1];
        Arrays.fill(dp,-1);

        return numDecode(input, input.length, dp);
    }

    private static int numDecode(int input[], int index, int dp[]) {
        if(index == 0) return 1;

        int start = input.length - index;
        if(input[start] == 0) return 0;

        if(dp[index] != -1) return dp[index];

        int result = numDecode(input, index -1, dp);
        if(index >= 2 &&
            Integer.valueOf(
                    String.valueOf(input[start]) +
                      String.valueOf(input[start +1])
            ) <= 26)
            result += numDecode(input, index -2, dp);

        dp[index] = result;
        return result;
    }

    public static void main(String args[]) {
        int input[] = {0};
        System.out.println(numDecode(input));
    }
}

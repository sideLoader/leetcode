package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class NoConsecutiveNumbers {

    public static void main(String[] args) {
        int sum = 8;
        printCombinations(sum, "", '1');
        System.out.println(countCombinations(sum, '1'));

        int dp[][] = new int[sum +1][2];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
        System.out.println(countCombinationsDP(sum, 0, dp));
    }

    private static void printCombinations(int sum, String word, char prevChar) {
        if(sum == 0) {
            System.out.println(word);
        } else if(sum > 0) {
            if(prevChar == '1') {
                printCombinations(sum -1, word + "1", '1');
                printCombinations(sum -2, word + "2", '2');
            } else {
                printCombinations(sum -1, word + "1", '1');
            }
        }
    }

    private static int countCombinations(int sum, char prevChar) {
        if(sum == 0) return 1;
        int n = 0;

        if(prevChar == '1' && sum > 1)
            n += countCombinations(sum -1, '1') + countCombinations(sum - 2, '2');
        else
            n += countCombinations(sum -1, '1');

        return n;
    }

    private static int countCombinationsDP(int sum, int prevChar, int dp[][]) {
        if(dp[sum][prevChar] != -1)
            return dp[sum][prevChar];

        if(sum == 0) return 1;
        int n = 0;

        if(prevChar == 0 && sum > 1)
            n += countCombinationsDP(sum -1, 0, dp) + countCombinationsDP(sum -2, 1, dp);
        else
            n += countCombinationsDP(sum -1, 0, dp);

        return dp[sum][prevChar] = n;
    }



}

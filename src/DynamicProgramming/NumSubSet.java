package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSubSet {

    public static int numSubSet(List<Integer> solution, int sum) {
        return numSubSetRecursive(solution, sum, solution.size() -1);
    }

    private static int numSubSetRecursive(List<Integer> solution,
                                          int sum, int index) {
        if(sum == 0) return 1;
        else if(sum < 0 || index < 0) return 0;
        else if(solution.get(index) > sum) {
            return numSubSetRecursive(solution, sum, index -1);
        }else {
            return numSubSetRecursive(solution, sum - solution.get(index), index -1) +
                    numSubSetRecursive(solution, sum, index -1);
        }
    }


    public static int numSubSetDP(List<Integer> solution, int sum) {

        solution.add(0,0);
        int dp[][] = new int[sum +1][solution.size()];

        for(int i = 0; i < solution.size(); i++)
            dp[0][i] = 1;

        for(int i = 0; i <= sum; i++)
            dp[i][0] = 0;

        /*for(int i = 0; i <= sum; i++)
            for(int j = 1; j < solution.size(); j++) {
                dp[i][j] = (solution.get(j) > i) ? dp[i][j -1] :
                        ((1 + dp[i][j -1]) + dp[i - solution.get(j)][j -1])
            }*/
        return 0;


    }
    public static void main(String args[]) {
        System.out.println(numSubSet(Arrays.asList(2,4,6,10,12), 16));
    }
}

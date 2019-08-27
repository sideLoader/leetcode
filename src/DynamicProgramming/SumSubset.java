package DynamicProgramming;

/**
 * Created by vdep on 28/4/18.
 */
public class SumSubset {

    static boolean isSubsetRecursion(int arr[], int size, int sum) {
        if(sum == 0) return true;
        if(sum != 0 && size == 0) return false;

        if(arr[size -1] > sum)
            return isSubsetRecursion(arr, size -1, sum);

        return isSubsetRecursion(arr, size -1, sum) ||
                isSubsetRecursion(arr, size -1, sum - arr[size -1]);
    }

    static boolean isSubsetDP(int arr[], int size, int sum) {

        //dp[i][j] -> true if sum of (i) exists with subset of [0,1,...,j -1]
        boolean dp[][] = new boolean[sum +1][size +1];

        for(int i = 0; i <= sum; i++)
            dp[i][0] = false;

        for(int i = 1; i <= size; i++)
            dp[0][i] = true;

        for(int i = 1; i <= sum; i++)
            for(int j = 1; j <= size ;j++) {
               if(i >= arr[j -1]) {
                   dp[i][j] = dp[i][j] || dp[i - arr[j -1]][j -1];
               } else {
                   dp[i][j] = dp[i][j -1];
               }
            }

        return dp[sum][size];
    }

    public static void main(String args[]) {
        int set[] = new int[]{3,34,4,12,5,2};
        int sum = 9;

        System.out.println(isSubsetDP(set, set.length, sum));
    }
}

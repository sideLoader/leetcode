package DynamicProgramming;
/*
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vdep on 4/5/18.
 *//*
public class Dungeon {

    int getMinHealthDP(int dungeon[][]) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int dp[][] = new int[m][n];
        dp[m -1][n -1] = Math.max(1 - dungeon[m -1][n -1], 1);

        for(int i = m -2; i >= 0; i--)
            dp[i][n -1] = Math.max(dp[i +1][n -1] - dungeon[i][n -1], 1);

        for(int j = n -2; j >= 0; j--)
            dp[m -1][j] = Math.max(dp[m -1][j +1] - dungeon[m -1][j], 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(
                        Math.max(dp[i + 1][j] - dungeon[i][j], 1),
                        Math.max(dp[i][j + 1] - dungeon[i][j], 1)
                    );
            }
        }

        return dp[0][0];

    }

    int m,n;
    HashMap<Integer, LinkedList<Integer>> solution;

    void getMinHealth(int dungeon[][]) {
        m = dungeon.length;
        n = dungeon[0].length;
        solution = new HashMap<>();
        getMinHealth(dungeon, 0, 0, new LinkedList<>(Arrays.asList(dungeon[0][0])));

        int min = solution.keySet().stream().mapToInt(x -> x).min().getAsInt();
        System.out.println(min);
        solution.get(min).forEach(x -> System.out.print(x + " "));
    }

    void getMinHealth(int dungeon[][], int i, int j, LinkedList<Integer> path) {
        if(i == m -1 && j == n -1) {
            addToSolution(path);
        } else {
            for(Pair<Integer, Integer> curr : Arrays.asList(new Pair(i +1,j), new Pair(i, j +1))) {
                int k = curr.getKey(), v = curr.getValue();
                if(k >= m || v >= n) continue;

                path.addLast(dungeon[k][v]);
                getMinHealth(dungeon, k, v, path);
                path.removeLast();
            }
        }
    }

    void addToSolution(LinkedList<Integer> path) {
        int cumSum = 0, min = Integer.MAX_VALUE;
        for(int curr : path) {
            cumSum += curr;
            if(cumSum < min) min = cumSum;
        }
        min = (min < 0) ? (-min +1) : min;
        solution.put(min, new LinkedList<>(path));
    }



    public static void main(String args[]) {
        int dungeon[][] = new int[][]{
                {-2, -3, 3, 5},
                {-5, -10, 1, -12},
                {10, 30, -5, 4},
                {5,  -3, 2,  -8}
            };

        Dungeon obj = new Dungeon();
       //System.out.println(obj.getMinHealthDP(dungeon));
        obj.getMinHealth(dungeon);
    }
}
*/






















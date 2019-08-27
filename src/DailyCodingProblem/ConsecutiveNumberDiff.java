package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsecutiveNumberDiff {

    public static int[] numsConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<>();

        if(N == 0) return new int[0];
        if(N == 1) list.add(0);

        dfs(N, K, list, 0);
        return list.stream().mapToInt(x -> x).toArray();
    }

    private static void dfs(int N, int K, List<Integer> list, int num) {
        if(N == 0) {
            list.add(num);
        } else {
            for(int i = 0; i <= 9; i++) {
                if(i == 0 && num == 0)
                    continue;

                else if(num == 0 && i != 0)
                    dfs(N -1, K, list, i);

                else {
                    if(Math.abs(num%10 - i) == K)
                        dfs(N -1, K, list, (num * 10) + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 3;
        int K = 7;

        Arrays.stream(numsConsecDiff(N, K))
                .forEach(System.out::println);
    }
}

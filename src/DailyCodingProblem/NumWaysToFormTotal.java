package DailyCodingProblem;



import java.util.*;

public class NumWaysToFormTotal {

    static int count = 0;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void numWays(int total, int k, int start) {
        String key = total + "," +k;
        if(map.containsKey(key)) {
            count += map.get(key);
        } else {
            if (total == 0) {
                count++;
                map.put(key, count);
            } else if (total > 0) {
                for (int i = start; i <= k; i++) {
                    if (total >= i)
                        numWays(total - i, k, i);
                }
            }
        }
    }

    public static int ways(int total, int k) {
        numWays(total, k, 1);
        return count % 1000000007;
    }

    public static void main(String[] args) {
        int total = 58, k = 5;
        System.out.println(ways(total, k));
    }
}

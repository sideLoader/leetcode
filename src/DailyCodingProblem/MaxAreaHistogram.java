package DailyCodingProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxAreaHistogram {

    private static int maxArea(int input[]) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            ArrayList<Integer> existing = map.get(input[i]);
            existing.add(i);
            map.put(input[i], existing);
        }

        for(int i = 0; i < input.length; i++) {}

        return 0;
    }

    public static void main(String[] args) {
        int input[] = {1,2,3,4,5,3,3,2};
        System.out.println(maxArea(input));
    }
}

package DailyCodingProblem;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateWords {

    static int count = 0;

    public static void main(String[] args) {
        int length = 3;

        int nums[] = {4,5,6,7};
        Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2- o1);
                System.out.println(generateWords(length, 'v'));
    }

    private static int generateWords(int length, char lastChar) {
        if(length == 0) {
            count++;
        } else {
            if(lastChar != 'p') {
                generateWords(length -1, 'v');
                generateWords(length -1, 'p');
            } else {
                generateWords(length -1, 'v');
            }
        }

        return count;
    }
}

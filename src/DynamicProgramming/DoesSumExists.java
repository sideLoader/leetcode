package DynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DoesSumExists {

    private static void isExists(int[] input, int sum, LinkedList<Integer> solution, int index) {
        if(sum == 0) {
            solution.forEach(x -> System.out.print(x + " "));
        } else if(index < input.length) {

            solution.add(input[index]);
            isExists(input, sum - input[index], solution, index +1);

            solution.removeLast();
            isExists(input, sum, solution, index +1);
        }
    }

    public static void main(String[] args) {
        int input[] = {3, 2, 7, 1};
        int sum = 6;

        isExists(input, sum, new LinkedList<>(), 0);
    }

}

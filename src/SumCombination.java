
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class SumCombination {

    public void sumCombinations(int input[], int sum) {
        Arrays.sort(input);
        sumCombinations(input, sum, 0, new LinkedList<>());
    }

    private void sumCombinations(int input[], int sum, int start, LinkedList<Integer> current) {
        if(sum == 0) {
            current.stream().forEach(x -> System.out.print(x + " "));
            System.out.println();
        } else if(sum > 0) {
            // without start -> repeatable + permutations are considered as different colution
            for (int i = start; i < input.length; i++) {
                current.add(input[i]);
                sumCombinations(input, sum - input[i], i +1, current);
                //sumCombinations(input, sum - input[i], i , current); -> with repeatable
                current.remove(current.size() - 1);
            }

        }
    }
    public static void main(String args[]) {
        int input[] = new int[] {10,1,2,7,6,1,5};

        HashSet<Integer> d = new HashSet<>();
        SumCombination combinations = new SumCombination();
        combinations.sumCombinations(input, 8);
    }
}

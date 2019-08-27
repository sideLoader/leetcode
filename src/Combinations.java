import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.LinkedList;

public class Combinations {

    void generate(int input[], int start, int size, ArrayList<Integer> solution) {
        if(size == 3) {
            solution.forEach(x -> System.out.print(x + " "));
            System.out.println();
        } else {
            for(int i = start; i < input.length; i++) {
                solution.add(input[i]);
                generate(input, i +1, size +1, solution);
                solution.remove(solution.size() -1);
            }
        }
    }

    void combinations(int input[], String soFar, int index, ArrayList<String> solution) {
        int prev = -1;
        for(int i = index; i < input.length; i++) {

            if(soFar.charAt(i) != prev) {
                soFar += input[i];
                solution.add(soFar);
                combinations(input, soFar, index + 1, solution);
                soFar = soFar.substring(0, soFar.length() - 1);
            }
            prev = soFar.charAt(i);

        }

    }

    public static void main(String args[]) {
        Combinations combinations = new Combinations();
        //combinations.generate(new int[]{1,2,3,4,5}, 0,0, new ArrayList<>());

        ArrayList<String> solution = new ArrayList<>();
        combinations.combinations(new int[]{1,2,3}, "", 0, solution);
        solution.forEach(System.out::println);
    }
}

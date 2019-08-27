package DailyCodingProblem;

public class Combination {

    public static void printCombination(int input[], int size, String soFar, int start) {
        if(size == 3) {
            System.out.println(soFar);
        } else {
            for(int i = start; i < input.length; i++) {
                soFar += input[i];
                printCombination(input, size +1, soFar, i +1);
                soFar = soFar.substring(0, soFar.length() -1);
            }
        }
    }

    public static void printPermutation(int input[], int size, String soFar) {
        if(size == 3) {
            System.out.println(soFar);
        } else {
            for(int i = 0; i < input.length; i++) {
                soFar = soFar + input[i];

            }
        }
    }

    public static void main(String[] args) {
        int input[] = new int[]{1,2,3,4,5};
        //printPermutation(input,0, "", 0);
       // printCombination(input, 0, "", 0);
    }
}

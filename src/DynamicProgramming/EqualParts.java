package DynamicProgramming;

import java.util.ArrayList;

public class EqualParts {

    private static boolean isEqualParts(int[] input) {
        return isEqualParts(input, 0, 0, 0);
    }

    private static boolean isEqualParts(int input[], int index, int lSum, int rSum) {
        if(index > input.length) {
            return false;
        } else {
            if(index == input.length) {
                return (lSum == rSum) ? true : false;
            } else {
                return isEqualParts(input, index + 1, lSum + input[index], rSum) ||
                    isEqualParts(input, index + 1, lSum, rSum + input[index]);
            }
        }

    }


    public static void main(String[] args) {
        int input[] = new int[]{6,8,4,2};
        System.out.println(isEqualParts(input));
    }


}

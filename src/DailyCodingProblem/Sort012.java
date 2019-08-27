package DailyCodingProblem;

import java.util.Arrays;

public class Sort012 {


    static void sort(int input[]) {
        int size = input.length;

        int l = 0, mid = 0, h = size -1, temp;

        while(mid <= h) {
            if(input[mid] == 0) {
                temp = input[l];
                input[l] = input[mid];
                input[mid] = temp;
                l++;
                mid++;
            } else if(input[mid] == 1) {
                mid++;
            } else {
                temp = input[mid];
                input[mid] = input[h];
                input[h] = temp;
                h--;
            }
        }
    }

    public static void main(String[] args) {
        int input[] = {0,0,1,2,1,2,2,1,0,2,1,2};
        sort(input);

        for(int i : input)
            System.out.print(i + " ");

    }
}

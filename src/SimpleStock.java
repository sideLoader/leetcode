

public class SimpleStock {

    public static void main(String args[]) {
        int input[] = new int[]{1,2,4};
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 1; i < input.length; i++) {
            if(input[i -1] - input[i] < min) {
                min = input[i -1] - input[i];
                minIndex = i -1;
            }
        }

        int max = 0;
        for(int i = minIndex; i < input.length; i++)
            if(input[i] > max) max = input[i];

        System.out.println(max - input[minIndex]);
    }
}

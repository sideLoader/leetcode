package DailyCodingProblem;

public class RainWaterTrapping {

    static int trapWater(int input[]) {
        int n = input.length;
        int lHigh[] = new int[n];
        int rHigh[] = new int[n];
        int max = input[0];

        for(int i = 0; i < n -1; i++) {
            if (input[i] > max) max = input[i];
            lHigh[i] = max;
        }

        max = input[n -1];
        for(int i = n -1; i >= 0; i--) {
            if(input[i] > max) max = input[i];
            rHigh[i] = max;
        }

        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            int min = Math.min(lHigh[i], rHigh[i]);
            if(input[i] <= min)
                totalSum += min - input[i];
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int input[] = {3,0,0,10,0,5};

        System.out.println(trapWater(input));
    }
}

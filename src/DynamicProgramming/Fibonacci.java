package DynamicProgramming;


public class Fibonacci {

    static int fibonacciRecursion(int num) {
        if(num == 0) return 0;
        if(num == 1) return 1;

        return fibonacciRecursion(num -1) +
               fibonacciRecursion(num -2);
    }

    static int fibonacciBottomUp(int num) {
        int sol[] = new int[100];
        sol[0] = 0;
        sol[1] = 1;

        for(int i = 2; i <= num; i++)
            sol[i] = sol[i -1] + sol[i -2];

        return sol[num];
    }

    static int memo[] = new int[100];
    static int fibonacciTopDown(int num) {
        if(num == 0) return 0;
        if(num == 1) return 1;

        if(memo[num] != 0) return memo[num];

        return memo[num] = fibonacciTopDown(num -1) +
                           fibonacciTopDown(num -2);

    }
    public static void main(String args[]) {
        System.out.println(fibonacciRecursion(6));
        System.out.println(fibonacciBottomUp(6));
        System.out.println(fibonacciTopDown(6));
    }
}

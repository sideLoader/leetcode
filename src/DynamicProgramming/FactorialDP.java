package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FactorialDP {

    Map<Integer, Integer> lookup = new HashMap<>();

    int factorialTopDown(int num) {
        if(!lookup.containsKey(num)) {
            if(num <= 1) lookup.put(num, 1);
            else lookup.put(num, num * factorialTopDown(num -1));
        }
        return lookup.get(num);

    }

    int factorialBottomUp(int num) {
        int fact[] = new int[num + 1];
        fact[0] = 0;
        fact[1] = 1;
        for(int i = 2; i <= num; i++)
            fact[i] = i * fact[i -1];

        return fact[num];
    }

    public static void main(String args[]) {

        System.out.println(new FactorialDP().factorialBottomUp(5));

    }
}

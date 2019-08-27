package DailyCodingProblem;

import java.util.*;
import java.util.stream.Collectors;

public class InputOutputTest {

    public static void test(int n) {
        if(n <= 0) return;

        test(n -1);
        System.out.println(n);

    }

    public static void main(String[] args) {

        test(5);

    }
}
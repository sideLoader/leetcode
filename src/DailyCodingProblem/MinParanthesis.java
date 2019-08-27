package DailyCodingProblem;

import java.util.*;

public class MinParanthesis {

    static private boolean isBalanced(String str) {
        int cnt = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') cnt++;
            else if(str.charAt(i) == ')') cnt--;
            if(cnt < 0) return false;
        }

        return cnt == 0;
    }

    static List<String> changeParanthesis(String input) {
        Set<String> solution = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(input);

        while(!queue.isEmpty()) {
            String current = queue.poll();

            if(isBalanced(current)) {
                solution.add(current);
            } else {
                for (int i = 0; i < current.length(); i++) {
                    String temp;
                    if (current.charAt(i) == '(' || current.charAt(i) == ')') {
                        temp = current.substring(0, i) + current.substring(i + 1);
                        queue.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(solution);
    }

    static int countParanthesis(String input) {
        int count = 0;
        for(char temp : input.toCharArray())
            if(temp == '(' || temp == ')')
                count++;

        return count;
    }

    public static void main(String[] args) {
        String input = "(a)()))(b)";
        int total = countParanthesis(input);

        changeParanthesis(input).forEach(x ->
            System.out.println((total - countParanthesis(x)) + " -> " + x)
        );
    }
}

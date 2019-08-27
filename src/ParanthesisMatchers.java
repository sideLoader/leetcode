import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParanthesisMatchers {

    static Map<Character, Character> matchers = new HashMap<>();

    static void fill() {
        matchers.put('{','}');
        matchers.put('(',')');
        matchers.put('[',']');
    }

    static boolean isBalanced(String input) {
        fill();
        Stack<Character> stack = new Stack<>();

        for(char current : input.toCharArray()) {
            if(matchers.values().contains(current)) {
                if (matchers.get(stack.pop()) != current) {
                    return false;
                }
            } else {
                stack.push(current);
            }
        }

        return stack.size() == 0;
    }

    public static void main (String[] args) {
        String input = "{{}}(({}))";
        System.out.println(isBalanced(input));
    }
}

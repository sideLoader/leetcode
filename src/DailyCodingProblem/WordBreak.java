package DailyCodingProblem;

import java.util.*;

public class WordBreak {

    static Set<String> words = new HashSet<>(Arrays.asList("i","like","sam","sung","samsung","mobile","ice",
        "cream","icecream","man","go","mango"));

    static HashMap<String, Boolean> map = new HashMap<>();

    private static boolean wordBreak(String input) {
        if(input.length() == 0) return true;

        for(int i = 1; i <= input.length(); i++) {
            String currentWord = input.substring(0, i);

            if(words.contains(currentWord)) {
                if(wordBreak(input.substring(i)))
                    return true;
            }
        }

        return false;
    }

   /* private static boolean wordBreakDP(String input) {
        if(input.length() == 0) return true;

    }  */

    public static void main(String[] args) {
        String input = "ilikeesamsung";
        System.out.println(wordBreak(input));
    }
}

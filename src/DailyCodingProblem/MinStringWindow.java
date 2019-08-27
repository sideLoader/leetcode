package DailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

public class MinStringWindow {

    static String minWindow(String str, String pattern) {
        if(pattern.length() > str.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for(char temp : str.toCharArray()) map.put(temp, 0);

        for(char temp : pattern.toCharArray())
            if(map.containsKey(temp))
                map.merge(temp,  1, (a, b) -> a + b);
            else
                return "";

        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE, minStart = 0;
        int numOfTarget = pattern.length();


        while(end < str.length()) {
            char c = str.charAt(end);

            if(map.get(c) > 0)
                numOfTarget--;
            map.put(c, map.get(c) -1);

            while(numOfTarget == 0) {
                if(end - start +1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char head = str.charAt(start);
                if(map.get(head) >= 0)
                    numOfTarget++;

                map.put(head, map.get(head) +1);
                start++;
            }
            end++;
        }


        return (minLen == Integer.MAX_VALUE) ? "" : str.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String str = "ABAACBAB";
        String pattern = "ABC";

        System.out.println(minWindow(str, pattern));

    }
}

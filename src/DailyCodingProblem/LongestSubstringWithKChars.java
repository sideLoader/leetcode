package DailyCodingProblem;

import java.util.Arrays;

public class LongestSubstringWithKChars {

    private static boolean isValid(int input[], int k) {
        int count = 0;
        for(int i = 0; i < 26; i++)
            if(input[i] > 0)
                count++;

        return (k >= count);
    }

    private static void longestSubstring(String word, int k) {
        if(word.isEmpty()) return;

        int n = word.length();
        int count[] = new int[26];
        Arrays.fill(count, 0);

        int uniqueChars = 0;
        for(int i = 0; i < n; i++) {
            count[word.charAt(i) - 'a']++;

            if(count[word.charAt(i) - 'a'] > 0)
                uniqueChars++;
        }

        if(uniqueChars < k) {
            System.out.println("not enough unique chars");
            return;
        }

        Arrays.fill(count, 0);
        int max = Integer.MIN_VALUE, start = 0, end = 0;
        int max_start = 0;

        count[word.charAt(0) - 'a']++;

        for(int i = 1; i < n; i++) {
            count[word.charAt(i) - 'a']++;
            end++;

            while(!isValid(count, k)) {
                count[word.charAt(i) - 'a']--;
                start++;
            }

            if(end - start +1 > max) {
                max = end - start + 1;
                max_start = start;
            }
        }

        System.out.println("length : " + max);
        System.out.println(word.substring(max_start, max_start + max));
    }

    public static void main(String[] args) {
        String input = "aabbcc";
        int k = 2;

        longestSubstring(input, k);
    }
}

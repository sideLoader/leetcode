package DailyCodingProblem;

import java.util.*;

public class WordLadder {

    private static class Node {
        String word;
        int distance;

        public Node(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
    }

    public static int ladderLength(String beginWord, String endWord, HashSet<String> wordList) {
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node(beginWord, 1));

        while(!list.isEmpty()) {
            Node current = list.removeFirst();

            if(current.word.equals(endWord)) {
                return current.distance;
            } else {
                char word[] = current.word.toCharArray();

                for(int i = 0; i < word.length; i++)  {
                    for(char j = 'a'; j <= 'z'; j++) {
                        char temp = word[i];
                        word[i] = j;

                        String newWord = String.valueOf(word);
                        if(wordList.contains(newWord)) {
                            list.add(new Node(newWord, current.distance +1));
                            wordList.remove(newWord);
                        }

                        word[i] = temp;
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";

        System.out.println(ladderLength(start, end,
                new HashSet(Arrays.asList("hot","dot","dog","lot","log","cog")))
        );
    }
}

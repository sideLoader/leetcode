import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() { root = new TrieNode(); }

    void insert(String word) {
        TrieNode current = root;
        for(char currentChar : word.toCharArray()) {
            TrieNode node = current.children.get(currentChar);
            if(node == null) {
                node = new TrieNode();
                current.children.put(currentChar, node);
            }
            current = node;
        }
        current.isEnd = true;
    }

    boolean search(String word) {
        TrieNode current = root;
        for(char currentChar : word.toCharArray()) {
            TrieNode node = current.children.get(currentChar);

            if(node == null) return false;
            current = node;
        }
        return current.isEnd;
    }


    void printWords() { printWords(root, "", ""); }

    void printWords(TrieNode current, String word, String prefix) {
        if(current.isEnd)
            System.out.println(prefix + word);

        for(char currentChar : current.children.keySet()) {
            word = word + currentChar;
            printWords(current.children.get(currentChar), word, prefix);
            word = word.substring(0, word.length() -1);
        }

    }

    void printPrefix(String prefix) {
        TrieNode current = root;
        for(char currentChar : prefix.toCharArray()) {
            TrieNode node = current.children.get(currentChar);
            if(node == null) {
                node = new TrieNode();
                current.children.put(currentChar, node);
            }
            current = node;
        }
        printWords(current, "", prefix);
    }

    public boolean wordBreak(String input) {
        if(input.isEmpty()) return true;

        String soFar = "";
        boolean result = false;
        List<Integer> solutionIndex = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            soFar += currentChar;
            result = search(soFar);

            if(result) {
                solutionIndex.add(i +1);
                soFar = "";
            }
        }

        if(result) solutionIndex.forEach(x -> System.out.print(x + " "));
        return result;
    }

    public static void main(String args[]) {
        Trie trie = new Trie();
        /*List<String> words = Arrays.asList("vdep","vd","vae","simple", "sim", "simtre", "simaa");
        words.stream().forEach(word -> trie.insert(word));

        //System.out.println(trie.search("simtre"));
        trie.printPrefix("v"); */

        Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango")
                .forEach(x ->  trie.insert(x));

        String input = "ilikesamsung";

        System.out.println(trie.wordBreak(input));

    }

}

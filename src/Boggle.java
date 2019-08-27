import java.util.Arrays;

public class Boggle {
/*
    private boolean findWordUtil(int i, int j, char boogle[][],
                              boolean isVisited[][], Trie trie, String solution) {
        int m = boogle.length;
        int n = boogle[0].length;

        if(i >= m || j >= n || i < 0 || j < 0) return false;



    }  */

    public void findWords(char boogle[][], Trie trie) {
        int m = boogle.length;
        int n = boogle[0].length;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {}
               // findWordUtil(i, j, boogle, trie);
    }

    public static void main(String args[]) {
        char boogle[][] = {
                {'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}
            };

        Trie trie = new Trie();
        Arrays.asList("GEEKS","FOR","QUIZ","GO")
                .forEach(x -> trie.insert(x));

        int input[] = new int[]{4,7,6,9,10};
    }

}

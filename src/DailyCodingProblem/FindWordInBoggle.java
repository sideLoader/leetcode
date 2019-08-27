package DailyCodingProblem;

public class FindWordInBoggle {

    class Pair {
        int a,b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private Pair findChar(char board[][], int x, int y, char target) {
        for(int i = x; i < board.length; i++) {
            for(int j = y; j < board[0].length; j++) {
                if(board[i][j] == target)
                    return new Pair(i, j);
            }
        }

        return null;
    }


    private boolean exist(char[][] board, String word, boolean[][] isVisited,
                          int x, int y, int m) {

        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        } else if(m == word.length() -1 && board[x][y] == word.charAt(m)) {
            return true;
        } else {

            if(word.charAt(m) == board[x][y]) {
                isVisited[x][y] = true;

                if(exist(board, word, isVisited, x +1, y, m +1)) return true;
                if(exist(board, word, isVisited, x -1, y, m +1)) return true;
                if(exist(board, word, isVisited, x, y +1, m +1)) return true;
                if(exist(board, word, isVisited, x, y -1, m +1)) return true;

                isVisited[x][y] = false;
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean flag = true;
        int i = 0, j = 0;
        while(flag) {
            if(i >= board.length || j >= board[0].length)
                return false;

            Pair current = findChar(board, i, j, word.charAt(0));
            i = current.a;
            j = current.b;

            boolean isVisited[][] = new boolean[board.length][board[0].length];
            if(exist(board, word, isVisited, i, j, 1))
                return true;

        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        FindWordInBoggle object = new FindWordInBoggle();
        System.out.println(object.exist(board, "SEE"));

    }
}

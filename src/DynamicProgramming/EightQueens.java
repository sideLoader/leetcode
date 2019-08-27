package DynamicProgramming;

public class EightQueens {

    static boolean isSafe(int board[][], int row, int column) {

        int i, j;

        /* Check this row on left side */
        for (i = 0; i < column; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=column; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=column; j>=0 && i<board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean solveBoard(int board[][], int column) {
        if(column >= board.length)
            return true;

        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, i, column)) {
                board[i][column] = 1;

                if(solveBoard(board, column +1))
                    return true;

                board[i][column] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int board[][] = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        if(solveBoard(board, 0) == false) {
            System.out.println("no solution");
            return;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

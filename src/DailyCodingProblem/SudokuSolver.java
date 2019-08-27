package DailyCodingProblem;

public class SudokuSolver {

    static int N = 9;

    private boolean isSafe(int board[][], int row, int column, int candidate) {

        for(int i = 0; i < N; i++)
            if(board[row][i] == candidate)
                return false;

        for(int i = 0; i < N; i++)
            if(board[i][column] == candidate)
                return false;

        int sqr = (int)Math.sqrt(N);
        int boxStartRow = row - (row % sqr);
        int boxStartCol = column - (column % sqr);

        for(int i = boxStartRow; i < boxStartRow + sqr; i++)
            for(int j = boxStartCol; j < boxStartCol + sqr; j++)
                if(board[i][j] == candidate)
                    return false;

        return true;
    }

    private boolean solve(int board[][]) {
        int row = 0, column = 0;
        boolean isEmpty = true;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0) {
                    row = i;
                    column = j;

                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty) break;
        }

        if(isEmpty) return true;

        for(int i = 0; i <= 9 ; i++) {
            if(isSafe(board, row, column, i)) {
                board[row][column] = i;

                if(solve(board)) return true;

                board[row][column] = 0;
            }
        }

        return false;
    }

    private void print(int board[][]) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SudokuSolver sudoku = new SudokuSolver();

        int[][] board = new int[][]
                {
                        {3, 0, 0, 0, 4, 0, 0, 0, 7},
                        {0, 0, 1, 5, 0, 9, 4, 0, 0},
                        {0, 6, 0, 0, 0, 0, 0, 9, 0},
                        {0, 2, 0, 3, 0, 8, 0, 4, 0},
                        {5, 0, 0, 0, 0, 0, 0, 0, 9},
                        {0, 7, 0, 4, 0, 5, 0, 2, 0},
                        {0, 1, 0, 0, 0, 0, 0, 8, 0},
                        {0, 0, 4, 7, 0, 6, 1, 0, 0},
                        {8, 0, 0, 0, 5, 0, 0, 0, 4}
                };

        if(sudoku.solve(board)) {
            sudoku.print(board);
        } else {
            System.out.println("solution doesnt exists");
        }
    }
}

package DailyCodingProblem;

public class Maze {

    static int M = 7;
    static int N = 7;
    static int solution = 0;

    static boolean printPath(int input[][], int x, int y, int path[][]) {

        if(x >= M || y >= N || x < 0 || y < 0) {
            return false;
        } else if(x == M -1 && y == N -1) {
            path[x][y] = 1;

            solution ++;
            System.out.println("Solution " + solution + ":");
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) { System.out.print(path[i][j] + " "); }
                System.out.println();
            }
            System.out.println("\n");
        } else {

            if(input[x][y] == 1 && path[x][y] == 0) {
                path[x][y] = 1;

                if (printPath(input, x + 1, y, path)) return true;
                if (printPath(input, x, y + 1, path)) return true;
                if (printPath(input, x - 1, y, path)) return true;
                if (printPath(input, x, y - 1, path)) return true;

                path[x][y] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = {
                {1,1,1,1,1,1,1},
                {1,0,1,0,0,0,1},
                {1,0,1,1,1,1,1},
                {1,0,1,0,1,0,1},
                {1,0,1,0,1,1,1},
                {1,0,1,1,1,0,1},
                {0,1,0,1,0,0,1}
        };

        if(!printPath(maze, 0,0, new int[M][N]))
            System.out.println("There is no solution");
    }
}

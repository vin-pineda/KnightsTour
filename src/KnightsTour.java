class KnightsTour {
    static int N = 5;
    static int startRow = 2;
    static int startCol = 2;
    static boolean isValid(int x, int y, int[][] board)
    {
        return (x >= 0 && x < N && y >= 0 && y < N
                && board[x][y] == -1);
    }

    static void printSolution(int[][] sol)
    {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    static void solveTour()
    {
        int[][] solve = new int[5][5];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                solve[x][y] = -1;

        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

        solve[startRow][startCol] = 0;

        if (!solve(startRow, startCol, 1, solve, xMove, yMove)) {
            System.out.println("No Possible Solutions");
        }
        else
            printSolution(solve);

    }

    static boolean solve(int x, int y, int moveTemp, int[][] board, int[] xMove, int[] yMove)
    {
        int i, xN, yN;
        if (moveTemp == N * N)
            return true;

        for (i = 0; i < 8; i++) {
            xN = x + xMove[i];
            yN = y + yMove[i];
            if (isValid(xN, yN, board)) {
                board[xN][yN] = moveTemp;
                if (solve(xN, yN, moveTemp + 1,
                        board, xMove, yMove))
                    return true;
                else
                    board[xN][yN]
                            = -1;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        solveTour();
    }
}
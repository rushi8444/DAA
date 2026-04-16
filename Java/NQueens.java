public class NQueens {

    static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static boolean solveNQueens(int[][] board, int row, int n) {
        // Base case: all queens placed
        if (row == n)
            return true;

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (solveNQueens(board, row + 1, n))
                    return true;

                board[row][col] = 0; // Backtrack
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];

        if (solveNQueens(board, 0, n)) {
            System.out.println("Solution exists:");
            printBoard(board, n);
        } else {
            System.out.println("No solution exists");
        }
    }
}
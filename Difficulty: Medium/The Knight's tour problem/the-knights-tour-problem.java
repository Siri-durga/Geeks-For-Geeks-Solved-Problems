import java.util.*;

class Solution {

    // Possible moves for a knight
    private final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(n, -1));
            board.add(row);
        }

        board.get(0).set(0, 0); // Start position

        if (solve(board, n, 0, 0, 1)) {
            return board;
        } else {
            // No solution possible
            return new ArrayList<>();
        }
    }

    // Recursive backtracking
    private boolean solve(ArrayList<ArrayList<Integer>> board, int n, int x, int y, int move) {
        // Base case: all squares are visited
        if (move == n * n) return true;

        // Try all 8 moves
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isSafe(board, n, nextX, nextY)) {
                board.get(nextX).set(nextY, move);

                if (solve(board, n, nextX, nextY, move + 1))
                    return true;

                // Backtrack
                board.get(nextX).set(nextY, -1);
            }
        }
        return false;
    }

    // Check if the move is valid
    private boolean isSafe(ArrayList<ArrayList<Integer>> board, int n, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n && board.get(x).get(y) == -1);
    }

    // For testing purpose
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 5;
        ArrayList<ArrayList<Integer>> result = sol.knightTour(n);

        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            for (ArrayList<Integer> row : result) {
                System.out.println(row);
            }
        }
    }
}

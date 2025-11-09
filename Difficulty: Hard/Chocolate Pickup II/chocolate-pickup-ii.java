import java.util.*;

class Solution {
    int n;
    int[][] grid;
    Integer[][][] dp;

    public int chocolatePickup(int[][] mat) {
        this.n = mat.length;
        this.grid = mat;
        this.dp = new Integer[n][n][n];

        int ans = helper(0, 0, 0);
        return Math.max(ans, 0); // If impossible, return 0
    }

    private int helper(int i1, int j1, int i2) {
        int j2 = i1 + j1 - i2;

        // Out of bounds or blocked
        if (i1 >= n || j1 >= n || i2 >= n || j2 >= n ||
            grid[i1][j1] == -1 || grid[i2][j2] == -1)
            return Integer.MIN_VALUE;

        // If both reached end
        if (i1 == n - 1 && j1 == n - 1)
            return grid[i1][j1];

        // Memoization
        if (dp[i1][j1][i2] != null)
            return dp[i1][j1][i2];

        int curr = 0;
        if (i1 == i2 && j1 == j2)
            curr = grid[i1][j1];
        else
            curr = grid[i1][j1] + grid[i2][j2];

        // Try all 4 move combinations
        int next = Math.max(
            Math.max(helper(i1 + 1, j1, i2 + 1), helper(i1, j1 + 1, i2 + 1)),
            Math.max(helper(i1 + 1, j1, i2), helper(i1, j1 + 1, i2))
        );

        curr += next;

        return dp[i1][j1][i2] = curr;
    }
}

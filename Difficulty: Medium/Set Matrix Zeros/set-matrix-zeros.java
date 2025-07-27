class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Check if first row or column has any zeros
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Use first row and column to mark zeros
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // Set zeros based on marks
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Zero first row and column if needed
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}

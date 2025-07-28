class Solution {
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        int totalSum = 0;
        int targetSum = 0;

        // Calculate row sums, column sums, total sum and find targetSum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
                totalSum += mat[i][j];
            }
        }

        // Find the maximum row sum or column sum
        for (int i = 0; i < n; i++) {
            targetSum = Math.max(targetSum, rowSum[i]);
            targetSum = Math.max(targetSum, colSum[i]);
        }

        // Calculate minimum number of operations
        return n * targetSum - totalSum;
    }
}

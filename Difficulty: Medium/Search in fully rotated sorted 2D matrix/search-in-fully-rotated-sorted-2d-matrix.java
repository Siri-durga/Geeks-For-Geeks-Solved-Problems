class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            int val = mat[row][col];

            if (val == x) return true;

            // find which half is sorted
            int lowRow = low / m, lowCol = low % m;
            int highRow = high / m, highCol = high % m;
            int lowVal = mat[lowRow][lowCol];
            int highVal = mat[highRow][highCol];

            if (lowVal <= val) {
                // left half sorted
                if (x >= lowVal && x < val) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right half sorted
                if (x > val && x <= highVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}

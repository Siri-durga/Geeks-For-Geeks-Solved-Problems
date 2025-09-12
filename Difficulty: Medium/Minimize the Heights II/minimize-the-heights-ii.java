import java.util.*;

class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0]; // initial difference

        int small = arr[0] + k;
        int big = arr[n - 1] - k;

        if (small > big) { 
            int temp = small;
            small = big;
            big = temp;
        }

        for (int i = 1; i < n; i++) {
            int subtract = arr[i] - k;
            int add = arr[i - 1] + k;

            if (subtract < 0) continue; // height can't be negative

            int newMin = Math.min(small, subtract);
            int newMax = Math.max(big, add);

            ans = Math.min(ans, newMax - newMin);
        }

        return ans;
    }
}

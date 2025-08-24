class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // Not enough flowers
        if ((long) m * k > arr.length) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int val : arr) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(arr, mid, k, m)) {
                ans = mid;
                high = mid - 1; // try smaller day
            } else {
                low = mid + 1;  // need more days
            }
        }
        return ans;
    }

    private boolean canMake(int[] arr, int day, int k, int m) {
        int bouquets = 0, flowers = 0;
        for (int val : arr) {
            if (val <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0; // reset because not consecutive
            }
        }
        return bouquets >= m;
    }
}

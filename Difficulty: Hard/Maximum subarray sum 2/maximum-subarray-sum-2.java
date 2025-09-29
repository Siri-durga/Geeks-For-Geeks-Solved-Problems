import java.util.*;

class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        
        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        
        int ans = Integer.MIN_VALUE;
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices of prefix sums
        
        for (int i = a; i <= n; i++) {
            // Add candidate l = i - a
            int idx = i - a;
            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[idx]) {
                dq.pollLast();
            }
            dq.addLast(idx);

            // Remove out-of-window (length > b)
            while (!dq.isEmpty() && dq.peekFirst() < i - b) {
                dq.pollFirst();
            }

            // Best subarray ending at i-1
            ans = Math.max(ans, (int)(prefix[i] - prefix[dq.peekFirst()]));
        }
        
        return ans;
    }
}

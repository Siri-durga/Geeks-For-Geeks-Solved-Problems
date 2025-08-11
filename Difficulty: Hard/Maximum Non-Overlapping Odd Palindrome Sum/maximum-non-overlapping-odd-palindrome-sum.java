import java.util.*;

class Solution {
    public int maxSum(String s) {
        int n = s.length();
        if (n < 2) return 0;

        // Manacher (odd palindromes)
        int[] d1 = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; ++i) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            d1[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }

        // leftmost and rightmost coverage of each center
        int[] R = new int[n], L = new int[n];
        for (int i = 0; i < n; ++i) {
            R[i] = i + d1[i] - 1;
            L[i] = i - d1[i] + 1;
        }

        // leftBest[t] = max odd palindrome length that ends at t
        int[] leftBest = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // smallest center index first
        for (int t = 0; t < n; ++t) {
            minHeap.add(t); // add center t when sweep reaches t
            while (!minHeap.isEmpty() && R[minHeap.peek()] < t) minHeap.poll();
            if (!minHeap.isEmpty()) {
                int ci = minHeap.peek();
                leftBest[t] = 2 * (t - ci) + 1;
            } else {
                leftBest[t] = 0;
            }
        }

        // rightBest[pos] = max odd palindrome length that starts at pos
        int[] rightBest = new int[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // largest center index first
        for (int pos = n - 1; pos >= 0; --pos) {
            maxHeap.add(pos); // add center pos when sweep reaches it
            while (!maxHeap.isEmpty() && L[maxHeap.peek()] > pos) maxHeap.poll();
            if (!maxHeap.isEmpty()) {
                int ci = maxHeap.peek();
                rightBest[pos] = 2 * (ci - pos) + 1;
            } else {
                rightBest[pos] = 0;
            }
        }

        // prefix / suffix maxima and best split
        int[] leftMax = new int[n];
        leftMax[0] = leftBest[0];
        for (int i = 1; i < n; ++i) leftMax[i] = Math.max(leftMax[i - 1], leftBest[i]);

        int[] rightMax = new int[n];
        rightMax[n - 1] = rightBest[n - 1];
        for (int i = n - 2; i >= 0; --i) rightMax[i] = Math.max(rightMax[i + 1], rightBest[i]);

        int ans = 0;
        for (int i = 0; i < n - 1; ++i) ans = Math.max(ans, leftMax[i] + rightMax[i + 1]);
        return ans;
    }
}

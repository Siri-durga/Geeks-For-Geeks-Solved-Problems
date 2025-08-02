import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] transformed = new int[n];
        
        // Step 1: Transform array
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) transformed[i] = 1;
            else transformed[i] = -1;
        }
        
        // Step 2: Track prefix sums
        HashMap<Integer, Integer> firstIndex = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        firstIndex.put(0, -1); // to handle case when prefixSum > 0 from start
        
        for (int i = 0; i < n; i++) {
            prefixSum += transformed[i];
            
            if (prefixSum > 0) {
                maxLength = i + 1; // entire subarray from 0 to i is valid
            } else {
                // We need earliest prefixSum < current prefixSum
                if (firstIndex.containsKey(prefixSum - 1)) {
                    int idx = firstIndex.get(prefixSum - 1);
                    maxLength = Math.max(maxLength, i - idx);
                }
            }
            
            // Store earliest occurrence of prefixSum
            firstIndex.putIfAbsent(prefixSum, i);
        }
        
        return maxLength;
    }
}

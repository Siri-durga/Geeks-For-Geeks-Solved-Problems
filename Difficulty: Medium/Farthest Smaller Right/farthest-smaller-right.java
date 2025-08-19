import java.util.*;

class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        int[] suffixMin = new int[n];
        
        // Step 1: build suffix min array
        suffixMin[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i+1]);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 2: binary search for each index
        for (int i = 0; i < n; i++) {
            int low = i+1, high = n-1;
            int ans = -1;
            
            while (low <= high) {
                int mid = (low + high) / 2;
                
                if (suffixMin[mid] < arr[i]) {
                    ans = mid;   // valid, but try to go farther
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            result.add(ans);
        }
        
        return result;
    }
}

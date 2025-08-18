import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;
        
        for (int i = 0; i < n; i++) {
            int papersWithAtLeast = n - i; // how many papers have >= citations[i]
            hIndex = Math.max(hIndex, Math.min(citations[i], papersWithAtLeast));
        }
        
        return hIndex;
    }
}

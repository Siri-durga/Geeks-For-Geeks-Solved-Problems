import java.util.*;

class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int required = (n + 1) / 2; // ceil(n / 2)
        
        int luckyCount = 0;
        ArrayList<Integer> addList = new ArrayList<>();
        
        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                luckyCount++;
            } else {
                int toAdd = k - (soldiers % k);
                addList.add(toAdd);
            }
        }
        
        if (luckyCount >= required) {
            return 0; // Already enough lucky troops
        }
        
        int need = required - luckyCount;
        Collections.sort(addList);
        
        int totalAdd = 0;
        for (int i = 0; i < need; i++) {
            totalAdd += addList.get(i);
        }
        
        return totalAdd;
    }
}

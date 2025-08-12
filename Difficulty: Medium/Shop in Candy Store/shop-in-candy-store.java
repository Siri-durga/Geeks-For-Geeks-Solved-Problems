import java.util.*;

class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices);
        int n = prices.length;

        int minCost = 0, maxCost = 0;

        // Minimum cost
        int start = 0, end = n - 1;
        while (start <= end) {
            minCost += prices[start];
            start++;
            end -= k; // take k from the most expensive side for free
        }

        // Maximum cost
        start = 0;
        end = n - 1;
        while (start <= end) {
            maxCost += prices[end];
            end--;
            start += k; // take k from the cheapest side for free
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minCost);
        result.add(maxCost);
        return result;
    }
}

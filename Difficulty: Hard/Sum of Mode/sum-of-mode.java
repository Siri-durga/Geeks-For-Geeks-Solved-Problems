import java.util.*;

class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();

        // helper to add element
        Runnable updateMax = () -> {};

        // add element
        java.util.function.Consumer<Integer> add = (num) -> {
            int old = freq.getOrDefault(num, 0);
            if (old > 0) {
                freqMap.get(old).remove(num);
                if (freqMap.get(old).isEmpty()) freqMap.remove(old);
            }
            int now = old + 1;
            freq.put(num, now);
            freqMap.computeIfAbsent(now, z -> new TreeSet<>()).add(num);
        };

        // remove element
        java.util.function.Consumer<Integer> remove = (num) -> {
            int old = freq.get(num);
            freqMap.get(old).remove(num);
            if (freqMap.get(old).isEmpty()) freqMap.remove(old);

            if (old == 1) {
                freq.remove(num);
            } else {
                int now = old - 1;
                freq.put(num, now);
                freqMap.computeIfAbsent(now, z -> new TreeSet<>()).add(num);
            }
        };

        // initialize first window
        for (int i = 0; i < k; i++) add.accept(arr[i]);

        int sum = 0;
        int maxFreq = freqMap.lastKey();
        int mode = freqMap.get(maxFreq).first();
        sum += mode;

        // slide the window
        for (int i = k; i < n; i++) {
            remove.accept(arr[i - k]);
            add.accept(arr[i]);

            maxFreq = freqMap.lastKey();
            mode = freqMap.get(maxFreq).first();
            sum += mode;
        }

        return sum;
    }
}

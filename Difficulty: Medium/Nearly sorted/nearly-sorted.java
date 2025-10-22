import java.util.*;

class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;

        // Step 1: Add first k+1 elements to the heap
        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            pq.add(arr[i]);
        }

        // Step 2: Process remaining elements
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = pq.poll(); // Get the smallest
            pq.add(arr[i]);           // Push next element
        }

        // Step 3: Extract remaining elements from heap
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
}

class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Store the last occurrence of each digit (0-9)
        int[] lastPos = new int[10];
        for (int i = 0; i < n; i++) {
            lastPos[arr[i] - '0'] = i;
        }

        // Traverse left to right
        for (int i = 0; i < n; i++) {
            int current = arr[i] - '0';

            // Look for a larger digit to swap with (check from 9 down to current+1)
            for (int d = 9; d > current; d--) {
                if (lastPos[d] > i) {  // found a larger digit to the right
                    // Swap
                    char temp = arr[i];
                    arr[i] = arr[lastPos[d]];
                    arr[lastPos[d]] = temp;
                    return new String(arr); // only one swap allowed
                }
            }
        }

        // No beneficial swap found
        return s;
    }
}
